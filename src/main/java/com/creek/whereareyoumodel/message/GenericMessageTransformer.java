package com.creek.whereareyoumodel.message;

import javax.mail.Message;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.creek.whereareyoumodel.util.JSONTransformer;
import static com.creek.whereareyoumodel.message.MessageType.REQUEST_MESSAGE;
import static com.creek.whereareyoumodel.message.MessageType.RESPONSE_MESSAGE;
import static com.creek.whereareyoumodel.message.MessageType.OWNER_LOCATION_DATA_MESSAGE;

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

    public GenericMessage transform(String content) throws TransformException {
        MessageType messageType;

        try {
            parser.parse(content, transformer);

            JSONObject jsonObject = (JSONObject) transformer.getResult();
            messageType = MessageType.getMessageType(Integer.parseInt((String) jsonObject.get(AbstractMessage.MESSAGE_TYPE)));

            if (messageType == REQUEST_MESSAGE) {
                return new RequestMessage(jsonObject);
            } else if (messageType == RESPONSE_MESSAGE) {
                return new ResponseMessage(jsonObject);
            } else if (messageType == OWNER_LOCATION_DATA_MESSAGE) {
                return new OwnerLocationDataMessage(jsonObject);
            } else {
                throw new TransformException("Unknown message type " + messageType);
            }
        } catch (Exception ex) {
            throw new TransformException(ex);
        }
    }
}
