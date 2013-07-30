package com.creek.whereareyoumodel.domain;

/**
 * 
 * @author Andrey Pereverzin
 */
public class ContactCompoundId {
    private final String contactId;
    private String contactEmail;

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

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ContactCompoundId [contactId=").append(contactId).append(", contactEmail=").append(contactEmail).append("]");
        return builder.toString();
    }
}
