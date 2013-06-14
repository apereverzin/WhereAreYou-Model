package com.creek.whereareyoumodel.domain;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class LocationData extends AbstractIdentifiable implements Transformable, Identifiable {
    private long locationTime;
    private float accuracy;
    private double latitude;
    private double longitude;
    private float speed;
    private boolean hasAccuracy;
    private boolean hasSpeed;

    private static final String LOCATION_TIME = "locationTime";
    private static final String ACCURACY = "accuracy";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String SPEED = "speed";
    private static final String HAS_ACCURACY = "hasAccuracy";
    private static final String HAS_SPEED = "hasSpeed";

    public LocationData() {
        super();
    }

    public LocationData(JSONObject jsonObject) {
        this.locationTime = Long.parseLong((String) jsonObject.get(LOCATION_TIME));
        this.accuracy = Float.parseFloat((String) jsonObject.get(ACCURACY));
        this.latitude = Double.parseDouble((String) jsonObject.get(LATITUDE));
        this.longitude = Double.parseDouble((String) jsonObject.get(LONGITUDE));
        this.speed = Float.parseFloat((String) jsonObject.get(SPEED));
        this.hasAccuracy = Boolean.parseBoolean((String) jsonObject.get(HAS_ACCURACY));
        this.hasSpeed = Boolean.parseBoolean((String) jsonObject.get(HAS_SPEED));
    }

    public long getLocationTime() {
        return locationTime;
    }

    public void setLocationTime(long locationTime) {
        this.locationTime = locationTime;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public boolean hasAccuracy() {
        return hasAccuracy;
    }

    public void setHasAccuracy(boolean hasAccuracy) {
        this.hasAccuracy = hasAccuracy;
    }

    public boolean hasSpeed() {
        return hasSpeed;
    }

    public void setHasSpeed(boolean hasSpeed) {
        this.hasSpeed = hasSpeed;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject dataObject = new JSONObject();
        dataObject.put(LOCATION_TIME, Long.toString(getLocationTime()));
        dataObject.put(ACCURACY, Float.toString(getAccuracy()));
        dataObject.put(LATITUDE, Double.toString(getLatitude()));
        dataObject.put(LONGITUDE, Double.toString(getLongitude()));
        dataObject.put(SPEED, Float.toString(getSpeed()));
        dataObject.put(HAS_ACCURACY, Boolean.toString(hasAccuracy()));
        dataObject.put(HAS_SPEED, Boolean.toString(hasSpeed()));
        return dataObject;
    }
}
