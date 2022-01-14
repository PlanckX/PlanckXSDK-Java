package io.planckx.api.client.impl;

import io.planckx.api.client.exception.RequestException;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

/**
 * @author marcus
 * @version 1.0
 */
public class PlanckXClientServiceFactory {

    private static final OkHttpClient sharedClient;
    private static final Converter.Factory converterFactory = JacksonConverterFactory.create();

    private static final Converter<ResponseBody, RequestError> errorBodyConverter =
            (Converter<ResponseBody, RequestError>) converterFactory.responseBodyConverter(
                    RequestError.class, new Annotation[0], null);

    static {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(500);
        dispatcher.setMaxRequests(500);
        sharedClient =
                new OkHttpClient.Builder()
                        .dispatcher(dispatcher)
                        .pingInterval(20, TimeUnit.SECONDS)
                        .build();
    }

    public static <V> V createService(Class<V> serviceClass, APIOptions options) {
        return createService(
                serviceClass,
                options,
                options.isSignature() ? new PlanckXInterceptor(options) : null);
    }

    public static <V> V createService(Class<V> serviceClass, APIOptions options, Interceptor newInterceptor) {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(options.getRestHost())
                .addConverterFactory(converterFactory);

        if (newInterceptor == null) {
            retrofitBuilder.client(sharedClient);
        } else {
            OkHttpClient adaptedClient = sharedClient.newBuilder()
                    .addInterceptor(newInterceptor)
                    .build();
            retrofitBuilder.client(adaptedClient);
        }

        Retrofit retrofit = retrofitBuilder.build();
        return retrofit.create(serviceClass);
    }

    /**
     * Execute a REST call and block until the response is received.
     */
    public static <V> V execute(Call<V> call) {
        try {
            Response<V> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                RequestError apiError = getError(response);
                throw new RequestException(apiError);
            }
        } catch (IOException e) {
            throw new RequestException(e);
        }
    }

    /**
     * Extracts and converts the response error body into an object.
     */
    public static RequestError getError(Response<?> response) throws IOException {
        return errorBodyConverter.convert(response.errorBody());
    }

    /**
     * Returns the shared OkHttpClient instance.
     */
    public static OkHttpClient getSharedClient() {
        return sharedClient;
    }
}
