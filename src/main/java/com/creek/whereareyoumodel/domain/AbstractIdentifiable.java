package com.creek.whereareyoumodel.domain;

/**
 * 
 * @author Andrey Pereverzin
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractIdentifiable other = (AbstractIdentifiable) obj;
        if (id != other.id)
            return false;
        return true;
    }
}