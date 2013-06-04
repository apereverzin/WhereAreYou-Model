package com.creek.whereareyoumodel.service;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.mail.Message;

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

    public MessagesService(Properties mailProps) {
        this.mailConnector = new MailConnector(mailProps);
        this.messageTransformer = new GenericMessageTransformer();
    }

    public MessagesService(Properties mailProps, GenericMessageTransformer messageTransformer) {
        this.mailConnector = new MailConnector(mailProps);
        this.messageTransformer = messageTransformer;
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
            Set<Message> messages = mailConnector.receiveMessages(WHERE_ARE_YOU_SUBJECT);
            
            for(Message msg: messages) {
                GenericMessage contactLocationData = messageTransformer.transform(msg);
                locations.add(contactLocationData);
            }
            
            return locations;
        } catch(ConnectorException ex) {
            throw new ServiceException(ex);
        }
    }
    
    public void setMailConnector(MailConnector mailConnector) {
        this.mailConnector = mailConnector;
    }
}
