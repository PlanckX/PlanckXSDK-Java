package io.planckx.api.client.impl;

import io.planckx.api.client.bean.NftAsset;

import java.util.List;

public interface PlanckXNftClient {

    List<NftAsset> getAllNfts();

    List<NftAsset> getNftsByPlayer(String playerId);

    NftAsset getNftById(String tokenId);
}
