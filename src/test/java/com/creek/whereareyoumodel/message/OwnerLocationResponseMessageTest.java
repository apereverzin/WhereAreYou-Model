package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.creek.whereareyoumodel.domain.OwnerLocationResponse;
import com.creek.whereareyoumodel.util.JSONTransformer;

/**
 * 
 * @author Andrey Pereverzin
 */
public class OwnerLocationResponseMessageTest {
    private static final String EMAIL = "aa@bb.cc";
    private static final int RESPONSE_CODE = 6;
    private static final String RESPONSE_MESSAGE = "Response mesage";
    private static final String VERSION = "1.0";
    
    private OwnerLocationResponse ownerLocationResponse;
    
    @Test
    public void shouldTransformMessage() throws ParseException {
        long timestamp = System.currentTimeMillis();
        ownerLocationResponse = new OwnerLocationResponse(EMAIL, timestamp, RESPONSE_CODE, RESPONSE_MESSAGE);  
        
        OwnerLocationResponseMessage message = new OwnerLocationResponseMessage(ownerLocationResponse, VERSION, EMAIL);

        JSONObject jsonGroup = message.toJSON();
        String s = jsonGroup.toString();
        JSONParser parser = new JSONParser();
        JSONTransformer transformer = new JSONTransformer();
        parser.parse(s, transformer);

        JSONObject value = (JSONObject) transformer.getResult();

        OwnerLocationResponseMessage messageRes = new OwnerLocationResponseMessage(value);
        assertEquals(EMAIL, messageRes.getOwnerLocationResponse().getSenderEmail());
        assertEquals(timestamp, messageRes.getOwnerLocationResponse().getTimeSent());
        assertTrue(messageRes.getOwnerLocationResponse().getTimeSent() > 0);
        assertEquals(RESPONSE_CODE, messageRes.getOwnerLocationResponse().getResponseCode());
        assertEquals(RESPONSE_MESSAGE, messageRes.getOwnerLocationResponse().getMessage());
        assertEquals(VERSION, messageRes.getProductVersion());
    }
}
