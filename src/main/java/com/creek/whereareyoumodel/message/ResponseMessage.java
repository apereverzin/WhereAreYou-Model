package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.valueobject.OwnerResponse;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class ResponseMessage extends AbstractOwnerRequestResponseMessage<OwnerResponse> implements GenericMessage {
    public ResponseMessage(OwnerResponse ownerResponse, String senderEmail) {
        super(ownerResponse, senderEmail);
    }

    public ResponseMessage(JSONObject jsonObject) {
        super(jsonObject);
    }

    public OwnerResponse getOwnerResponse() {
        return getPayload();
    }

    public final int getMessageType() {
        return RESPONSE_MESSAGE;
    }

    @Override
    protected final OwnerResponse createPayload(JSONObject jsonObject) {
        return new OwnerResponse(jsonObject);
    }
}
