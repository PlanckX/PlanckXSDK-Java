package io.planckx.api.client.impl;

import org.apache.commons.lang3.StringUtils;

public class InnerAPIOptions implements APIOptions {

    private String restHost = "https://api.planckx.io";

    private String websocketHost = StringUtils.EMPTY;

    private String apiKey;

    private String secretKey;

    private boolean signature = false;

    private boolean websocketAutoConnect = true;

    public InnerAPIOptions() {
    }

    public InnerAPIOptions(String apiKey, String secretKey) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    @Override
    public String getApiKey() {
        return this.apiKey;
    }

    @Override
    public String getSecretKey() {
        return this.secretKey;
    }

    @Override
    public String getRestHost() {
        return this.restHost;
    }

    @Override
    public String getWebSocketHost() {
        return this.websocketHost;
    }

    public InnerAPIOptions apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public InnerAPIOptions secretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    public InnerAPIOptions signature(boolean signature) {
        this.signature = signature;
        return this;
    }

    @Override
    public boolean isWebSocketAutoConnect() {
        return this.websocketAutoConnect;
    }

    @Override
    public boolean isSignature() {
        return signature;
    }


}
