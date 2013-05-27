package com.creek.whereareyoumodel.domain;

/**
 * 
 * @author andreypereverzin
 */
public class ContactRequest extends AbstractIdentifiable implements Identifiable {
    private long timeSent;
    private long timeReceived;
    private int requestCode;
    private String message;

    public long getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(long timeSent) {
        this.timeSent = timeSent;
    }

    public long getTimeReceived() {
        return timeReceived;
    }

    public void setTimeReceived(long timeReceived) {
        this.timeReceived = timeReceived;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
