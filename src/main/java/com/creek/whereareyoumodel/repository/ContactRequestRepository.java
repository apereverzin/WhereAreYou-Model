package com.creek.whereareyoumodel.repository;

import java.util.List;

import com.creek.whereareyoumodel.domain.ContactRequest;

/**
 * 
 * @author andreypereverzin
 */
public interface ContactRequestRepository extends IdentifiableRepository<ContactRequest> {
    List<ContactRequest> getAllContactRequests();
    List<ContactRequest> getContactRequestsByContactId(String contactId);
    List<ContactRequest> getContactRequestsByEmail(String email);
}
