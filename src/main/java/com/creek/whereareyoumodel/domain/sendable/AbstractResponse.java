package com.creek.whereareyoumodel.domain.sendable;

/**
 * 
 * @author Andrey Pereverzin
 */
public  class AbstractResponse extends AbstractSendable implements GenericResponse {
    private ContactRequest request;

    @Override
    public ContactRequest getRequest() {
        return request;
    }

    @Override
    public void setRequest(ContactRequest request) {
        this.request = request;
    }
}
