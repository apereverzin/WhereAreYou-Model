package com.creek.whereareyoumodel.domain.sendable;

import com.creek.whereareyoumodel.domain.Identifiable;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface Sendable extends Identifiable {
    long getTimeCreated();
    void setTimeCreated(long timeCreated);
    long getTimeSent();
    void setTimeSent(long timeSent);
    long getTimeReceived();
    void setTimeReceived(long timeReceived);
    int getResultCode();
    void setResultCode(int resultCode);
}