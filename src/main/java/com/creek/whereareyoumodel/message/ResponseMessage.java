package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.valueobject.OwnerRequestResponse;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class ResponseMessage extends AbstractOwnerRequestResponseMessage {
    public ResponseMessage(OwnerRequestResponse ownerResponse, String senderEmail) {
        super(ownerResponse, senderEmail);
    }

    public ResponseMessage(JSONObject jsonObject) {
        super(jsonObject);
    }

    public final int getMessageType() {
        return RESPONSE_MESSAGE;
    }
}
