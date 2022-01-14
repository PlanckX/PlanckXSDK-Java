package io.planckx.api.client.impl;

import io.planckx.api.client.PlanckXResponse;
import io.planckx.api.client.bean.NftAsset;

import java.util.Collections;
import java.util.List;

/**
 * @author marcus
 * @version 1.0
 * @date 2022-01-13
 */
public class PlanckXNftClientImpl implements PlanckXNftClient {

    private APIOptions options;
    private PlanckXApiService apiService;

    public PlanckXNftClientImpl(APIOptions options) {
        this.options = options;
        apiService = PlanckXClientServiceFactory.createService(PlanckXApiService.class, options);
    }

    @Override
    public List<NftAsset> getAllNfts() {
        PlanckXResponse<List<NftAsset>> response =
                PlanckXClientServiceFactory.execute(apiService.getAllNfts());

        if (response.isSuccessful())
            return response.getData();

        return Collections.EMPTY_LIST;
    }

    @Override
    public List<NftAsset> getNftsByPlayer(String playerId) {
        PlanckXResponse<List<NftAsset>> response =
                PlanckXClientServiceFactory.execute(apiService.getNftsByPlayer(playerId));

        if (response.isSuccessful())
            return response.getData();

        return Collections.EMPTY_LIST;
    }

    @Override
    public NftAsset getNftById(String tokenId) {
        PlanckXResponse<NftAsset> response =
                PlanckXClientServiceFactory.execute(apiService.getNftById(tokenId));

        if (response.isSuccessful())
            return response.getData();

        return null;
    }

}
