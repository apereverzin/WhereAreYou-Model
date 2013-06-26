package com.creek.whereareyoumodel.domain.sendable;

/**
 * 
 * @author Andrey Pereverzin
 */
public enum RequestCode {
    LOCATION(1);

    private int code;

    private RequestCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    
    public static RequestCode getRequestCode(int code) {
        for (RequestCode requestCode: values()) {
            if (requestCode.getCode() == code) {
                return requestCode;
            }
        }
        
        return null;
    }
}
