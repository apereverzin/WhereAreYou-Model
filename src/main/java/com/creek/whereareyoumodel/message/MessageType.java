package com.creek.whereareyoumodel.message;

import com.creek.whereareyoumodel.domain.sendable.RequestCode;

/**
 * 
 * @author Andrey Pereverzin
 */
public enum MessageType {
    REQUEST_MESSAGE(110),
    RESPONSE_MESSAGE(111),
    OWNER_LOCATION_DATA_MESSAGE(112);

    private int type;

    private MessageType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
    
    public static MessageType getMessageType(int type) {
        for (MessageType messageType: values()) {
            if (messageType.getType() == type) {
                return messageType;
            }
        }
        
        return null;
    }
}
