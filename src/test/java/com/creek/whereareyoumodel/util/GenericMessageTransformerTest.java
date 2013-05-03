package com.creek.whereareyoumodel.util;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;

import com.creek.whereareyoumodel.domain.LocationData;
import com.creek.whereareyoumodel.domain.OwnerLocationData;
import com.creek.whereareyoumodel.domain.OwnerLocationRequest;
import com.creek.whereareyoumodel.domain.OwnerLocationResponse;
import com.creek.whereareyoumodel.message.GenericMessageTransformer;
import com.creek.whereareyoumodel.message.OwnerLocationDataMessage;
import com.creek.whereareyoumodel.message.OwnerLocationRequestMessage;
import com.creek.whereareyoumodel.message.OwnerLocationResponseMessage;
import com.creek.whereareyoumodel.message.TransformException;

/**
 * 
 * @author Andrey Pereverzin
 */
public class GenericMessageTransformerTest {
    private GenericMessageTransformer messageTransformer;
    
    @Mock
    private JSONParser parser;
    
    @Mock
    private JSONTransformer transformer;
    
    @Mock
    private Message msg;
    
    @Mock
    private JSONObject jsonObject;
    
    private OwnerLocationRequestMessage ownerLocationRequestMessage;
    private OwnerLocationRequest ownerLocationRequest;
    private OwnerLocationResponseMessage ownerLocationResponseMessage;
    private OwnerLocationResponse ownerLocationResponse;
    private OwnerLocationDataMessage ownerLocationDataMessage;
    private OwnerLocationData ownerLocationData;
    private LocationData locationData;
    private long timestamp;

    private static final String EMAIL = "aa@bb.cc";
    private static final float ACCURACY = 100f;
    private static final double LATITUDE = 23.45d;
    private static final double LONGITUDE = 45.67d;
    private static final float SPEED = 20.5f;
    private static final boolean HAS_ACCURACY = true;
    private static final boolean HAS_SPEED = true;
    private static final String VERSION = "1.0";
    private static final int REQUEST_CODE = 2;
    private static final String REQUEST_MESSAGE = "Request mesage";
    private static final int RESPONSE_CODE = 5;
    private static final String RESPONSE_MESSAGE = "Response mesage";

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        messageTransformer = new GenericMessageTransformer(parser, transformer);
        
        timestamp = System.currentTimeMillis();
    }
    
    @Test
    public void shouldTransformOwnerLocationRequestMessage() throws TransformException, MessagingException, IOException {
        // given
        ownerLocationRequest = new OwnerLocationRequest(EMAIL, timestamp, REQUEST_CODE, REQUEST_MESSAGE);  
        ownerLocationRequestMessage = new OwnerLocationRequestMessage(ownerLocationRequest, VERSION, EMAIL);
        given(msg.getContent()).willReturn("");
        given(transformer.getResult()).willReturn(ownerLocationRequestMessage.toJSON());
        
        // when
        OwnerLocationRequestMessage msgReceived = (OwnerLocationRequestMessage)messageTransformer.transform(msg);
        
        // then
        assertEquals(EMAIL, msgReceived.getOwnerLocationRequest().getSenderEmail());
        assertEquals(timestamp, msgReceived.getOwnerLocationRequest().getTimeSent());
        assertEquals(REQUEST_CODE, msgReceived.getOwnerLocationRequest().getRequestCode());
        assertEquals(REQUEST_MESSAGE, msgReceived.getOwnerLocationRequest().getMessage());
        assertEquals(VERSION, msgReceived.getProductVersion());
    }
    
    @Test
    public void shouldTransformOwnerLocationResponseMessage() throws TransformException, MessagingException, IOException {
        // given
        ownerLocationResponse = new OwnerLocationResponse(EMAIL, timestamp, RESPONSE_CODE, RESPONSE_MESSAGE);  
        ownerLocationResponseMessage = new OwnerLocationResponseMessage(ownerLocationResponse, VERSION, EMAIL);
        given(msg.getContent()).willReturn("");
        given(transformer.getResult()).willReturn(ownerLocationResponseMessage.toJSON());
        
        // when
        OwnerLocationResponseMessage msgReceived = (OwnerLocationResponseMessage)messageTransformer.transform(msg);
        
        // then
        assertEquals(EMAIL, msgReceived.getOwnerLocationResponse().getSenderEmail());
        assertEquals(timestamp, msgReceived.getOwnerLocationResponse().getTimeSent());
        assertEquals(RESPONSE_CODE, msgReceived.getOwnerLocationResponse().getResponseCode());
        assertEquals(RESPONSE_MESSAGE, msgReceived.getOwnerLocationResponse().getMessage());
        assertEquals(VERSION, msgReceived.getProductVersion());
    }
    
    @Test
    public void shouldTransformOwnerLocationDataMessage() throws TransformException, MessagingException, IOException {
        // given
        locationData = new LocationData(ACCURACY, LATITUDE, LONGITUDE, SPEED, HAS_ACCURACY, HAS_SPEED);
        ownerLocationData = new OwnerLocationData(EMAIL, timestamp, locationData);  
        ownerLocationDataMessage = new OwnerLocationDataMessage(ownerLocationData, VERSION, EMAIL);
        given(msg.getContent()).willReturn("");
        given(transformer.getResult()).willReturn(ownerLocationDataMessage.toJSON());
        
        // when
        OwnerLocationDataMessage msgReceived = (OwnerLocationDataMessage)messageTransformer.transform(msg);
        
        // then
        assertEquals(EMAIL, msgReceived.getOwnerLocationData().getSenderEmail());
        assertEquals(timestamp, msgReceived.getOwnerLocationData().getTimeSent());
        assertTrue(msgReceived.getOwnerLocationData().getLocationData().getLocationTime() > 0);
        assertEquals(ACCURACY, msgReceived.getOwnerLocationData().getLocationData().getAccuracy());
        assertEquals(LATITUDE, msgReceived.getOwnerLocationData().getLocationData().getLatitude());
        assertEquals(LONGITUDE, msgReceived.getOwnerLocationData().getLocationData().getLongitude());
        assertEquals(SPEED, msgReceived.getOwnerLocationData().getLocationData().getSpeed());
        assertEquals(HAS_ACCURACY, msgReceived.getOwnerLocationData().getLocationData().hasAccuracy());
        assertEquals(HAS_SPEED, msgReceived.getOwnerLocationData().getLocationData().hasSpeed());
        assertEquals(VERSION, msgReceived.getProductVersion());
    }
    
    @Test(expected=TransformException.class)
    public void shouldThrowTransformExceptionIfMessagingException() throws TransformException, MessagingException, IOException {
        // given
        given(msg.getContent()).willThrow(new MessagingException());
        
        // when
        messageTransformer.transform(msg);
        
        // then
        // throw exception
    }
    
    @Test(expected=TransformException.class)
    public void shouldThrowTransformExceptionIfIOException() throws TransformException, MessagingException, IOException {
        // given
        given(msg.getContent()).willThrow(new IOException());
        
        // when
        messageTransformer.transform(msg);
        
        // then
        // throw exception
    }
    
    @Test(expected=TransformException.class)
    public void shouldThrowTransformExceptionIfParseException() throws TransformException, MessagingException, IOException, ParseException {
        // given
        given(msg.getContent()).willReturn("");
        willThrow(new ParseException(0)).given(parser).parse("", transformer);
        
        // when
        messageTransformer.transform(msg);
        
        // then
        // throw exception
    }
}
