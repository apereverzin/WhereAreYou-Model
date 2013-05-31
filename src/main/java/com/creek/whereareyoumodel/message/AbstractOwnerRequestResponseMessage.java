package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.valueobject.OwnerRequestResponse;

/**
 * 
 * @author andreypereverzin
 */
@SuppressWarnings("serial")
public abstract class AbstractOwnerRequestResponseMessage<T extends OwnerRequestResponse> extends AbstractMessage {
    private final T t;
    
    private static final String PAYLOAD = "payload";

    public AbstractOwnerRequestResponseMessage(T t, String senderEmail) {
        super(senderEmail);
        this.t  = t;
    }

    public AbstractOwnerRequestResponseMessage(JSONObject jsonObject) {
        super(jsonObject);
        t = createPayload((JSONObject) jsonObject.get(PAYLOAD));
    }
    
    protected final T getPayload() {
        return t;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject jsonObject = super.toJSON();
        jsonObject.put(PAYLOAD, t.toJSON());
        return jsonObject;
    }
    
    protected abstract T createPayload(JSONObject jsonObject);
}
