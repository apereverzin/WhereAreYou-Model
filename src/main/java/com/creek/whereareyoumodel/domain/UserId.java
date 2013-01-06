package com.creek.whereareyoumodel.domain;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class UserId implements Transformable {
    private String email;
    
    private static final String EMAIL = "email";

    public UserId(String email) {
        this.email = email;
    }

    public UserId(JSONObject jsonObject) {
        this.email = (String) jsonObject.get(EMAIL);
    }

    public String getEmail() {
        return email;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject dataObject = new JSONObject();
        dataObject.put(EMAIL, getEmail());
        return dataObject;
    }
}
