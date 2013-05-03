package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.domain.OwnerLocationResponse;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class OwnerLocationResponseMessage extends AbstractMessage implements GenericMessage {
    private OwnerLocationResponse ownerLocationResponse;

    private static final String EMAIL = "email";

    public OwnerLocationResponseMessage(OwnerLocationResponse ownerLocationResponse, String productVersion, String senderEmail) {
        super(productVersion, senderEmail);
        this.ownerLocationResponse = ownerLocationResponse;
    }

    public OwnerLocationResponseMessage(JSONObject jsonObject) {
        super(jsonObject);
        this.ownerLocationResponse = new OwnerLocationResponse((JSONObject) jsonObject.get(EMAIL));
    }

    public OwnerLocationResponse getOwnerLocationResponse() {
        return ownerLocationResponse;
    }

    public int getMessageType() {
        return OWNER_LOCATION_RESPONSE_MESSAGE;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(MESSAGE_TYPE, Integer.toString(getMessageType()));
        jsonObject.put(EMAIL, ownerLocationResponse.toJSON());
        return jsonObject;
    }
}
