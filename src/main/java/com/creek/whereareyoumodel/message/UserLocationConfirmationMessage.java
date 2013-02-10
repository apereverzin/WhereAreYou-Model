package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.domain.UserId;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class UserLocationConfirmationMessage extends AbstractMessage implements GenericMessage {
    private UserId userId;
    private long timestamp;

    private static final String TIMESTAMP = "timestamp";
    private static final String USER_ID = "userId";

    public UserLocationConfirmationMessage(UserId userId, long timestamp, String productVersion) {
        super(productVersion);
        this.userId = userId;
        this.timestamp = timestamp;
    }

    public UserLocationConfirmationMessage(JSONObject jsonObject) {
        super(jsonObject);
        this.userId = new UserId((JSONObject) jsonObject.get(USER_ID));
        this.timestamp = Long.parseLong((String) jsonObject.get(TIMESTAMP));
    }

    public UserId getUserId() {
        return userId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getMessageType() {
        return USER_LOCATION_MESSAGE_CONFIRMATION;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(USER_ID, getUserId().toJSON());
        jsonObject.put(TIMESTAMP, Long.toString(getTimestamp()));
        return jsonObject;
    }
}
