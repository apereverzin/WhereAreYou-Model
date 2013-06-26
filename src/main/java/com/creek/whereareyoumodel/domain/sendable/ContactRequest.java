package com.creek.whereareyoumodel.domain.sendable;

/**
 * 
 * @author Andrey Pereverzin
 */
public class ContactRequest extends AbstractSendable implements GenericRequest {
    private RequestCode requestCode;
    private String message;
    private GenericResponse response;

    @Override
    public RequestCode getRequestCode() {
        return requestCode;
    }

    @Override
    public void setRequestCode(RequestCode requestCode) {
        this.requestCode = requestCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public GenericResponse getResponse() {
        return response;
    }

    @Override
    public void setResponse(GenericResponse response) {
        this.response = response;
    }
}
