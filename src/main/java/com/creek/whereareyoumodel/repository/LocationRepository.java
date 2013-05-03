package com.creek.whereareyoumodel.repository;

import java.util.List;

import com.creek.whereareyoumodel.domain.ContactLocationData;

/**
 * 
 * @author andreypereverzin
 */
public interface LocationRepository {
    void saveLocationData(ContactLocationData locationData);
    void daleteLocationData(ContactLocationData locationData);
    List<ContactLocationData> getLocationDataByEmail(String email);
    ContactLocationData getLatestLocationDataByEmail(String email);
    List<ContactLocationData> getLocationDataByContactId(String contactId);
    ContactLocationData getLatestLocationDataByContactId(String contactId);
}
