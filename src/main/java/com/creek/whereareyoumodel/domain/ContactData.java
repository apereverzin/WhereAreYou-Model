package com.creek.whereareyoumodel.domain;

/**
 * 
 * @author andreypereverzin
 */
public class ContactData {
    private String email;
    private String contactId;
    private String displayName;
    private boolean locationRequestAllowed;
    private boolean locationRequestReceived;
    private long receivedLocationRequestTimestamp;
    private boolean locationRequestAgreed;
    private boolean locationRequestSent;
    private long sentLocationRequestTimestamp;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isLocationRequestAllowed() {
        return locationRequestAllowed;
    }

    public void setLocationRequestAllowed(boolean locationRequestAllowed) {
        this.locationRequestAllowed = locationRequestAllowed;
    }

    public boolean isLocationRequestReceived() {
        return locationRequestReceived;
    }

    public void setLocationRequestReceived(boolean locationRequestReceived) {
        this.locationRequestReceived = locationRequestReceived;
    }

    public long getReceivedLocationRequestTimestamp() {
        return receivedLocationRequestTimestamp;
    }

    public void setReceivedLocationRequestTimestamp(long receivedLocationRequestTimestamp) {
        this.receivedLocationRequestTimestamp = receivedLocationRequestTimestamp;
    }

    public boolean isLocationRequestAgreed() {
        return locationRequestAgreed;
    }

    public void setLocationRequestAgreed(boolean locationRequestAgreed) {
        this.locationRequestAgreed = locationRequestAgreed;
    }

    public boolean isLocationRequestSent() {
        return locationRequestSent;
    }

    public void setLocationRequestSent(boolean locationRequestSent) {
        this.locationRequestSent = locationRequestSent;
    }

    public long getSentLocationRequestTimestamp() {
        return sentLocationRequestTimestamp;
    }

    public void setSentLocationRequestTimestamp(long sentLocationRequestTimestamp) {
        this.sentLocationRequestTimestamp = sentLocationRequestTimestamp;
    }
}
