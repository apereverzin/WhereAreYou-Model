package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.creek.whereareyoumodel.domain.UserId;
import com.creek.whereareyoumodel.util.JSONTransformer;

/**
 * 
 * @author Andrey Pereverzin
 */
public class UserLocationConfirmationMessageTest {
    private static final String EMAIL = "aa@bb.cc";
    private static final String VERSION = "1.0";
    
    @Test
    public void testTransformUserLocationConfirmationMessage() throws ParseException {
        UserId userId = new UserId(EMAIL);
        long timestamp = System.currentTimeMillis();
        
        UserLocationConfirmationMessage message = new UserLocationConfirmationMessage(userId, timestamp, VERSION);

        JSONObject jsonGroup = message.toJSON();
        String s = jsonGroup.toString();
        JSONParser parser = new JSONParser();
        JSONTransformer transformer = new JSONTransformer();
        parser.parse(s, transformer);

        JSONObject value = (JSONObject) transformer.getResult();

        UserLocationConfirmationMessage messageRes = new UserLocationConfirmationMessage(value);
        assertEquals(EMAIL, messageRes.getUserId().getEmail());
        assertEquals(timestamp, messageRes.getTimestamp());
        assertEquals(VERSION, messageRes.getProductVersion());
    }
}
