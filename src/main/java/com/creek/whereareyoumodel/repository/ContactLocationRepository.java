package com.creek.whereareyoumodel.repository;

import java.util.List;

import com.creek.whereareyoumodel.domain.ContactLocationData;

/**
 * 
 * @author andreypereverzin
 */
public interface ContactLocationRepository extends IdentifiableRepository<ContactLocationData> {
    List<ContactLocationData> getContactLocationDataByEmail(String email);
    ContactLocationData getLatestContactLocationDataByEmail(String email);
    List<ContactLocationData> getContactLocationDataByIdOfContact(String contactId);
    ContactLocationData getLatestContactLocationDataByIdOfContact(String contactId);
    List<ContactLocationData> getContactLocationDataByContactId(int contactId);
    ContactLocationData getLatestContactLocationDataByContactId(int contactId);
}
