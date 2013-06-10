package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.valueobject.OwnerRequestResponse;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public abstract class AbstractOwnerRequestResponseMessage extends AbstractMessage {
    private final OwnerRequestResponse ownerRequestResponse;
    
    private static final String PAYLOAD = "payload";

    public AbstractOwnerRequestResponseMessage(OwnerRequestResponse ownerRequestResponse, String senderEmail) {
        super(senderEmail);
        this.ownerRequestResponse = ownerRequestResponse;
    }

    public AbstractOwnerRequestResponseMessage(JSONObject jsonObject) {
        super(jsonObject);
        ownerRequestResponse = new OwnerRequestResponse((JSONObject) jsonObject.get(PAYLOAD));
    }
    
    public final OwnerRequestResponse getOwnerRequestResponse() {
        return ownerRequestResponse;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(PAYLOAD, ownerRequestResponse.toJSON());
        return jsonObject;
    }
}
