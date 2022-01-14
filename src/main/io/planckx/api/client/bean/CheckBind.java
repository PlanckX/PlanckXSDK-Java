package io.planckx.api.client.bean;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.planckx.api.client.PlanckXConstant;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CheckBind {
    @JsonAlias("isBind")
    private Boolean bind;

    @JsonAlias("openUrl")
    private String authAddress;

    public Boolean getBind() {
        return bind;
    }

    public void setBind(Boolean bind) {
        this.bind = bind;
    }

    public String getAuthAddress() {
        return authAddress;
    }

    public void setAuthAddress(String authAddress) {
        this.authAddress = authAddress;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, PlanckXConstant.TO_STRING_STYLE)
                .append("bind", bind)
                .append("authAddress", authAddress)
                .toString();
    }
}
