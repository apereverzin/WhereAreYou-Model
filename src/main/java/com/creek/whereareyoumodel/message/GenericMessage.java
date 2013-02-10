package com.creek.whereareyoumodel.message;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface GenericMessage extends Transformable {
    public static final int USER_LOCATION_MESSAGE = 110;
    public static final int USER_LOCATION_MESSAGE_CONFIRMATION = 111;
    
    int getMessageType();
    
    String getProductVersion();
}
