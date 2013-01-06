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
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;

import com.creek.whereareyoumodel.domain.LocationData;
import com.creek.whereareyoumodel.domain.UserId;
import com.creek.whereareyoumodel.domain.UserLocationData;
import com.creek.whereareyoumodel.message.TransformException;

/**
 * 
 * @author Andrey Pereverzin
 */
public class MessageTransformerTest {
    private MessageTransformer messageTransformer;
    
    @Mock
    private JSONParser parser;
    
    @Mock
    private JSONTransformer transformer;
    
    @Mock
    private Message msg;
    
    @Mock
    private JSONObject jsonObject;
    
    private UserLocationData userLocationData;

    private static final String EMAIL = "aa@bb.cc";
    private static final String LOCATION = "loc";

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        messageTransformer = new MessageTransformer();
        
        messageTransformer.setParser(parser);
        messageTransformer.setTransformer(transformer);

        long timestamp = System.currentTimeMillis();
        UserId userId = new UserId(EMAIL);
        LocationData locationData = new LocationData(LOCATION, timestamp);
        userLocationData = new UserLocationData(userId, locationData);
    }
    
    @Test
    public void shouldTransformMessage() throws TransformException, MessagingException, IOException {
        // given
        given(msg.getContent()).willReturn("");
        given(transformer.getResult()).willReturn(userLocationData.toJSON());
        
        // when
        UserLocationData location = messageTransformer.getUserLocationData(msg);
        
        // then
        assertEquals(EMAIL, location.getUserId().getEmail());
        assertEquals(LOCATION, location.getLocationData().getLocation());
    }
    
    @Test(expected=TransformException.class)
    public void shouldThrowTransformExceptionIfMessagingException() throws TransformException, MessagingException, IOException {
        // given
        given(msg.getContent()).willThrow(new MessagingException());
        
        // when
        messageTransformer.getUserLocationData(msg);
        
        // then
        // throw exception
    }
    
    @Test(expected=TransformException.class)
    public void shouldThrowTransformExceptionIfIOException() throws TransformException, MessagingException, IOException {
        // given
        given(msg.getContent()).willThrow(new IOException());
        
        // when
        messageTransformer.getUserLocationData(msg);
        
        // then
        // throw exception
    }
    
    @Test(expected=TransformException.class)
    public void shouldThrowTransformExceptionIfParseException() throws TransformException, MessagingException, IOException, ParseException {
        // given
        given(msg.getContent()).willReturn("");
        willThrow(new ParseException(0)).given(parser).parse("", transformer);
        
        // when
        messageTransformer.getUserLocationData(msg);
        
        // then
        // throw exception
    }
}
