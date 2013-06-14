package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.valueobject.SendableLocationData;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class OwnerLocationDataMessage extends AbstractMessage {
    private SendableLocationData ownerLocationData;

    private static final String OWNER_LOCATION = "ownerLocation";

    public OwnerLocationDataMessage(SendableLocationData userLocationData, String senderEmail) {
        super(senderEmail);
        this.ownerLocationData = userLocationData;
    }

    public OwnerLocationDataMessage(JSONObject jsonObject) {
        super(jsonObject);
        this.ownerLocationData = new SendableLocationData((JSONObject) jsonObject.get(OWNER_LOCATION));
    }

    public SendableLocationData getOwnerLocationData() {
        return ownerLocationData;
    }

    public int getMessageType() {
        return OWNER_LOCATION_DATA_MESSAGE;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(MESSAGE_TYPE, Integer.toString(getMessageType()));
        jsonObject.put(OWNER_LOCATION, ownerLocationData.toJSON());
        return jsonObject;
    }
}
