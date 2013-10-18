package com.creek.whereareyoumodel.service;

import java.util.HashSet;
import java.util.Set;

import com.creek.accessemail.connector.mail.ConnectorException;
import com.creek.accessemail.connector.mail.MailConnector;
import com.creek.whereareyoumodel.message.AbstractMessage;
import com.creek.whereareyoumodel.message.GenericMessage;
import com.creek.whereareyoumodel.message.GenericMessageTransformer;
import com.creek.whereareyoumodel.message.TransformException;

/**
 * 
 * @author Andrey Pereverzin
 */
public class MessagesService {
    private MailConnector mailConnector;
    private final GenericMessageTransformer messageTransformer;
    
    static final String WHERE_ARE_YOU_SUBJECT = "WhereAreYou";

    public MessagesService(MailConnector _mailConnector) {
        this.mailConnector = _mailConnector;
        this.messageTransformer = new GenericMessageTransformer();
    }

    public MessagesService(MailConnector _mailConnector, GenericMessageTransformer _messageTransformer) {
        this.mailConnector = _mailConnector;
        this.messageTransformer = _messageTransformer;
    }
    
    public void sendMessage(AbstractMessage message, String... emails) throws ServiceException {
        try {
            mailConnector.sendMessage(WHERE_ARE_YOU_SUBJECT, message.getSenderEmail(), message.toJSON().toString(), emails);
        } catch(ConnectorException ex) {
            throw new ServiceException(ex);
        }
    }
    
    public Set<GenericMessage> receiveMessages() throws TransformException, ServiceException {
        try {
            Set<GenericMessage> locations = new HashSet<GenericMessage>();
            Set<Object> messages = mailConnector.receiveMessages(WHERE_ARE_YOU_SUBJECT);
            
            for (Object msg: messages) {
                if (msg instanceof String) {
                    GenericMessage contactLocationData = messageTransformer.transform((String)msg);
                    locations.add(contactLocationData);
                }
            }
            
            return locations;
        } catch(ConnectorException ex) {
            throw new ServiceException(ex);
        }
    }
}
