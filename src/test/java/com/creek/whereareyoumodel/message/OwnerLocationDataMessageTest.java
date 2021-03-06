package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.creek.whereareyoumodel.domain.LocationData;
import com.creek.whereareyoumodel.util.JSONTransformer;
import com.creek.whereareyoumodel.valueobject.SendableLocationData;

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
    
    private SendableLocationData ownerLocationData;
    private LocationData locationData;
    
    @Test
    public void shouldTransformMessage() throws ParseException {
        // given
        locationData = new LocationData();
        locationData.setLocationTime(System.currentTimeMillis());
        locationData.setAccuracy(ACCURACY);
        locationData.setLatitude(LATITUDE);
        locationData.setLongitude(LONGITUDE);
        locationData.setSpeed(SPEED);
        locationData.setHasAccuracy(HAS_ACCURACY);
        locationData.setHasSpeed(HAS_SPEED);
        ownerLocationData = new SendableLocationData(locationData);  
        
        OwnerLocationDataMessage message = new OwnerLocationDataMessage(ownerLocationData, EMAIL);

        // when
        JSONObject jsonGroup = message.toJSON();
        String s = jsonGroup.toString();
        JSONParser parser = new JSONParser();
        JSONTransformer transformer = new JSONTransformer();
        parser.parse(s, transformer);

        JSONObject value = (JSONObject) transformer.getResult();
        
        // then
        OwnerLocationDataMessage messageRes = new OwnerLocationDataMessage(value);
        assertTrue(messageRes.getOwnerLocationData().getTimeSent() > 0);
        assertTrue(messageRes.getOwnerLocationData().getLocationData().getLocationTime() > 0);
        assertEquals(ACCURACY, messageRes.getOwnerLocationData().getLocationData().getAccuracy());
        assertEquals(LATITUDE, messageRes.getOwnerLocationData().getLocationData().getLatitude());
        assertEquals(LONGITUDE, messageRes.getOwnerLocationData().getLocationData().getLongitude());
        assertEquals(SPEED, messageRes.getOwnerLocationData().getLocationData().getSpeed());
        assertEquals(HAS_ACCURACY, messageRes.getOwnerLocationData().getLocationData().hasAccuracy());
        assertEquals(HAS_SPEED, messageRes.getOwnerLocationData().getLocationData().hasSpeed());
        assertEquals(AbstractMessage.CURRENT_PRODUCT_VERSION, messageRes.getProductVersion());
    }
}
