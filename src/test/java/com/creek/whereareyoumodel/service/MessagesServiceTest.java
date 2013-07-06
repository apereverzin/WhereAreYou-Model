package com.creek.whereareyoumodel.service;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.Mock;
import static org.mockito.Matchers.any;
import org.mockito.MockitoAnnotations;
import static org.mockito.BDDMockito.given;

import com.creek.accessemail.connector.mail.ConnectorException;
import com.creek.accessemail.connector.mail.MailConnector;
import com.creek.whereareyoumodel.message.GenericMessage;
import com.creek.whereareyoumodel.message.GenericMessageTransformer;
import com.creek.whereareyoumodel.message.OwnerLocationDataMessage;
import com.creek.whereareyoumodel.message.RequestMessage;
import com.creek.whereareyoumodel.message.ResponseMessage;
import com.creek.whereareyoumodel.message.TransformException;

/**
 * 
 * @author Andrey Pereverzin
 */
public class MessagesServiceTest {
    private MessagesService service;
    
    @Mock
    private MailConnector connector;
    
    @Mock
    private GenericMessageTransformer messageTransformer;
    
    @Mock
    private RequestMessage ownerRequestMessage;
    @Mock
    private ResponseMessage ownerResponseMessage;
    @Mock
    private OwnerLocationDataMessage ownerLocationDataMessage;
    
    private String message1 = "a";
    private String message2 = "b";
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        service = new MessagesService(new Properties(), messageTransformer);
        service.setMailConnector(connector);
    }
    
    @Test
    public void shouldReceiveMessagesSuccessfully() throws ConnectorException, ServiceException, TransformException {
        // given
        Set<Object> messages = new HashSet<Object>();
        messages.add(message1);
        messages.add(message2);
        given(connector.receiveMessages(MessagesService.WHERE_ARE_YOU_SUBJECT)).willReturn(messages);
        given(messageTransformer.transform(any(String.class))).willReturn(ownerResponseMessage).willReturn(ownerLocationDataMessage);
        
        // when
        Set<GenericMessage> messagesReceived = service.receiveMessages();
        
        // then
        assertEquals(2, messagesReceived.size());
    }
    
    @Test(expected=TransformException.class)
    public void shouldThrowTransformExceptionIfTransformExceptionThrownWhenReceivingMessages() throws ConnectorException, ServiceException, TransformException {
        // given
        Set<Object> messages = new HashSet<Object>();
        messages.add(message1);
        given(connector.receiveMessages(MessagesService.WHERE_ARE_YOU_SUBJECT)).willReturn(messages);
        given(messageTransformer.transform(any(String.class))).willThrow(new TransformException(""));
        
        // when
        service.receiveMessages();
        
        // then
        // throws exception
    }
    
    @Test(expected=ServiceException.class)
    public void shouldThrowServiceExceptionIfConnectorExceptionThrownWhenReceivingMessages() throws ConnectorException, ServiceException, TransformException {
        // given
        given(connector.receiveMessages(MessagesService.WHERE_ARE_YOU_SUBJECT)).willThrow(new ConnectorException(""));
        
        // when
        service.receiveMessages();
        
        // then
        // throws exception
    }
    
    @Test
    public void shouldSendOwnerLocationRequestMessageSuccessfully() throws ConnectorException, ServiceException, TransformException {
        // given
        String[] emailsTo = new String[]{};
        given(ownerRequestMessage.toJSON()).willReturn(new JSONObject());
        
        // when
        service.sendMessage(ownerRequestMessage, emailsTo);
        
        // then
    }
    
    @Test
    public void shouldSendOwnerLocationResponseMessageSuccessfully() throws ConnectorException, ServiceException, TransformException {
        // given
        String[] emailsTo = new String[]{};
        given(ownerResponseMessage.toJSON()).willReturn(new JSONObject());
        
        // when
        service.sendMessage(ownerResponseMessage, emailsTo);
        
        // then
    }
    
    @Test
    public void shouldSendOwnerLocationDataMessageSuccessfully() throws ConnectorException, ServiceException, TransformException {
        // given
        String[] emailsTo = new String[]{};
        given(ownerLocationDataMessage.toJSON()).willReturn(new JSONObject());
        
        // when
        service.sendMessage(ownerLocationDataMessage, emailsTo);
        
        // then
    }
}
