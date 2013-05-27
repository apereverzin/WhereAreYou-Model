package com.creek.whereareyoumodel.domain;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class OwnerLocationData implements Transformable {
    private final long timeSent;
    private final LocationData locationData;

    private static final String TIME_SENT = "timeSent";
    private static final String LOCATION_DATA = "locationData";

    public OwnerLocationData(long timeSent, LocationData locationData) {
        this.timeSent = timeSent;
        this.locationData = locationData;
    }

    public OwnerLocationData(JSONObject jsonObject) {
        this.timeSent = Long.parseLong((String) jsonObject.get(TIME_SENT));
        this.locationData = new LocationData((JSONObject)jsonObject.get(LOCATION_DATA));
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
        dataObject.put(TIME_SENT, Long.toString(getTimeSent()));
        dataObject.put(LOCATION_DATA, locationData.toJSON());
        return dataObject;
    }
}
