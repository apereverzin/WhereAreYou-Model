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
import com.creek.whereareyoumodel.domain.sendable.ContactResponse;
import com.creek.whereareyoumodel.message.AbstractMessage;
import com.creek.whereareyoumodel.message.GenericMessageTransformer;
import com.creek.whereareyoumodel.message.OwnerLocationDataMessage;
import com.creek.whereareyoumodel.message.RequestMessage;
import com.creek.whereareyoumodel.message.ResponseMessage;
import com.creek.whereareyoumodel.message.TransformException;
import com.creek.whereareyoumodel.valueobject.SendableLocationData;
import com.creek.whereareyoumodel.valueobject.OwnerRequestResponse;

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
    
    private RequestMessage requestMessage;
    private OwnerRequestResponse ownerRequest;
    private ResponseMessage responseMessage;
    private OwnerRequestResponse ownerResponse;
    private OwnerLocationDataMessage ownerLocationDataMessage;
    private SendableLocationData ownerLocationData;
    private LocationData locationData;
    private long timestamp;

    private static final String EMAIL = "aa@bb.cc";
    private static final float ACCURACY = 100f;
    private static final double LATITUDE = 23.45d;
    private static final double LONGITUDE = 45.67d;
    private static final float SPEED = 20.5f;
    private static final boolean HAS_ACCURACY = true;
    private static final boolean HAS_SPEED = true;
    private static final int REQUEST_CODE = 2;
    private static final String REQUEST_MESSAGE = "Request message";
    private static final int RESPONSE_CODE = 5;
    private static final String RESPONSE_MESSAGE = "Response message";

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        messageTransformer = new GenericMessageTransformer(parser, transformer);
        
        timestamp = System.currentTimeMillis();
    }
    
    @Test
    public void shouldTransformOwnerLocationRequestMessage() throws TransformException, MessagingException, IOException {
        // given
        ContactResponse contactRequest = new ContactResponse();
        contactRequest.setTimeSent(timestamp);
        contactRequest.setCode(REQUEST_CODE);
        contactRequest.setMessage(REQUEST_MESSAGE);
        ownerRequest = new OwnerRequestResponse(contactRequest);  
        requestMessage = new RequestMessage(ownerRequest, EMAIL);
        given(msg.getContent()).willReturn("");
        given(transformer.getResult()).willReturn(requestMessage.toJSON());
        
        // when
        RequestMessage msgReceived = (RequestMessage)messageTransformer.transform(msg);
        
        // then
        assertEquals(timestamp, msgReceived.getOwnerRequestResponse().getTimeSent());
        assertEquals(REQUEST_CODE, msgReceived.getOwnerRequestResponse().getCode());
        assertEquals(REQUEST_MESSAGE, msgReceived.getOwnerRequestResponse().getMessage());
        assertEquals(AbstractMessage.CURRENT_PRODUCT_VERSION, msgReceived.getProductVersion());
    }
    
    @Test
    public void shouldTransformOwnerLocationDataMessage() throws TransformException, MessagingException, IOException {
        // given
        locationData = new LocationData(ACCURACY, LATITUDE, LONGITUDE, SPEED, HAS_ACCURACY, HAS_SPEED);
        ownerLocationData = new SendableLocationData(timestamp, locationData);  
        ownerLocationDataMessage = new OwnerLocationDataMessage(ownerLocationData, EMAIL);
        given(msg.getContent()).willReturn("");
        given(transformer.getResult()).willReturn(ownerLocationDataMessage.toJSON());
        
        // when
        OwnerLocationDataMessage msgReceived = (OwnerLocationDataMessage)messageTransformer.transform(msg);
        
        // then
        assertEquals(timestamp, msgReceived.getOwnerLocationData().getTimeSent());
        assertTrue(msgReceived.getOwnerLocationData().getLocationData().getLocationTime() > 0);
        assertEquals(ACCURACY, msgReceived.getOwnerLocationData().getLocationData().getAccuracy());
        assertEquals(LATITUDE, msgReceived.getOwnerLocationData().getLocationData().getLatitude());
        assertEquals(LONGITUDE, msgReceived.getOwnerLocationData().getLocationData().getLongitude());
        assertEquals(SPEED, msgReceived.getOwnerLocationData().getLocationData().getSpeed());
        assertEquals(HAS_ACCURACY, msgReceived.getOwnerLocationData().getLocationData().hasAccuracy());
        assertEquals(HAS_SPEED, msgReceived.getOwnerLocationData().getLocationData().hasSpeed());
        assertEquals(AbstractMessage.CURRENT_PRODUCT_VERSION, msgReceived.getProductVersion());
    }
    
    @Test
    public void shouldTransformOwnerLocationResponseMessage() throws TransformException, MessagingException, IOException {
        // given
        ContactResponse contactResponse = new ContactResponse();
        contactResponse.setTimeSent(timestamp);
        contactResponse.setCode(RESPONSE_CODE);
        contactResponse.setMessage(RESPONSE_MESSAGE);
        ownerResponse = new OwnerRequestResponse(contactResponse);  
        responseMessage = new ResponseMessage(ownerResponse, EMAIL);
        given(msg.getContent()).willReturn("");
        given(transformer.getResult()).willReturn(responseMessage.toJSON());
        
        // when
        ResponseMessage msgReceived = (ResponseMessage)messageTransformer.transform(msg);
        
        // then
        assertEquals(timestamp, msgReceived.getOwnerRequestResponse().getTimeSent());
        assertEquals(RESPONSE_CODE, msgReceived.getOwnerRequestResponse().getCode());
        assertEquals(RESPONSE_MESSAGE, msgReceived.getOwnerRequestResponse().getMessage());
        assertEquals(AbstractMessage.CURRENT_PRODUCT_VERSION, msgReceived.getProductVersion());
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
