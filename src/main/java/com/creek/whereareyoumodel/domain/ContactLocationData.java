package com.creek.whereareyoumodel.domain;

/**
 * 
 * @author Andrey Pereverzin
 */
public class ContactLocationData {
    private final ContactData contactData;
    private final OwnerLocationData ownerLocationData;
    private final long timeReceived;

    public ContactLocationData(ContactData contactData, OwnerLocationData ownerLocationData) {
        this.contactData = contactData;
        this.ownerLocationData = ownerLocationData;
        this.timeReceived = System.currentTimeMillis();
    }

    public ContactData getContactData() {
        return contactData;
    }

    public OwnerLocationData getOwnerLocationData() {
        return ownerLocationData;
    }

    public long getTimeReceived() {
        return timeReceived;
    }
}
