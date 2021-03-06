package com.creek.whereareyoumodel.domain.sendable;

import com.creek.whereareyoumodel.domain.LocationData;

/**
 * 
 * @author Andrey Pereverzin
 */
public class ContactResponse extends AbstractResponse implements GenericResponse, GenericRequestResponse {
    private String message;
    private LocationData locationData;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    public LocationData getLocationData() {
        return locationData;
    }

    public void setLocationData(LocationData locationData) {
        this.locationData = locationData;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ContactResponse [").append(super.toString()).append(", message=").append(message).append(", locationData=").append(locationData).append("]");
        return builder.toString();
    }
}
