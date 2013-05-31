package com.creek.whereareyoumodel.domain;

import com.creek.whereareyoumodel.valueobject.OwnerLocationData;

/**
 * 
 * @author Andrey Pereverzin
 */
public class ContactLocationData extends AbstractIdentifiable implements Identifiable {
    private OwnerLocationData ownerLocationData;
    private long timeReceived;

    public OwnerLocationData getOwnerLocationData() {
        return ownerLocationData;
    }

    public void setOwnerLocationData(OwnerLocationData ownerLocationData) {
        this.ownerLocationData = ownerLocationData;
    }

    public long getTimeReceived() {
        return timeReceived;
    }

    public void setTimeReceived(long timeReceived) {
        this.timeReceived = timeReceived;
    }
}
