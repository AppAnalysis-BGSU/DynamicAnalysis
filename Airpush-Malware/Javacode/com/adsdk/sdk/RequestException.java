package com.adsdk.sdk;

public class RequestException extends Exception {
    private static final long serialVersionUID = 1;

    public RequestException(String detailMessage) {
        super(detailMessage);
    }

    public RequestException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public RequestException(Throwable throwable) {
        super(throwable);
    }
}
