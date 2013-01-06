package com.creek.whereareyoumodel.domain;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class LocationData implements Transformable {
    private String location;
    private long timestamp;

    private static final String LOCATION = "location";
    private static final String TIMESTAMP = "timestamp";

    public LocationData(String location, long timestamp) {
        this.location = location;
        this.timestamp = timestamp;
    }

    public LocationData(JSONObject jsonObject) {
        this.location = (String) jsonObject.get(LOCATION);
        this.timestamp = Long.parseLong((String) jsonObject.get(TIMESTAMP));
    }

    public String getLocation() {
        return location;
    }
    
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject dataObject = new JSONObject();
        dataObject.put(LOCATION, getLocation());
        dataObject.put(TIMESTAMP, Long.toString(getTimestamp()));
        return dataObject;
    }
}
