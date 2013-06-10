package com.creek.whereareyoumodel.domain;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface Identifiable {
    int getId();
    void setId(int id);
    ContactCompoundId getContactCompoundId();
    void setContactCompoundId(ContactCompoundId contactCompoundId);
}
