package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.creek.whereareyoumodel.domain.RequestResponse;
import com.creek.whereareyoumodel.util.JSONTransformer;
import com.creek.whereareyoumodel.valueobject.OwnerRequestResponse;

/**
 * 
 * @author Andrey Pereverzin
 */
public class OwnerResponseMessageTest {
    private static final String EMAIL = "aa@bb.cc";
    private static final int RESPONSE_CODE = 6;
    private static final String RESPONSE_MESSAGE = "Response message";
    
    private OwnerRequestResponse ownerResponse;
    
    @Test
    public void shouldTransformMessage() throws ParseException {
        // given
        long timestamp = System.currentTimeMillis();
        RequestResponse contactResponse = new RequestResponse();
        contactResponse.setTimeSent(timestamp);
        contactResponse.setCode(RESPONSE_CODE);
        contactResponse.setMessage(RESPONSE_MESSAGE);
        ownerResponse = new OwnerRequestResponse(contactResponse);  
        
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
        assertEquals(timestamp, messageRes.getOwnerRequestResponse().getTimeSent());
        assertTrue(messageRes.getOwnerRequestResponse().getTimeSent() > 0);
        assertEquals(RESPONSE_CODE, messageRes.getOwnerRequestResponse().getCode());
        assertEquals(RESPONSE_MESSAGE, messageRes.getOwnerRequestResponse().getMessage());
        assertEquals(AbstractMessage.CURRENT_PRODUCT_VERSION, messageRes.getProductVersion());
    }
}
