package com.creek.whereareyoumodel.valueobject;

import org.json.simple.JSONObject;

import com.creek.whereareyoumodel.domain.LocationData;
import com.creek.whereareyoumodel.message.Transformable;

/**
 * 
 * @author Andrey Pereverzin
 */
@SuppressWarnings("serial")
public class OwnerLocationData extends AbstractOwnerData implements Transformable {
    private final LocationData locationData;

    private static final String LOCATION_DATA = "locationData";

    public OwnerLocationData(long timeSent, LocationData locationData) {
        super(timeSent);
        this.locationData = locationData;
    }

    public OwnerLocationData(JSONObject jsonObject) {
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
}
