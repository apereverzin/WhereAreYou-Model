package com.creek.whereareyoumodel.domain.sendable;

/**
 * 
 * @author Andrey Pereverzin
 */
public class ContactResponse extends AbstractResponse implements GenericResponse, GenericRequestResponse {
    private int code;
    private String message;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
