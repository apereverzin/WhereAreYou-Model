package com.creek.whereareyoumodel.valueobject;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.domain.LocationData;
import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class SendableLocationData extends AbstractSendableData implements Transformable {
    private final LocationData locationData;

    private static final String LOCATION_DATA = "locationData";

    public SendableLocationData(LocationData locationData) {
        super(System.currentTimeMillis());
        this.locationData = locationData;
    }

    public SendableLocationData(JSONObject jsonObject) {
        super(jsonObject);
        this.locationData = new LocationData((JSONObject)jsonObject.get(LOCATION_DATA));
    }

    public LocationData getLocationData() {
        return locationData;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSON() {
        JSONObject dataObject = super.toJSON();
        dataObject.put(LOCATION_DATA, locationData.toJSON());
        return dataObject;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SendableLocationData [").append(super.toString()).append(", locationData=").append(locationData).append("]");
        return builder.toString();
    }
}
