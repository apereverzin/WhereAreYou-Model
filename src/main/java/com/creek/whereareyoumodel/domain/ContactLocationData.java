package com.creek.whereareyoumodel.domain;

/**
 * 
 * @author Andrey Pereverzin
 */
public class ContactLocationData {
    private int id;
    private int contactId;
    private String contactEmail;
    private OwnerLocationData ownerLocationData;
    private long timeReceived;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public OwnerLocationData getOwnerLocationData() {
        return ownerLocationData;
    }

    public void setOwnerLocationData(OwnerLocationData ownerLocationData) {
        this.ownerLocationData = ownerLocationData;
    }

    public long getTimeReceived() {
        return timeReceived;
    }

    public void setTimeReceived(long timeReceived) {
        this.timeReceived = timeReceived;
    }
}
