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
public class OwnerRequestMessageTest {
    private static final String EMAIL = "aa@bb.cc";
    private static final int REQUEST_CODE = 4;
    private static final String REQUEST_MESSAGE = "Request message";
    
    private OwnerRequestResponse ownerRequest;
    
    @Test
    public void shouldTransformMessage() throws ParseException {
        // given
        long timestamp = System.currentTimeMillis();
        RequestResponse contactRequest = new RequestResponse();
        contactRequest.setTimeSent(timestamp);
        contactRequest.setCode(REQUEST_CODE);
        contactRequest.setMessage(REQUEST_MESSAGE);
        ownerRequest = new OwnerRequestResponse(contactRequest);  
        
        RequestMessage message = new RequestMessage(ownerRequest, EMAIL);

        // when
        JSONObject jsonGroup = message.toJSON();
        String s = jsonGroup.toString();
        JSONParser parser = new JSONParser();
        JSONTransformer transformer = new JSONTransformer();
        parser.parse(s, transformer);

        JSONObject value = (JSONObject) transformer.getResult();

        // then
        RequestMessage messageRes = new RequestMessage(value);
        assertEquals(timestamp, messageRes.getOwnerRequestResponse().getTimeSent());
        assertTrue(messageRes.getOwnerRequestResponse().getTimeSent() > 0);
        assertEquals(REQUEST_CODE, messageRes.getOwnerRequestResponse().getCode());
        assertEquals(REQUEST_MESSAGE, messageRes.getOwnerRequestResponse().getMessage());
        assertEquals(AbstractMessage.CURRENT_PRODUCT_VERSION, messageRes.getProductVersion());
    }
}
