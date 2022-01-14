package io.planckx.api.client.security;

import io.planckx.api.client.PlanckXConstant;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Utility class to sign messages using HMAC-SHA1.
 */
public class HmacSHA1Signer {

    /**
     * Sign the given message using the given secret.
     *
     * @param message message to sign
     * @param secret  secret key
     * @return a signed message
     */
    public static String sign(String message, String secret) {
        try {
            Mac sha_HMAC = Mac.getInstance(PlanckXConstant.HMAC_SHA1);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), PlanckXConstant.HMAC_SHA1);
            sha_HMAC.init(secretKeySpec);
            return Base64.encodeBase64String(sha_HMAC.doFinal(message.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("Unable to sign message.", e);
        }
    }
}
