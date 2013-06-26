package com.creek.whereareyoumodel.repository;

import java.util.List;

import com.creek.whereareyoumodel.domain.sendable.ContactRequest;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface ContactRequestRepository extends IdentifiableRepository<ContactRequest> {
    List<ContactRequest> getAllContactRequests();
    List<ContactRequest> getContactRequestsByContactId(String contactId);
    List<ContactRequest> getContactRequestsByEmail(String email);
    List<ContactRequest> getUnsentContactRequests();
    List<ContactRequest> getAllUnrespondedContactRequests();
    List<ContactRequest> getUnrespondedLocationRequests();
}
