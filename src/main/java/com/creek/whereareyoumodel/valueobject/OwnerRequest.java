package com.creek.whereareyoumodel.valueobject;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.domain.sendable.ContactRequest;
import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class OwnerRequest extends OwnerRequestResponse implements Transformable {

    private final int requestCode;

    private static final String REQUEST_CODE = "request_code";

    public OwnerRequest(ContactRequest contactRequest) {
        super(contactRequest);
        this.requestCode = contactRequest.getRequestCode().getCode();
    }

    public OwnerRequest(JSONObject jsonObject) {
        super(jsonObject);
        this.requestCode = Integer.parseInt((String) jsonObject.get(REQUEST_CODE));
    }

    public int getRequestCode() {
        return requestCode;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject dataObject = super.toJSON();
        dataObject.put(REQUEST_CODE, Integer.toString(getRequestCode()));
        return dataObject;
    }
}