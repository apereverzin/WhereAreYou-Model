package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.creek.whereareyoumodel.domain.LocationData;
import com.creek.whereareyoumodel.domain.OwnerLocationData;
import com.creek.whereareyoumodel.util.JSONTransformer;

/**
 * 
 * @author Andrey Pereverzin
 */
public class OwnerLocationDataMessageTest {
    private static final String EMAIL = "aa@bb.cc";
    private static final float ACCURACY = 100f;
    private static final double LATITUDE = 23.45d;
    private static final double LONGITUDE = 45.67d;
    private static final float SPEED = 20.5f;
    private static final boolean HAS_ACCURACY = true;
    private static final boolean HAS_SPEED = true;
    private static final String VERSION = "1.0";
    
    private OwnerLocationData ownerLocationData;
    private LocationData locationData;
    
    @Test
    public void shouldTransformMessage() throws ParseException {
        long timestamp = System.currentTimeMillis();
        locationData = new LocationData(ACCURACY, LATITUDE, LONGITUDE, SPEED, HAS_ACCURACY, HAS_SPEED);
        ownerLocationData = new OwnerLocationData(EMAIL, timestamp, locationData);  
        
        OwnerLocationDataMessage message = new OwnerLocationDataMessage(ownerLocationData, VERSION, EMAIL);

        JSONObject jsonGroup = message.toJSON();
        String s = jsonGroup.toString();
        JSONParser parser = new JSONParser();
        JSONTransformer transformer = new JSONTransformer();
        parser.parse(s, transformer);

        JSONObject value = (JSONObject) transformer.getResult();

        OwnerLocationDataMessage messageRes = new OwnerLocationDataMessage(value);
        assertEquals(EMAIL, messageRes.getOwnerLocationData().getSenderEmail());
        assertEquals(timestamp, messageRes.getOwnerLocationData().getTimeSent());
        assertTrue(messageRes.getOwnerLocationData().getLocationData().getLocationTime() > 0);
        assertEquals(ACCURACY, messageRes.getOwnerLocationData().getLocationData().getAccuracy());
        assertEquals(LATITUDE, messageRes.getOwnerLocationData().getLocationData().getLatitude());
        assertEquals(LONGITUDE, messageRes.getOwnerLocationData().getLocationData().getLongitude());
        assertEquals(SPEED, messageRes.getOwnerLocationData().getLocationData().getSpeed());
        assertEquals(HAS_ACCURACY, messageRes.getOwnerLocationData().getLocationData().hasAccuracy());
        assertEquals(HAS_SPEED, messageRes.getOwnerLocationData().getLocationData().hasSpeed());
        assertEquals(VERSION, messageRes.getProductVersion());
    }
}
