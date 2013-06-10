package com.creek.whereareyoumodel.domain.sendable;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface GenericResponse extends Sendable {
    ContactRequest getRequest();
    void setRequest(ContactRequest request);
}
