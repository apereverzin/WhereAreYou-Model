package com.creek.whereareyoumodel.domain;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class OwnerLocationRequest implements Transformable {
    private final long timeSent;
    private final int requestCode;
    private final String message;

    private static final String TIME_SENT = "timeSent";
    private static final String REQUEST_CODE = "requestCode";
    private static final String MESSAGE = "message";

    public OwnerLocationRequest(long timeSent, int requestCode, String message) {
        this.timeSent = timeSent;
        this.message = message;
        this.requestCode = requestCode;
    }

    public OwnerLocationRequest(JSONObject jsonObject) {
        this.timeSent = Long.parseLong((String) jsonObject.get(TIME_SENT));
        this.message = (String) jsonObject.get(MESSAGE);
        this.requestCode = Integer.parseInt((String) jsonObject.get(REQUEST_CODE));
    }

    public long getTimeSent() {
        return timeSent;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject dataObject = new JSONObject();
        dataObject.put(TIME_SENT, Long.toString(getTimeSent()));
        dataObject.put(REQUEST_CODE, Integer.toString(getRequestCode()));
        dataObject.put(MESSAGE, getMessage());
        return dataObject;
    }
}
