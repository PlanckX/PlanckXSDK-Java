package io.planckx.api.client;

import io.planckx.api.client.impl.APIOptions;
import io.planckx.api.client.impl.InnerAPIOptions;
import io.planckx.api.client.impl.PlanckXAccountClient;
import io.planckx.api.client.impl.PlanckXAccountClientImpl;
import io.planckx.api.client.impl.PlanckXNftClient;
import io.planckx.api.client.impl.PlanckXNftClientImpl;

/**
 * A factory for creating PlanckX-API client objects.
 *
 * @author marcus
 */
public class PlanckXClientFactory {
    private APIOptions options;

    private PlanckXClientFactory(APIOptions options) {
        this.options = options;
    }

    public static PlanckXClientFactory newInstance(APIOptions options) {
        return new PlanckXClientFactory(options);
    }

    public static PlanckXClientFactory newInstance(String apiKey, String secretKey) {
        final APIOptions options =
                new InnerAPIOptions(apiKey, secretKey)
                        .signature(true);
        return new PlanckXClientFactory(options);
    }

    public PlanckXAccountClient newAccountClient() {
        return new PlanckXAccountClientImpl(options);
    }


    public PlanckXNftClient newNftClient() {
        return new PlanckXNftClientImpl(options);
    }

}
