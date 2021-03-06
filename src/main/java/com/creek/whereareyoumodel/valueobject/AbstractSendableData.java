package com.creek.whereareyoumodel.valueobject;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public abstract class AbstractSendableData implements Transformable {
    private final long timeSent;

    private static final String TIME_SENT = "timeSent";

    public AbstractSendableData(long timeSent) {
        this.timeSent = timeSent;
    }

    public AbstractSendableData(JSONObject jsonObject) {
        this.timeSent = Long.parseLong((String) jsonObject.get(TIME_SENT));
    }
    
    public long getTimeSent() {
        return timeSent;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject dataObject = new JSONObject();
        dataObject.put(TIME_SENT, Long.toString(getTimeSent()));
        return dataObject;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("timeSent=").append(timeSent);
        return builder.toString();
    }
}
