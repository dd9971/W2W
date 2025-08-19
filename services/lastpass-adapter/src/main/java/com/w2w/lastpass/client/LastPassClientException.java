package com.w2w.lastpass.client;

class LastPassClientException extends RuntimeException {

    public LastPassClientException(String message) {
        super(message);
    }

    public LastPassClientException(String message, Exception exception) {
        super(message, exception);
    }
}
