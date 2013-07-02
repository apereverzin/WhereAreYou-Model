package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.valueobject.OwnerRequest;
import static com.creek.whereareyoumodel.message.MessageType.REQUEST_MESSAGE;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class RequestMessage extends AbstractMessage {
    private final OwnerRequest ownerRequest;
    private static final String REQUEST = "request";

    public RequestMessage(OwnerRequest ownerRequest, String senderEmail) {
        super(senderEmail);
        this.ownerRequest = ownerRequest;
    }

    public RequestMessage(JSONObject jsonObject) {
        super(jsonObject);
        ownerRequest = new OwnerRequest((JSONObject) jsonObject.get(REQUEST));
    }

    @Override
    public final MessageType getMessageType() {
        return REQUEST_MESSAGE;
    }

    public OwnerRequest getOwnerRequest() {
        return ownerRequest;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(REQUEST, ownerRequest.toJSON());
        return jsonObject;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RequestMessage [").append(super.toString()).append(", ownerRequest=").append(ownerRequest).append("]");
        return builder.toString();
    }
}
