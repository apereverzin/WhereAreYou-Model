package com.creek.whereareyoumodel.domain.sendable;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface GenericRequestResponse extends Sendable {
    String getMessage();
    void setMessage(String message);
}
