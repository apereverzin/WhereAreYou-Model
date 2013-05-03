package com.creek.whereareyoumodel.domain;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class OwnerLocationData implements Transformable {
    private String senderEmail;
    private final long timeSent;
    private final LocationData locationData;

    private static final String SENDER_EMAIL = "senderEmail";
    private static final String TIME_SENT = "timeSent";
    private static final String LOCATION_DATA = "locationData";

    public OwnerLocationData(String senderEmail, long timeSent, LocationData locationData) {
        this.locationData = locationData;
        this.senderEmail = senderEmail;
        this.timeSent = timeSent;
    }

    public OwnerLocationData(JSONObject jsonObject) {
        this.senderEmail = (String) jsonObject.get(SENDER_EMAIL);
        this.timeSent = Long.parseLong((String) jsonObject.get(TIME_SENT));
        this.locationData = new LocationData((JSONObject)jsonObject.get(LOCATION_DATA));
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public long getTimeSent() {
        return timeSent;
    }

    public LocationData getLocationData() {
        return locationData;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject dataObject = new JSONObject();
        dataObject.put(SENDER_EMAIL, getSenderEmail());
        dataObject.put(TIME_SENT, Long.toString(getTimeSent()));
        dataObject.put(LOCATION_DATA, locationData.toJSON());
        return dataObject;
    }
}
