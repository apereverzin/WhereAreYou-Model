package com.creek.whereareyoumodel.valueobject;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.domain.sendable.GenericRequestResponse;
import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class OwnerRequestResponse extends AbstractSendableData implements Transformable {

    private final int code;
    private final String message;

    private static final String CODE = "code";
    private static final String MESSAGE = "message";

    public OwnerRequestResponse(GenericRequestResponse requestResponse) {
        super(requestResponse.getTimeSent());
        this.message = requestResponse.getMessage();
        this.code = requestResponse.getCode();
    }

    public OwnerRequestResponse(JSONObject jsonObject) {
        super(jsonObject);
        this.message = (String) jsonObject.get(MESSAGE);
        this.code = Integer.parseInt((String) jsonObject.get(CODE));
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject dataObject = super.toJSON();
        dataObject.put(CODE, Integer.toString(getCode()));
        dataObject.put(MESSAGE, getMessage());
        return dataObject;
    }
}