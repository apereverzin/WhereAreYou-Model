package com.creek.whereareyoumodel.domain.sendable;

/**
 * 
 * @author Andrey Pereverzin
 */
public enum ResponseCode {
    SUCCESS(0),
    FAILURE(-1);

    private int code;

    private ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    
    public static ResponseCode getResponseCode(int code) {
        for (ResponseCode responseCode: values()) {
            if (responseCode.getCode() == code) {
                return responseCode;
            }
        }
        
        return null;
    }
}
