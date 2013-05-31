package com.creek.whereareyoumodel.valueobject;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author andreypereverzin
 */
@SuppressWarnings("serial")
public class OwnerRequestResponse extends AbstractOwnerData implements Transformable {

    private final int code;
    private final String message;

    private static final String CODE = "code";
    private static final String MESSAGE = "message";

    public OwnerRequestResponse(long timeSent, int code, String message) {
        super(timeSent);
        this.message = message;
        this.code = code;
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