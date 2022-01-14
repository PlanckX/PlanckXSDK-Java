package io.planckx.api.client;

import io.planckx.api.client.bean.CheckBind;
import io.planckx.api.client.bean.NftAsset;
import org.junit.Test;


public class PlanckXTest {

    /*
     * Please replace API_KEY and SECRET_KEY.
     */
    private final static String API_KEY = "XXXXX";
    private final static String SECRET_KEY = "XXXXXXXXXXXXXXXXXXXXXX";

    private final static PlanckXClientFactory CLIENT_FACTORY =
            PlanckXClientFactory.newInstance(API_KEY, SECRET_KEY);

    /*
     * Please replace the 'Player ID' value below
     */

    @Test
    public void checkBind() {
        CheckBind checkBind = CLIENT_FACTORY.newAccountClient().bindStatus("Player ID");
        System.out.println(checkBind);
    }

    @Test
    public void allNfts() {
        CLIENT_FACTORY.newNftClient().getAllNfts().forEach(nftAsset -> System.out.println(nftAsset));
    }

    @Test
    public void nftsByPlayer() {
        CLIENT_FACTORY.newNftClient().getNftsByPlayer("Player ID").forEach(nftAsset -> System.out.println(nftAsset));
    }

    @Test
    public void detailByToken() {
        NftAsset nftAsset = CLIENT_FACTORY.newNftClient().getNftById("Player ID");
        System.out.println(nftAsset);
    }
}
