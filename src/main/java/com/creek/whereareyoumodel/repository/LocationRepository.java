package com.creek.whereareyoumodel.repository;

import java.util.List;

import com.creek.whereareyoumodel.domain.LocationData;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface LocationRepository extends IdentifiableRepository<LocationData> {
    List<LocationData> getContactLocationDataByEmail(String email);
    LocationData getLatestContactLocationDataByEmail(String email);
    List<LocationData> getContactLocationDataByIdOfContact(String contactId);
    LocationData getLatestContactLocationDataByIdOfContact(String contactId);
    List<LocationData> getContactLocationDataByContactId(int contactId);
    LocationData getLatestContactLocationDataByContactId(int contactId);
}
