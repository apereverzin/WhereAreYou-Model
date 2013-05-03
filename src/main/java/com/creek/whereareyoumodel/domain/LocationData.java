package com.creek.whereareyoumodel.domain;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class LocationData implements Transformable {
    private final long locationTime;
    private final float accuracy;
    private final double latitude;
    private final double longitude;
    private final float speed;
    private final boolean hasAccuracy;
    private final boolean hasSpeed;

    private static final String LOCATION_TIME = "locationTime";
    private static final String ACCURACY = "accuracy";
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String SPEED = "speed";
    private static final String HAS_ACCURACY = "hasAccuracy";
    private static final String HAS_SPEED = "hasSpeed";

    public LocationData(float accuracy, double latitude, double longitude, float speed, boolean hasAccuracy, boolean hasSpeed) {
        this.locationTime = System.currentTimeMillis();
        this.accuracy = accuracy;
        this.latitude = latitude;
        this.longitude = longitude;
        this.speed = speed;
        this.hasAccuracy = hasAccuracy;
        this.hasSpeed = hasSpeed;
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

    public float getAccuracy() {
        return accuracy;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public float getSpeed() {
        return speed;
    }

    public boolean hasAccuracy() {
        return hasAccuracy;
    }

    public boolean hasSpeed() {
        return hasSpeed;
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
