package com.creek.whereareyoumodel.message;

import javax.mail.Message;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.creek.whereareyoumodel.util.JSONTransformer;

/**
 * 
 * @author Andrey Pereverzin
 *
 */
public class GenericMessageTransformer {
    private final JSONParser parser;
    private final JSONTransformer transformer;

    public GenericMessageTransformer() {
        this.parser = new JSONParser();
        this.transformer = new JSONTransformer();
    }

    public GenericMessageTransformer(JSONParser parser, JSONTransformer transformer) {
        this.parser = parser;
        this.transformer = transformer;
    }

    public GenericMessage transform(Message msg) throws TransformException {
        int messageType;

        try {
            String content = (String) msg.getContent();
            parser.parse(content, transformer);

            JSONObject jsonObject = (JSONObject) transformer.getResult();
            messageType = Integer.parseInt((String) jsonObject.get(AbstractMessage.MESSAGE_TYPE));

            if (messageType == GenericMessage.OWNER_LOCATION_REQUEST_MESSAGE) {
                return new OwnerLocationRequestMessage(jsonObject);
            } else if (messageType == GenericMessage.OWNER_LOCATION_RESPONSE_MESSAGE) {
                return new OwnerLocationResponseMessage(jsonObject);
            } else if (messageType == GenericMessage.OWNER_LOCATION_DATA_MESSAGE) {
                return new OwnerLocationDataMessage(jsonObject);
            } else {
                throw new TransformException("Unknown message type " + messageType);
            }
        } catch (Exception ex) {
            throw new TransformException(ex);
        }
    }
}
