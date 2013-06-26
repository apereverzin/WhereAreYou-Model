package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.creek.whereareyoumodel.domain.sendable.ContactResponse;
import com.creek.whereareyoumodel.domain.sendable.ResponseCode;
import com.creek.whereareyoumodel.util.JSONTransformer;
import com.creek.whereareyoumodel.valueobject.OwnerResponse;

/**
 * 
 * @author Andrey Pereverzin
 */
public class OwnerResponseMessageTest {
    private static final String EMAIL = "aa@bb.cc";
    private static final ResponseCode RESPONSE_CODE = ResponseCode.FAILURE;
    private static final String RESPONSE_MESSAGE = "Response message";
    
    private OwnerResponse ownerResponse;
    
    @Test
    public void shouldTransformMessage() throws ParseException {
        // given
        long timestamp = System.currentTimeMillis();
        ContactResponse contactResponse = new ContactResponse();
        contactResponse.setTimeSent(timestamp);
        contactResponse.setResponseCode(RESPONSE_CODE);
        contactResponse.setMessage(RESPONSE_MESSAGE);
        ownerResponse = new OwnerResponse(contactResponse);  
        
        ResponseMessage message = new ResponseMessage(ownerResponse, EMAIL);

        // when
        JSONObject jsonMessage = message.toJSON();
        String s = jsonMessage.toString();
        JSONParser parser = new JSONParser();
        JSONTransformer transformer = new JSONTransformer();
        parser.parse(s, transformer);

        JSONObject value = (JSONObject) transformer.getResult();

        // then
        ResponseMessage messageRes = new ResponseMessage(value);
        assertEquals(timestamp, messageRes.getOwnerResponse().getTimeSent());
        assertTrue(messageRes.getOwnerResponse().getTimeSent() > 0);
        assertEquals(RESPONSE_CODE.getCode(), messageRes.getOwnerResponse().getResponseCode());
        assertEquals(RESPONSE_MESSAGE, messageRes.getOwnerResponse().getMessage());
        assertEquals(AbstractMessage.CURRENT_PRODUCT_VERSION, messageRes.getProductVersion());
    }
}
