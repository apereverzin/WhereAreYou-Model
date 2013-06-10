package com.creek.whereareyoumodel.domain.sendable;

import com.creek.whereareyoumodel.domain.AbstractIdentifiable;

/**
 * 
 * @author Andrey Pereverzin
 */
public abstract class AbstractSendable extends AbstractIdentifiable {
    public static final int SUCCESS = 0;
    public static final int FAILURE = -1;

    private long timeCreated;
    private long timeSent;
    private long timeReceived;
    private int resultCode;

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
}