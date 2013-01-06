package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.creek.whereareyoumodel.domain.LocationData;
import com.creek.whereareyoumodel.domain.UserId;
import com.creek.whereareyoumodel.domain.UserLocationData;
import com.creek.whereareyoumodel.util.JSONTransformer;

/**
 * 
 * @author Andrey Pereverzin
 */
public class UserLocationMessageTest {
    private static final String EMAIL = "aa@bb.cc";
    private static final String LOCATION = "loc";
    private static final String VERSION = "1.0";
    
    @Test
    public void testTransformUserLocationMessage() throws ParseException {
        long timestamp = System.currentTimeMillis();
        
        UserId userId = new UserId(EMAIL);
        LocationData locationData = new LocationData(LOCATION, timestamp);
        UserLocationData userLocationData = new UserLocationData(userId, locationData);
        UserLocationMessage message = new UserLocationMessage(userLocationData, VERSION);

        JSONObject jsonGroup = message.toJSON();
        String s = jsonGroup.toString();
        JSONParser parser = new JSONParser();
        JSONTransformer transformer = new JSONTransformer();
        System.out.println(s);
        parser.parse(s, transformer);

        JSONObject value = (JSONObject) transformer.getResult();

        UserLocationMessage messageRes = new UserLocationMessage(value);
        assertEquals(EMAIL, messageRes.getUserLocation().getUserId().getEmail());
        assertEquals(LOCATION, messageRes.getUserLocation().getLocationData().getLocation());
        assertEquals(timestamp, messageRes.getUserLocation().getLocationData().getTimestamp());
        assertEquals(VERSION, messageRes.getProductVersion());
    }
}
