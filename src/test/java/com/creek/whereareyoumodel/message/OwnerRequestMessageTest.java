package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.creek.whereareyoumodel.util.JSONTransformer;
import com.creek.whereareyoumodel.valueobject.OwnerRequest;

/**
 * 
 * @author Andrey Pereverzin
 */
public class OwnerRequestMessageTest {
    private static final String EMAIL = "aa@bb.cc";
    private static final int REQUEST_CODE = 4;
    private static final String REQUEST_MESSAGE = "Request message";
    
    private OwnerRequest ownerLocationRequest;
    
    @Test
    public void shouldTransformMessage() throws ParseException {
        long timestamp = System.currentTimeMillis();
        ownerLocationRequest = new OwnerRequest(timestamp, REQUEST_CODE, REQUEST_MESSAGE);  
        
        RequestMessage message = new RequestMessage(ownerLocationRequest, EMAIL);

        JSONObject jsonGroup = message.toJSON();
        String s = jsonGroup.toString();
        JSONParser parser = new JSONParser();
        JSONTransformer transformer = new JSONTransformer();
        parser.parse(s, transformer);

        JSONObject value = (JSONObject) transformer.getResult();

        RequestMessage messageRes = new RequestMessage(value);
        assertEquals(timestamp, messageRes.getOwnerRequest().getTimeSent());
        assertTrue(messageRes.getOwnerRequest().getTimeSent() > 0);
        assertEquals(REQUEST_CODE, messageRes.getOwnerRequest().getCode());
        assertEquals(REQUEST_MESSAGE, messageRes.getOwnerRequest().getMessage());
        assertEquals(AbstractMessage.CURRENT_PRODUCT_VERSION, messageRes.getProductVersion());
    }
}
