package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.valueobject.OwnerRequestResponse;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class RequestMessage extends AbstractOwnerRequestResponseMessage implements GenericMessage {
    public RequestMessage(OwnerRequestResponse ownerRequest, String senderEmail) {
        super(ownerRequest, senderEmail);
    }

    public RequestMessage(JSONObject jsonObject) {
        super(jsonObject);
    }

    public final int getMessageType() {
        return REQUEST_MESSAGE;
    }
}
