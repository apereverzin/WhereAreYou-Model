package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.domain.UserLocationData;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class UserLocationMessage implements GenericMessage {
    private UserLocationData userLocationData;
    private String productVersion;
    private static final String MESSAGE_TYPE = "messageType";
    private static final String PRODUCT_VERSION = "productVersion";

    private static final String USER_LOCATION = "userLocation";

    public UserLocationMessage(UserLocationData userLocationData, String productVersion) {
        this.userLocationData = userLocationData;
        this.productVersion = productVersion;
    }

    public UserLocationMessage(JSONObject jsonObject) {
        this.userLocationData = new UserLocationData((JSONObject) jsonObject.get(USER_LOCATION));
        this.productVersion = (String)jsonObject.get(PRODUCT_VERSION);
    }

    public UserLocationData getUserLocation() {
        return userLocationData;
    }

    public int getMessageType() {
        return LOCATION_MESSAGE;
    }

    @Override
    public String getProductVersion() {
        return productVersion;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(MESSAGE_TYPE, Integer.toString(getMessageType()));
        jsonObject.put(PRODUCT_VERSION, productVersion);
        jsonObject.put(USER_LOCATION, userLocationData.toJSON());
        return jsonObject;
    }
}
