package com.creek.whereareyoumodel.message;

import org.json.simple.JSONObject;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public abstract class AbstractMessage implements GenericMessage {
    private String productVersion;
    static final String MESSAGE_TYPE = "messageType";
    static final String PRODUCT_VERSION = "productVersion";

    public AbstractMessage(String productVersion) {
        this.productVersion = productVersion;
    }

    public AbstractMessage(JSONObject jsonObject) {
        this.productVersion = (String)jsonObject.get(PRODUCT_VERSION);
    }

    public abstract int getMessageType();

    @Override
    public String getProductVersion() {
        return productVersion;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(MESSAGE_TYPE, Integer.toString(getMessageType()));
        jsonObject.put(PRODUCT_VERSION, productVersion);
        return jsonObject;
    }
}
