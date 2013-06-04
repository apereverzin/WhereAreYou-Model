package com.creek.whereareyoumodel.repository;

import java.util.List;

import com.creek.whereareyoumodel.domain.RequestResponse;

/**
 * 
 * @author andreypereverzin
 */
public interface ContactRequestRepository extends IdentifiableRepository<RequestResponse> {
    List<RequestResponse> getAllContactRequests();
    List<RequestResponse> getContactRequestsByContactId(String contactId);
    List<RequestResponse> getContactRequestsByEmail(String email);
    List<RequestResponse> getUnsentContactRequests();
}
