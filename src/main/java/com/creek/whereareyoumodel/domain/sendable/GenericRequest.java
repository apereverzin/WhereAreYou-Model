package com.creek.whereareyoumodel.domain.sendable;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface GenericRequest extends GenericRequestResponse {
    RequestCode getRequestCode();
    void setRequestCode(RequestCode code);
    GenericResponse getResponse();
    void setResponse(GenericResponse response);
}
