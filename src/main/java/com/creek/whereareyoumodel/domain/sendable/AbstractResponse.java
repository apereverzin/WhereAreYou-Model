package com.creek.whereareyoumodel.domain.sendable;

/**
 * 
 * @author Andrey Pereverzin
 */
public abstract class AbstractResponse extends AbstractSendable implements GenericResponse {
    private ResponseCode responseCode;
    private ContactRequest request;

    @Override
    public ResponseCode getResponseCode() {
        return responseCode;
    }

    @Override
    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    @Override
    public ContactRequest getRequest() {
        return request;
    }

    @Override
    public void setRequest(ContactRequest request) {
        this.request = request;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString()).append(", responseCode=").append(responseCode).append(", request=").append(request);
        return builder.toString();
    }
}
