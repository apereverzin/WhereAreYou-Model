package com.creek.whereareyoumodel.service;

/**
 * 
 * @author Andrey Pereverzin
 */
public class ServiceException extends Exception {
    private static final long serialVersionUID = 34783772L;
    
    public ServiceException(Throwable ex) {
        super(ex);
    }
}
