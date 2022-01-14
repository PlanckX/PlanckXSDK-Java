package io.planckx.api.client.impl;

import io.planckx.api.client.bean.CheckBind;

public interface PlanckXAccountClient {
    CheckBind bindStatus(String plarerId);
}
