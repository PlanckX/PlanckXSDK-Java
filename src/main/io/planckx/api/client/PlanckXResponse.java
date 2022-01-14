package io.planckx.api.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author marcus
 * @version 1.0
 * @date 2022-01-14
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanckXResponse<T> {
    private Integer code;
    private String msg;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccessful() {
        return (code != null && code == 200);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, PlanckXConstant.TO_STRING_STYLE)
                .append("code", code)
                .append("msg", msg)
                .append("data", data)
                .toString();
    }
}
