package com.creek.whereareyoumodel.domain;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class UserLocationData implements Transformable {
    private final UserId userId;
    private final LocationData locationData;
    
    private static final String USER_ID = "userId";
    private static final String LOCATION_DATA = "locationData";
    
    public UserLocationData(UserId userId, LocationData locationData) {
        this.userId = userId;
        this.locationData = locationData;
    }

    public UserLocationData(JSONObject jsonObject) {
        this.userId = new UserId((JSONObject) jsonObject.get(USER_ID));
        this.locationData = new LocationData((JSONObject) jsonObject.get(LOCATION_DATA));
    }

    public UserId getUserId() {
        return userId;
    }

    public LocationData getLocationData() {
        return locationData;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject dataObject = new JSONObject();
        dataObject.put(USER_ID, getUserId().toJSON());
        dataObject.put(LOCATION_DATA, getLocationData().toJSON());
        return dataObject;
    }
}
