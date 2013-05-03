package com.creek.whereareyoumodel.domain;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class OwnerLocationResponse implements Transformable {
    private final String senderEmail;
    private final long timeSent;
    private final int responseCode;
    private final String message;

    private static final String SENDER_EMAIL = "senderEmail";
    private static final String TIME_SENT = "timeSent";
    private static final String RESPONSE_CODE = "responseCode";
    private static final String MESSAGE = "message";

    public OwnerLocationResponse(String email, long timeSent, int responseCode, String message) {
        this.senderEmail = email;
        this.timeSent = timeSent;
        this.responseCode = responseCode;
        this.message = message;
    }

    public OwnerLocationResponse(JSONObject jsonObject) {
        this.senderEmail = (String) jsonObject.get(SENDER_EMAIL);
        this.timeSent = Long.parseLong((String) jsonObject.get(TIME_SENT));
        this.responseCode = Integer.parseInt((String) jsonObject.get(RESPONSE_CODE));
        this.message = (String) jsonObject.get(MESSAGE);
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public long getTimeSent() {
        return timeSent;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject dataObject = new JSONObject();
        dataObject.put(SENDER_EMAIL, getSenderEmail());
        dataObject.put(TIME_SENT, Long.toString(getTimeSent()));
        dataObject.put(RESPONSE_CODE, Integer.toString(getResponseCode()));
        dataObject.put(MESSAGE, getMessage());
        return dataObject;
    }
}
