package com.creek.whereareyoumodel.domain;

/**
 * 
 * @author Andrey Pereverzin
 */
public class ContactCompoundId {
    private final String contactId;
    private final String contactEmail;

    public ContactCompoundId(String contactId, String contactEmail) {
        this.contactId = contactId;
        this.contactEmail = contactEmail;
    }

    public String getContactId() {
        return contactId;
    }

    public String getContactEmail() {
        return contactEmail;
    }
}
