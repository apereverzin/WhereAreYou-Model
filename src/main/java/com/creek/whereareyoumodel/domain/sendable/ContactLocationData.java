package com.creek.whereareyoumodel.domain.sendable;

import com.creek.whereareyoumodel.valueobject.SendableLocationData;

/**
 * 
 * @author Andrey Pereverzin
 */
public class ContactLocationData extends AbstractResponse implements GenericResponse {
    private SendableLocationData ownerLocationData;

    public SendableLocationData getOwnerLocationData() {
        return ownerLocationData;
    }

    public void setOwnerLocationData(SendableLocationData ownerLocationData) {
        this.ownerLocationData = ownerLocationData;
    }
}
