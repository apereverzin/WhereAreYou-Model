package com.creek.whereareyoumodel.valueobject;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.domain.sendable.GenericRequestResponse;
import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public abstract class OwnerRequestResponse extends AbstractSendableData implements Transformable {

    private final String message;

    private static final String MESSAGE = "message";

    public OwnerRequestResponse(GenericRequestResponse requestResponse) {
        super(requestResponse.getTimeSent());
        this.message = requestResponse.getMessage();
    }

    public OwnerRequestResponse(JSONObject jsonObject) {
        super(jsonObject);
        this.message = (String) jsonObject.get(MESSAGE);
    }

    public String getMessage() {
        return message;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject dataObject = super.toJSON();
        dataObject.put(MESSAGE, getMessage());
        return dataObject;
    }
}