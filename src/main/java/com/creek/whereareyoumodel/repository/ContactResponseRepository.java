package com.creek.whereareyoumodel.repository;

import java.util.List;

import com.creek.whereareyoumodel.domain.RequestResponse;

/**
 * 
 * @author andreypereverzin
 */
public interface ContactResponseRepository extends IdentifiableRepository<RequestResponse> {
    List<RequestResponse> getAllContactResponses();
    List<RequestResponse> getContactResponsesByContactId(String contactId);
    List<RequestResponse> getContactResponsesByEmail(String email);
    List<RequestResponse> getUnsentContactResponses();
}
