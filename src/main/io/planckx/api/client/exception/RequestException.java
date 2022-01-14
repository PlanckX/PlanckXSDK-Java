package io.planckx.api.client.exception;

import io.planckx.api.client.impl.RequestError;

/**
 * @author marcus
 * @version 1.0
 */
public class RequestException extends RuntimeException {

    private String errCode;
    private RequestError error;

    public RequestException(Throwable cause) {
        super(cause);
    }

    public RequestException(RequestError error) {
        super(error.getMsg());
        this.error = error;
        errCode = String.valueOf(error.getCode());
    }
}
