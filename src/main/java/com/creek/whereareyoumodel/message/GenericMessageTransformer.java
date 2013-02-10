package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;

/**
 * 
 * @author Andrey Pereverzin
 *
 */
public class GenericMessageTransformer {
    public static GenericMessage transform(JSONObject jsonObject) throws TransformException {
        int messageType;
        
        try {
            messageType = Integer.parseInt((String)jsonObject.get(AbstractMessage.MESSAGE_TYPE));
        } catch(Exception ex) {
            throw new TransformException(ex);
        }
        
        if(messageType == GenericMessage.USER_LOCATION_MESSAGE) {
            return new UserLocationMessage(jsonObject);
        } else if(messageType == GenericMessage.USER_LOCATION_MESSAGE_CONFIRMATION) {
            return new UserLocationConfirmationMessage(jsonObject);
        } else {
            throw new TransformException("Unknown message type " + messageType);
        }
    }
}
