package com.creek.whereareyoumodel.valueobject;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class OwnerRequest extends OwnerRequestResponse implements Transformable {
    public OwnerRequest(long timeSent, int code, String message) {
        super(timeSent, code, message);
    }

    public OwnerRequest(JSONObject jsonObject) {
        super(jsonObject);
    }
}
