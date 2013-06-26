package com.creek.whereareyoumodel.domain.sendable;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface GenericResponse extends Sendable {
    ResponseCode getResponseCode();
    void setResponseCode(ResponseCode code);
    ContactRequest getRequest();
    void setRequest(ContactRequest request);
}
