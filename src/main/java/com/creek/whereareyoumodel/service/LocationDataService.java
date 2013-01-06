package com.creek.whereareyoumodel.service;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import javax.mail.Message;

import com.creek.accessemail.connector.mail.ConnectorException;
import com.creek.accessemail.connector.mail.MailConnector;
import com.creek.whereareyoumodel.domain.UserLocationData;
import com.creek.whereareyoumodel.message.TransformException;
import com.creek.whereareyoumodel.util.MessageTransformer;

/**
 * 
 * @author Andrey Pereverzin
 */
public class LocationDataService {
    private MailConnector mailConnector;
    private MessageTransformer messageTransformer;
    
    static final String I_AM_HERE_SUBJECT = "IAmHere";
    
    public LocationDataService(Properties mailProps, MessageTransformer messageTransformer) {
        this.mailConnector = new MailConnector(mailProps);
        this.messageTransformer = messageTransformer;
    }
    
    public void sendUserLocationData(UserLocationData userLocationData, String[] emails) throws ServiceException {
        try {
            mailConnector.sendMessage(I_AM_HERE_SUBJECT, userLocationData.getUserId().getEmail(), userLocationData.toJSON().toString(), emails);
        } catch(ConnectorException ex) {
            throw new ServiceException(ex);
        }
    }
    
    public Set<UserLocationData> receiveUserLocationData() throws TransformException, ServiceException {
        try {
            Set<UserLocationData> locations = new HashSet<UserLocationData>();
            Set<Message> messages = mailConnector.receiveMessages(I_AM_HERE_SUBJECT);
            
            for(Message msg: messages) {
                UserLocationData userLocationData = messageTransformer.getUserLocationData(msg);
                locations.add(userLocationData);
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
