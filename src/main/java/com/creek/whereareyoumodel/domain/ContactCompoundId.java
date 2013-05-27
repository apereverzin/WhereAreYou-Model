package com.creek.whereareyoumodel.domain;

/**
 * 
 * @author andreypereverzin
 */
public class ContactCompoundId {
    private String contactId;
    private String contactEmail;

    public ContactCompoundId(String contactId, String contactEmail) {
        this.contactEmail = contactEmail;
        this.contactId = contactId;
    }

    public String getContactId() {
        return contactId;
    }

    public String getContactEmail() {
        return contactEmail;
    }
}
