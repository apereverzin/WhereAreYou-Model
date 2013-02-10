package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.domain.UserLocationData;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class UserLocationMessage extends AbstractMessage implements GenericMessage {
    private UserLocationData userLocationData;

    private static final String USER_LOCATION = "userLocation";

    public UserLocationMessage(UserLocationData userLocationData, String productVersion) {
        super(productVersion);
        this.userLocationData = userLocationData;
    }

    public UserLocationMessage(JSONObject jsonObject) {
        super(jsonObject);
        this.userLocationData = new UserLocationData((JSONObject) jsonObject.get(USER_LOCATION));
    }

    public UserLocationData getUserLocation() {
        return userLocationData;
    }

    public int getMessageType() {
        return USER_LOCATION_MESSAGE;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(MESSAGE_TYPE, Integer.toString(getMessageType()));
        jsonObject.put(USER_LOCATION, userLocationData.toJSON());
        return jsonObject;
    }
}
