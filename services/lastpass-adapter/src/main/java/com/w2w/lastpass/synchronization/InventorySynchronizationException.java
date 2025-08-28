package com.w2w.lastpass.synchronization;

public class InventorySynchronizationException extends RuntimeException {

    public InventorySynchronizationException(String message) {
        super(message);
    }

    public InventorySynchronizationException(String message, Exception e) {
        super(message, e);
    }
}
