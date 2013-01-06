package com.creek.whereareyoumodel.util;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.creek.whereareyoumodel.domain.UserLocationData;
import com.creek.whereareyoumodel.message.TransformException;

/**
 * 
 * @author Andrey Pereverzin
 */
public class MessageTransformer {
    private JSONParser parser = new JSONParser();
    private JSONTransformer transformer = new JSONTransformer();
    
    public UserLocationData getUserLocationData(Message msg) throws TransformException {
        try {
            String content = (String) msg.getContent();
            parser.parse(content, transformer);

            JSONObject jsonObject = (JSONObject) transformer.getResult();

            return new UserLocationData(jsonObject);
        } catch (MessagingException ex) {
            throw new TransformException(ex);
        } catch (IOException ex) {
            throw new TransformException(ex);
        } catch (ParseException ex) {
            throw new TransformException(ex);
        }
    }

    public void setParser(JSONParser parser) {
        this.parser = parser;
    }

    public void setTransformer(JSONTransformer transformer) {
        this.transformer = transformer;
    }
}
