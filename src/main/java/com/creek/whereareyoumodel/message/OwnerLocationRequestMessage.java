package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.domain.OwnerLocationRequest;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class OwnerLocationRequestMessage extends AbstractMessage implements GenericMessage {
    private OwnerLocationRequest ownerLocationRequest;

    private static final String EMAIL = "email";

    public OwnerLocationRequestMessage(OwnerLocationRequest ownerLocationRequest, String productVersion, String senderEmail) {
        super(productVersion, senderEmail);
        this.ownerLocationRequest = ownerLocationRequest;
    }

    public OwnerLocationRequestMessage(JSONObject jsonObject) {
        super(jsonObject);
        this.ownerLocationRequest = new OwnerLocationRequest((JSONObject) jsonObject.get(EMAIL));
    }

    public OwnerLocationRequest getOwnerLocationRequest() {
        return ownerLocationRequest;
    }

    public int getMessageType() {
        return OWNER_LOCATION_REQUEST_MESSAGE;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(MESSAGE_TYPE, Integer.toString(getMessageType()));
        jsonObject.put(EMAIL, ownerLocationRequest.toJSON());
        return jsonObject;
    }
}
