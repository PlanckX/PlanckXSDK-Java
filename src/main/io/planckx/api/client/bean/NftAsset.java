package io.planckx.api.client.bean;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.planckx.api.client.PlanckXConstant;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author marcus
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NftAsset {

    private String gameId;

    // Asset name
    @JsonAlias("nftName")
    private String name;

    // Asset type
    @JsonAlias("nftType")
    private String type;

    // Creator address
    @JsonAlias("authorAddress")
    private String creatorAddress;

    private String ownerAddress;

    @JsonAlias("nftContent")
    private String content;

    @JsonAlias("nftDescription")
    private String description;

    private String tokenId;

    @JsonAlias("nftData")
    private String addition;

    public String getGameId() {
        return gameId;
    }

    public NftAsset setGameId(String gameId) {
        this.gameId = gameId;
        return this;
    }

    public String getName() {
        return name;
    }

    public NftAsset setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public NftAsset setType(String type) {
        this.type = type;
        return this;
    }

    public String getCreatorAddress() {
        return creatorAddress;
    }

    public NftAsset setCreatorAddress(String creatorAddress) {
        this.creatorAddress = creatorAddress;
        return this;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public NftAsset setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
        return this;
    }

    public String getContent() {
        return content;
    }

    public NftAsset setContent(String content) {
        this.content = content;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public NftAsset setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTokenId() {
        return tokenId;
    }

    public NftAsset setTokenId(String tokenId) {
        this.tokenId = tokenId;
        return this;
    }

    public String getAddition() {
        return addition;
    }

    public NftAsset setAddition(String addition) {
        this.addition = addition;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, PlanckXConstant.TO_STRING_STYLE)
                .append("gameId", gameId)
                .append("name", name)
                .append("type", type)
                .append("creatorAddress", creatorAddress)
                .append("ownerAddress", ownerAddress)
                .append("content", content)
                .append("description", description)
                .append("tokenId", tokenId)
                .append("addition", addition)
                .toString();
    }
}
