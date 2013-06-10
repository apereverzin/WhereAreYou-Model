package com.creek.whereareyoumodel.domain.sendable;

/**
 * 
 * @author Andrey Pereverzin
 */
public class ContactRequest extends AbstractRequestResponse implements GenericRequestResponse {
    private int code;
    private String message;
    private GenericResponse response;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GenericResponse getResponse() {
        return response;
    }

    public void setResponse(GenericResponse response) {
        this.response = response;
    }
}
