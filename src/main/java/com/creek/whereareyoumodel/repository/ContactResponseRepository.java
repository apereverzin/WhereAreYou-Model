package com.creek.whereareyoumodel.repository;

import java.util.List;

import com.creek.whereareyoumodel.domain.sendable.ContactResponse;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface ContactResponseRepository extends IdentifiableRepository<ContactResponse> {
    List<ContactResponse> getAllContactResponses();
    List<ContactResponse> getContactResponsesByContactId(String contactId);
    List<ContactResponse> getContactResponsesByEmail(String email);
    List<ContactResponse> getUnsentContactResponses();
}
