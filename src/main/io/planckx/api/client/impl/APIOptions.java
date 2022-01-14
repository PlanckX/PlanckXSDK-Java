package io.planckx.api.client.impl;

public interface APIOptions {

  String getApiKey();

  String getSecretKey();

  String getRestHost();

  String getWebSocketHost();

  boolean isWebSocketAutoConnect();

  boolean isSignature();

}
