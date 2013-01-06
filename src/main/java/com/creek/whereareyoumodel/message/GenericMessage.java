package com.creek.whereareyoumodel.message;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface GenericMessage extends Transformable {
    public static final int LOCATION_MESSAGE = 110;
    
    int getMessageType();
    
    String getProductVersion();
}
