package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.creek.whereareyoumodel.domain.sendable.ContactRequest;
import com.creek.whereareyoumodel.domain.sendable.RequestCode;
import com.creek.whereareyoumodel.util.JSONTransformer;
import com.creek.whereareyoumodel.valueobject.OwnerRequest;

/**
 * 
 * @author Andrey Pereverzin
 */
public class OwnerRequestMessageTest {
    private static final String EMAIL = "aa@bb.cc";
    private static final RequestCode REQUEST_CODE = RequestCode.LOCATION;
    private static final String REQUEST_MESSAGE = "Request message";
    
    private OwnerRequest ownerRequest;
    
    @Test
    public void shouldTransformMessage() throws ParseException {
        // given
        long timestamp = System.currentTimeMillis();
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setTimeSent(timestamp);
        contactRequest.setRequestCode(REQUEST_CODE);
        contactRequest.setMessage(REQUEST_MESSAGE);
        ownerRequest = new OwnerRequest(contactRequest);  
        
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
        assertEquals(timestamp, messageRes.getOwnerRequest().getTimeSent());
        assertTrue(messageRes.getOwnerRequest().getTimeSent() > 0);
        assertEquals(REQUEST_CODE.getCode(), messageRes.getOwnerRequest().getRequestCode());
        assertEquals(REQUEST_MESSAGE, messageRes.getOwnerRequest().getMessage());
        assertEquals(AbstractMessage.CURRENT_PRODUCT_VERSION, messageRes.getProductVersion());
    }
}
