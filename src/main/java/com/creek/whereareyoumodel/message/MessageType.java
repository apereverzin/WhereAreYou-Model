package com.creek.whereareyoumodel.message;

/**
 * 
 * @author Andrey Pereverzin
 */
public enum MessageType {
    REQUEST_MESSAGE(110),
    RESPONSE_MESSAGE(111),
    OWNER_LOCATION_DATA_MESSAGE(112);

    private final int type;

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
