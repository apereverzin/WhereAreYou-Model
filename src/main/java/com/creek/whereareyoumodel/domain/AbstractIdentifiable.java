package com.creek.whereareyoumodel.domain;

/**
 * 
 * @author andreypereverzin
 */
public abstract class AbstractIdentifiable implements Identifiable {

    private int id;
    private ContactCompoundId contactCompoundId;

    @Override
    public final int getId() {
        return id;
    }

    @Override
    public final void setId(int id) {
        this.id = id;
    }

    @Override
    public final ContactCompoundId getContactCompoundId() {
        return contactCompoundId;
    }

    @Override
    public final void setContactCompoundId(ContactCompoundId contactCompoundId) {
        this.contactCompoundId = contactCompoundId;
    }
}