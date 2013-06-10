package com.creek.whereareyoumodel.domain.sendable;

/**
 * 
 * @author Andrey Pereverzin
 */
public abstract class AbstractRequestResponse extends AbstractSendable implements Sendable {
    // Request codes
    public static final int LOCATION_REQUEST_CODE = 1;
    
    // Response codes
    public static final int SUCCESS_RESPONSE_CODE = 0;
}
