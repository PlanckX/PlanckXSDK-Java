package io.planckx.api.client.impl;

import io.planckx.api.client.PlanckXConstant;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author marcus
 * @version 1.0
 */
public class RequestError {
    /**
     * Error code.
     */
    private int code;

    /**
     * Error message.
     */
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, PlanckXConstant.TO_STRING_STYLE)
                .append("code", code)
                .append("msg", msg)
                .toString();
    }
}
