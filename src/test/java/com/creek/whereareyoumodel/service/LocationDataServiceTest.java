package com.creek.whereareyoumodel.service;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.mail.Message;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;

import com.creek.emailaccess.connector.mail.ConnectorException;
import com.creek.emailaccess.connector.mail.MailConnector;
import com.creek.whereareyoumodel.domain.LocationData;
import com.creek.whereareyoumodel.domain.UserId;
import com.creek.whereareyoumodel.domain.UserLocationData;
import com.creek.whereareyoumodel.message.TransformException;
import com.creek.whereareyoumodel.util.MessageTransformer;

/**
 * 
 * @author Andrey Pereverzin
 */
public class LocationDataServiceTest {
    private LocationDataService service;
    
    private static final String EMAIL = "aa@bb.cc";
    private static final String LOCATION = "loc";

    @Mock
    private MailConnector connector;
    
    @Mock
    private MessageTransformer messageTransformer;
    
    @Mock
    private Message msg;
    
    private UserLocationData userLocationData;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        long timestamp = System.currentTimeMillis();
        UserId userId = new UserId(EMAIL);
        LocationData locationData = new LocationData(LOCATION, timestamp);
        userLocationData = new UserLocationData(userId, locationData);
        
        service = new LocationDataService(new Properties(), messageTransformer);
        service.setMailConnector(connector);
    }
    
    @Test
    public void shouldReceiveLocationsSuccessfully() throws ConnectorException, ServiceException, TransformException {
        // given
        Set<Message> messages = new HashSet<Message>();
        messages.add(msg);
        given(connector.receiveMessages(LocationDataService.I_AM_HERE_SUBJECT)).willReturn(messages);
        given(messageTransformer.getUserLocationData(msg)).willReturn(userLocationData);
        
        // when
        Set<UserLocationData> locations = service.receiveUserLocationData();
        
        // then
        assertEquals(1, locations.size());
    }
    
    @Test(expected=TransformException.class)
    public void shouldThrowTransformExceptionIfTransformExceptionThrownWhenReceivingMessages() throws ConnectorException, ServiceException, TransformException {
        // given
        Set<Message> messages = new HashSet<Message>();
        messages.add(msg);
        given(connector.receiveMessages(LocationDataService.I_AM_HERE_SUBJECT)).willReturn(messages);
        given(messageTransformer.getUserLocationData(msg)).willThrow(new TransformException(""));
        
        // when
        Set<UserLocationData> locations = service.receiveUserLocationData();
        
        // then
        assertEquals(1, locations.size());
    }
    
    @Test(expected=ServiceException.class)
    public void shouldThrowServiceExceptionIfConnectorExceptionThrownWhenReceivingMessages() throws ConnectorException, ServiceException, TransformException {
        // given
        given(connector.receiveMessages(LocationDataService.I_AM_HERE_SUBJECT)).willThrow(new ConnectorException(""));
        
        // when
        service.receiveUserLocationData();
        
        // then
        // throws exception
    }
    
    @Test
    public void shouldSendMessagesSuccessfully() throws ConnectorException, ServiceException, TransformException {
        // given
        String[] emailsTo = new String[]{};
        
        // when
        service.sendUserLocationData(userLocationData, emailsTo);
        
        // then
    }
    
    @Test(expected=ServiceException.class)
    public void shouldThrowServiceExceptionIfConnectorExceptionThrownWhenSendingMessages() throws ConnectorException, ServiceException, TransformException {
        // given
        String[] emailsTo = new String[]{};
        willThrow(new ConnectorException("")).given(connector).sendMessage(
                LocationDataService.I_AM_HERE_SUBJECT, EMAIL, userLocationData.toJSON().toString(), emailsTo);
        
        // when
        service.sendUserLocationData(userLocationData, emailsTo);
        
        // then
        // throws exception
    }
}
