package io.planckx.api.client;

import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Constants used throughout PlannckX's API.
 */
public class PlanckXConstant {

    /**
     * HTTP Header to be used for API authentication.
     */
    public static final String API_KEY_HEADER = "access_key";
    public static final String TIMESTAMP_HEADER = "timestamp";
    public static final String NONCE_HEADER = "nonce";
    public static final String TOKEN_HEADER = "sign";


    public static final String HMAC_SHA1 = "HmacSHA1";


    /**
     * Default ToStringStyle used by toString methods.
     * Override this to change the output format of the overridden toString methods.
     * - Example ToStringStyle.JSON_STYLE
     */
    public static final ToStringStyle TO_STRING_STYLE = ToStringStyle.SHORT_PREFIX_STYLE;
}
