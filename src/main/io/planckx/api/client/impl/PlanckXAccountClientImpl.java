package io.planckx.api.client.impl;

import io.planckx.api.client.PlanckXResponse;
import io.planckx.api.client.bean.CheckBind;

/**
 * @author marcus
 * @version 1.0
 * @date 2022-01-13
 */
public class PlanckXAccountClientImpl implements PlanckXAccountClient {

    private APIOptions options;
    private PlanckXApiService apiService;

    public PlanckXAccountClientImpl(APIOptions options) {
        this.options = options;
        apiService = PlanckXClientServiceFactory.createService(PlanckXApiService.class, options);
    }

    @Override
    public CheckBind bindStatus(String plarerId) {
        PlanckXResponse<CheckBind> checkBind =
                PlanckXClientServiceFactory.execute(apiService.bindState(plarerId));

        if (checkBind.isSuccessful())
            return checkBind.getData();

        return null;
    }
}
