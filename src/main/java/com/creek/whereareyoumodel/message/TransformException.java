package com.creek.whereareyoumodel.message;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class TransformException extends Exception {
    public TransformException(String msg) {
        super(msg);
    }
    
    public TransformException(Throwable ex) {
        super(ex);
    }
}
