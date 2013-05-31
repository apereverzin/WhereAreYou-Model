package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.creek.whereareyoumodel.util.JSONTransformer;
import com.creek.whereareyoumodel.valueobject.OwnerResponse;

/**
 * 
 * @author Andrey Pereverzin
 */
public class OwnerResponseMessageTest {
    private static final String EMAIL = "aa@bb.cc";
    private static final int RESPONSE_CODE = 6;
    private static final String RESPONSE_MESSAGE = "Response message";
    
    private OwnerResponse ownerResponse;
    
    @Test
    public void shouldTransformMessage() throws ParseException {
        long timestamp = System.currentTimeMillis();
        ownerResponse = new OwnerResponse(timestamp, RESPONSE_CODE, RESPONSE_MESSAGE);  
        
        ResponseMessage message = new ResponseMessage(ownerResponse, EMAIL);

        JSONObject jsonMessage = message.toJSON();
        String s = jsonMessage.toString();
        JSONParser parser = new JSONParser();
        JSONTransformer transformer = new JSONTransformer();
        parser.parse(s, transformer);

        JSONObject value = (JSONObject) transformer.getResult();

        ResponseMessage messageRes = new ResponseMessage(value);
        assertEquals(timestamp, messageRes.getOwnerResponse().getTimeSent());
        assertTrue(messageRes.getOwnerResponse().getTimeSent() > 0);
        assertEquals(RESPONSE_CODE, messageRes.getOwnerResponse().getCode());
        assertEquals(RESPONSE_MESSAGE, messageRes.getOwnerResponse().getMessage());
        assertEquals(AbstractMessage.CURRENT_PRODUCT_VERSION, messageRes.getProductVersion());
    }
}
