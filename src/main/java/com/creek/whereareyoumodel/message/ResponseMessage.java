package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.valueobject.OwnerResponse;
import static com.creek.whereareyoumodel.message.MessageType.RESPONSE_MESSAGE;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class ResponseMessage extends AbstractMessage {
    private final OwnerResponse ownerResponse;
    private static final String RESPONSE = "response";

    public ResponseMessage(OwnerResponse ownerResponse, String senderEmail) {
        super(senderEmail);
        this.ownerResponse = ownerResponse;
    }

    public ResponseMessage(JSONObject jsonObject) {
        super(jsonObject);
        ownerResponse = new OwnerResponse((JSONObject) jsonObject.get(RESPONSE));
    }

    @Override
    public final MessageType getMessageType() {
        return RESPONSE_MESSAGE;
    }

    public OwnerResponse getOwnerResponse() {
        return ownerResponse;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(RESPONSE, ownerResponse.toJSON());
        return jsonObject;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ResponseMessage [").append(super.toString()).append(", ownerResponse=").append(ownerResponse).append("]");
        return builder.toString();
    }
}
