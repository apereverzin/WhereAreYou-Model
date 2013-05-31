package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.valueobject.OwnerRequest;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class RequestMessage extends AbstractOwnerRequestResponseMessage<OwnerRequest> implements GenericMessage {
    public RequestMessage(OwnerRequest ownerRequest, String senderEmail) {
        super(ownerRequest, senderEmail);
    }

    public RequestMessage(JSONObject jsonObject) {
        super(jsonObject);
    }

    public OwnerRequest getOwnerRequest() {
        return getPayload();
    }

    public final int getMessageType() {
        return REQUEST_MESSAGE;
    }

    @Override
    protected OwnerRequest createPayload(JSONObject jsonObject) {
        return new OwnerRequest(jsonObject);
    }
}
