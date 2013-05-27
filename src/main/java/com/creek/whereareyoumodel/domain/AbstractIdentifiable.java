package com.creek.whereareyoumodel.domain;

/**
 * 
 * @author andreypereverzin
 */
public abstract class AbstractIdentifiable implements Identifiable {

    private int id;
    private ContactCompoundId contactCompoundId;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public ContactCompoundId getContactCompoundId() {
        return contactCompoundId;
    }

    @Override
    public void setContactCompoundId(ContactCompoundId contactCompoundId) {
        this.contactCompoundId = contactCompoundId;
    }
}