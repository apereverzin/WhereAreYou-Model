package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.creek.whereareyoumodel.domain.OwnerLocationRequest;
import com.creek.whereareyoumodel.util.JSONTransformer;

/**
 * 
 * @author Andrey Pereverzin
 */
public class OwnerLocationRequestMessageTest {
    private static final String EMAIL = "aa@bb.cc";
    private static final int REQUEST_CODE = 4;
    private static final String REQUEST_MESSAGE = "Request mesage";
    private static final String VERSION = "1.0";
    
    private OwnerLocationRequest ownerLocationRequest;
    
    @Test
    public void shouldTransformMessage() throws ParseException {
        long timestamp = System.currentTimeMillis();
        ownerLocationRequest = new OwnerLocationRequest(EMAIL, timestamp, REQUEST_CODE, REQUEST_MESSAGE);  
        
        OwnerLocationRequestMessage message = new OwnerLocationRequestMessage(ownerLocationRequest, VERSION, EMAIL);

        JSONObject jsonGroup = message.toJSON();
        String s = jsonGroup.toString();
        JSONParser parser = new JSONParser();
        JSONTransformer transformer = new JSONTransformer();
        parser.parse(s, transformer);

        JSONObject value = (JSONObject) transformer.getResult();

        OwnerLocationRequestMessage messageRes = new OwnerLocationRequestMessage(value);
        assertEquals(EMAIL, messageRes.getOwnerLocationRequest().getSenderEmail());
        assertEquals(timestamp, messageRes.getOwnerLocationRequest().getTimeSent());
        assertTrue(messageRes.getOwnerLocationRequest().getTimeSent() > 0);
        assertEquals(REQUEST_CODE, messageRes.getOwnerLocationRequest().getRequestCode());
        assertEquals(REQUEST_MESSAGE, messageRes.getOwnerLocationRequest().getMessage());
        assertEquals(VERSION, messageRes.getProductVersion());
    }
}
