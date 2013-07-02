package com.creek.whereareyoumodel.message;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface GenericMessage extends Transformable {
    MessageType getMessageType();
    
    String getProductVersion();
    
    String getSenderEmail();
}
