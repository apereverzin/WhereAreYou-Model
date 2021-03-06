package com.creek.whereareyoumodel.domain.sendable;

import com.creek.whereareyoumodel.domain.AbstractIdentifiable;

/**
 * 
 * @author Andrey Pereverzin
 */
public abstract class AbstractSendable extends AbstractIdentifiable {
    private long timeCreated;
    private long timeSent;
    private long timeReceived;
    private int resultCode;
    private boolean processed;

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public long getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(long timeSent) {
        this.timeSent = timeSent;
    }

    public long getTimeReceived() {
        return timeReceived;
    }

    public void setTimeReceived(long timeReceived) {
        this.timeReceived = timeReceived;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    @Override
    public String toString() {
        return super.toString() + ", timeCreated=" + timeCreated + ", timeSent=" + timeSent + ", timeReceived=" + timeReceived + ", resultCode=" + resultCode + ", processed=" + processed;
    }
}
