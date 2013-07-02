package com.creek.whereareyoumodel.domain;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface Identifiable {
    long getId();
    void setId(long id);
    ContactCompoundId getContactCompoundId();
    void setContactCompoundId(ContactCompoundId contactCompoundId);
}
