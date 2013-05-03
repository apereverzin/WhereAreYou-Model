package com.creek.whereareyoumodel.message;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface GenericMessage extends Transformable {
    public static final int OWNER_LOCATION_REQUEST_MESSAGE = 110;
    public static final int OWNER_LOCATION_RESPONSE_MESSAGE = 111;
    public static final int OWNER_LOCATION_DATA_MESSAGE = 112;
    
    int getMessageType();
    
    String getProductVersion();
    
    String getSenderEmail();
}
