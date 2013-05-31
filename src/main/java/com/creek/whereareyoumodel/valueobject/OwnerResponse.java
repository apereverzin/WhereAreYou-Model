package com.creek.whereareyoumodel.valueobject;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class OwnerResponse extends OwnerRequestResponse implements Transformable {
    public OwnerResponse(long timeSent, int code, String message) {
        super(timeSent, code, message);
    }

    public OwnerResponse(JSONObject jsonObject) {
        super(jsonObject);
    }
}
