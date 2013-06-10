package com.creek.whereareyoumodel.domain.sendable;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface GenericRequestResponse extends Sendable {
    int getCode();
    void setCode(int code);
    String getMessage();
    void setMessage(String message);
}
