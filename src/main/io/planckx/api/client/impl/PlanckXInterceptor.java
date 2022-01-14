package io.planckx.api.client.impl;

import io.planckx.api.client.PlanckXConstant;
import io.planckx.api.client.security.HmacSHA1Signer;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author marcus
 * @version 1.0
 */
public class PlanckXInterceptor implements Interceptor {

    private APIOptions options;

    public PlanckXInterceptor(APIOptions options) {
        this.options = options;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder newRequestBuilder = original.newBuilder();

        // add header last
        final String timestamp = String.valueOf(System.currentTimeMillis());
        final String nonce = UUID.randomUUID().toString();

        List<String> signList = new ArrayList<>();
        signList.add(String.format("%s=%s", PlanckXConstant.API_KEY_HEADER, options.getApiKey()));
        signList.add(String.format("%s=%s", PlanckXConstant.NONCE_HEADER, nonce));
        signList.add(String.format("%s=%s", PlanckXConstant.TIMESTAMP_HEADER, timestamp));

        // add validation param
//        String query = original.url().query();
        String body2String = this.body2String(original.body());

        // add sign-list
        if (StringUtils.isNotEmpty(body2String))
            signList.add(body2String);

        // sort
        String[] results = signList.toArray(new String[]{});
        Arrays.sort(results);

        // hmacsha1
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(results).forEach(str -> stringBuilder.append(str).append("&"));
        final String result = stringBuilder.substring(0, stringBuilder.length() - 1);

        final String token = HmacSHA1Signer.sign(result, options.getSecretKey());

        newRequestBuilder
                .addHeader(PlanckXConstant.API_KEY_HEADER, options.getApiKey())
                .addHeader(PlanckXConstant.NONCE_HEADER, nonce)
                .addHeader(PlanckXConstant.TIMESTAMP_HEADER, timestamp)
                .addHeader(PlanckXConstant.TOKEN_HEADER, token);

        // Build new request after adding the necessary authentication information
        Request newRequest = newRequestBuilder.build();
        return chain.proceed(newRequest);
    }

    /**
     * Extracts the request body into a String.
     *
     * @return request body as a string
     */
    private static String body2String(RequestBody request) {
        try (final Buffer buffer = new Buffer()) {
            final RequestBody copy = request;
            if (copy != null) {
                copy.writeTo(buffer);
            } else {
                return "";
            }
            return buffer.readUtf8();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        final PlanckXInterceptor that = (PlanckXInterceptor) o;
        return Objects.equals(options.getApiKey(), that.options.getApiKey()) &&
                Objects.equals(options.getSecretKey(), that.options.getSecretKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(options.getApiKey(), options.getSecretKey());
    }
}
