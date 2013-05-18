package com.creek.whereareyoumodel.repository;

import java.util.List;
import java.util.Map;

import com.creek.whereareyoumodel.domain.ContactData;

/**
 * 
 * @author andreypereverzin
 */
public interface ContactRepository {
    ContactData createContactData(ContactData contactData);
    ContactData getContactDataById(int id);
    ContactData getContactDataByEmail(String email);
    ContactData getContactDataByContactId(String contactId);
    List<ContactData> getAllContactData();
    Map<String, ContactData> getAllContactDataAsMap();
    boolean updateContactData(ContactData contactData);
    boolean deleteContactData(int id);
}
