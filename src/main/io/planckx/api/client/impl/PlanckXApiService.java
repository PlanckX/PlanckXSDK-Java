package io.planckx.api.client.impl;

import io.planckx.api.client.PlanckXResponse;
import io.planckx.api.client.bean.CheckBind;
import io.planckx.api.client.bean.NftAsset;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface PlanckXApiService {

    @GET("/v1/api/sdk/checkBind/{playerId}")
    Call<PlanckXResponse<CheckBind>> bindState(@Path("playerId") String playerId);

    @GET("/v1/api/sdk/NFT/list")
    Call<PlanckXResponse<List<NftAsset>>> getAllNfts();

    @GET("/v1/api/sdk/NFT/player/list/{playerId}")
    Call<PlanckXResponse<List<NftAsset>>> getNftsByPlayer(@Path("playerId") String playerId);

    @GET("/v1/api/sdk/NFT/token/{tokenId}")
    Call<PlanckXResponse<NftAsset>> getNftById(@Path("tokenId") String tokenId);

    @GET("/v1/api/sdk/NFT/list")
    Call<PlanckXResponse<String>> getAllNftsByStr();
}
