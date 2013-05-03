package com.creek.whereareyoumodel.service;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.mail.Message;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.Mock;
import static org.mockito.Matchers.any;
import org.mockito.MockitoAnnotations;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;

import com.creek.accessemail.connector.mail.ConnectorException;
import com.creek.accessemail.connector.mail.MailConnector;
import com.creek.whereareyoumodel.domain.OwnerLocationData;
import com.creek.whereareyoumodel.domain.OwnerLocationRequest;
import com.creek.whereareyoumodel.domain.OwnerLocationResponse;
import com.creek.whereareyoumodel.message.GenericMessage;
import com.creek.whereareyoumodel.message.GenericMessageTransformer;
import com.creek.whereareyoumodel.message.OwnerLocationDataMessage;
import com.creek.whereareyoumodel.message.OwnerLocationRequestMessage;
import com.creek.whereareyoumodel.message.OwnerLocationResponseMessage;
import com.creek.whereareyoumodel.message.TransformException;

/**
 * 
 * @author Andrey Pereverzin
 */
public class LocationMessagesServiceTest {
    private LocationMessagesService service;
    
    private static final String EMAIL = "aa@bb.cc";
    private static final String LOCATION = "loc";

    @Mock
    private MailConnector connector;
    
    @Mock
    private GenericMessageTransformer messageTransformer;
    
    @Mock
    private OwnerLocationRequestMessage ownerLocationRequestMessage;
    @Mock
    private OwnerLocationResponseMessage ownerLocationResponseMessage;
    @Mock
    private OwnerLocationDataMessage ownerLocationDataMessage;
    
    @Mock
    private Message message1;
    @Mock
    private Message message2;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        service = new LocationMessagesService(new Properties(), messageTransformer);
        service.setMailConnector(connector);
    }
    
    @Test
    public void shouldReceiveMessagesSuccessfully() throws ConnectorException, ServiceException, TransformException {
        // given
        Set<Message> messages = new HashSet<Message>();
        messages.add(message1);
        messages.add(message2);
        given(connector.receiveMessages(LocationMessagesService.WHERE_ARE_YOU_SUBJECT)).willReturn(messages);
        given(messageTransformer.transform(any(Message.class))).willReturn(ownerLocationResponseMessage).willReturn(ownerLocationDataMessage);
        
        // when
        Set<GenericMessage> messagesReceived = service.receiveMessages();
        
        // then
        assertEquals(2, messagesReceived.size());
    }
    
    @Test(expected=TransformException.class)
    public void shouldThrowTransformExceptionIfTransformExceptionThrownWhenReceivingMessages() throws ConnectorException, ServiceException, TransformException {
        // given
        Set<Message> messages = new HashSet<Message>();
        messages.add(message1);
        given(connector.receiveMessages(LocationMessagesService.WHERE_ARE_YOU_SUBJECT)).willReturn(messages);
        given(messageTransformer.transform(any(Message.class))).willThrow(new TransformException(""));
        
        // when
        service.receiveMessages();
        
        // then
        // throws exception
    }
    
    @Test(expected=ServiceException.class)
    public void shouldThrowServiceExceptionIfConnectorExceptionThrownWhenReceivingMessages() throws ConnectorException, ServiceException, TransformException {
        // given
        given(connector.receiveMessages(LocationMessagesService.WHERE_ARE_YOU_SUBJECT)).willThrow(new ConnectorException(""));
        
        // when
        service.receiveMessages();
        
        // then
        // throws exception
    }
    
    @Test
    public void shouldSendOwnerLocationRequestMessageSuccessfully() throws ConnectorException, ServiceException, TransformException {
        // given
        String[] emailsTo = new String[]{};
        given(ownerLocationRequestMessage.toJSON()).willReturn(new JSONObject());
        
        // when
        service.sendOwnerLocationRequestMessage(ownerLocationRequestMessage, emailsTo);
        
        // then
    }
    
    @Test
    public void shouldSendOwnerLocationResponseMessageSuccessfully() throws ConnectorException, ServiceException, TransformException {
        // given
        String[] emailsTo = new String[]{};
        given(ownerLocationResponseMessage.toJSON()).willReturn(new JSONObject());
        
        // when
        service.sendOwnerLocationResponseMessage(ownerLocationResponseMessage, emailsTo);
        
        // then
    }
    
    @Test
    public void shouldSendOwnerLocationDataMessageSuccessfully() throws ConnectorException, ServiceException, TransformException {
        // given
        String[] emailsTo = new String[]{};
        given(ownerLocationDataMessage.toJSON()).willReturn(new JSONObject());
        
        // when
        service.sendOwnerLocationDataMessage(ownerLocationDataMessage, emailsTo);
        
        // then
    }
}
