package com.creek.whereareyoumodel.domain;

/**
 * 
 * @author Andrey Pereverzin
 */
public enum RequestAllowance {
    NEVER(0),
    ALWAYS(1);
    
    private final int code;

    private RequestAllowance(int _code) {
        this.code = _code;
    }

    public int getCode() {
        return code;
    }
    
    public static RequestAllowance getRequestAllowance(int code) {
        for (RequestAllowance requestAllowance: values()) {
            if (requestAllowance.getCode() == code) {
                return requestAllowance;
            }
        }
        
        return null;
    }
}
