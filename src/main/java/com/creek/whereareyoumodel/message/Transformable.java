package com.creek.whereareyoumodel.message;

import java.io.Serializable;

import org.json.simple.JSONObject;

/**
 * 
 * @author Andrey Pereverzin
 */
public interface Transformable extends Serializable {
    public JSONObject toJSON();
}
