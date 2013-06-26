package com.creek.whereareyoumodel.valueobject;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.domain.sendable.ContactResponse;
import com.creek.whereareyoumodel.domain.sendable.GenericRequestResponse;
import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class OwnerResponse extends OwnerRequestResponse implements Transformable {

    private final int responseCode;

    private static final String RESPONSE_CODE = "response_code";

    public OwnerResponse(ContactResponse contactResponse) {
        super(contactResponse);
        this.responseCode = contactResponse.getResponseCode().getCode();
    }

    public OwnerResponse(JSONObject jsonObject) {
        super(jsonObject);
        this.responseCode = Integer.parseInt((String) jsonObject.get(RESPONSE_CODE));
    }

    public int getResponseCode() {
        return responseCode;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject dataObject = super.toJSON();
        dataObject.put(RESPONSE_CODE, Integer.toString(getResponseCode()));
        return dataObject;
    }
}