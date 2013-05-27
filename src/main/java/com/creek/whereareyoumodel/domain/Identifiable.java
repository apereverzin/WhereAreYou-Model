package com.creek.whereareyoumodel.domain;

/**
 * 
 * @author andreypereverzin
 */
public interface Identifiable {
    int getId();
    void setId(int id);
    ContactCompoundId getContactCompoundId();
    void setContactCompoundId(ContactCompoundId contactCompoundId);
}
