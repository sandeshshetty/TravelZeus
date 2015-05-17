package com.quadcoders.android.travelzeus;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class PlacesLab {
	private ArrayList<Places> mPlaces;

    private static PlacesLab sPlacesLab;
    private Context mAppContext;
    private static final String TAG = "PlacesLab";
    private static final String FILENAME = "places.json";
    private Json mSerializer;

    private PlacesLab(Context appContext) {
        mAppContext = appContext;
        mPlaces = new ArrayList<Places>();
        mSerializer = new Json(appContext, FILENAME);
    }

    public static PlacesLab get(Context c) {
        if (sPlacesLab == null) {
            sPlacesLab = new PlacesLab(c.getApplicationContext());
        }
        return sPlacesLab;
    }

    public ArrayList<Places> getPlaceList(String input) {
    	ArrayList<Places> out = new ArrayList<Places>();
    	Log.d("tag", "created array list" + input);
        for (Places p : mPlaces) {
        	Log.d("tag", p.getFromLocation() + p.getToLocation());
        	Log.d("tag", input);
        	if(p.getFromLocation() == null || p.getToLocation() == null || input == null)
        		continue;
            if (p.getFromLocation().equalsIgnoreCase(input) || p.getToLocation().equalsIgnoreCase(input))
                out.add(p);
        }
        Toast.makeText(mAppContext, out.size() + " " + input, Toast.LENGTH_SHORT).show();
        Log.d("tag", "created array list");
        return out;
    }
    
    public boolean savePlaces() {
    	try {
    		mSerializer.savePlaces(mPlaces);
    		Log.d(TAG, "Saved to file");
    		return true;
    	} catch(Exception e) {
    		Log.d(TAG, "Error Saving file");
    		return false;
    	}
    }
    
    public ArrayList<Places> getPlaces() {
        return mPlaces;
    }
    
    public void addPlace(Trip trip) {
    	if(trip.getPlace() == null) {
    		Toast.makeText(mAppContext, "Place name empty", Toast.LENGTH_SHORT).show();
    		return;
    	}
    	for(Places p: mPlaces) {
    		if (p.getPlaceName().equalsIgnoreCase(trip.getPlace())) {
    			p.setFromLocation(trip.getFrom());
    			p.setToLocation(trip.getTo());
    			p.setMonth(trip.getMonth());
    			p.setTime(trip.getTimeOfDay());
    			p.addComment(trip.getUserName(), trip.getComment());
    			return;
    		}
    	}
    	Places p1 = new Places();
    	p1.setPlaceName(trip.getPlace());
    	p1.setFromLocation(trip.getFrom());
		p1.setToLocation(trip.getTo());
		p1.setMonth(trip.getMonth());
		p1.setTime(trip.getTimeOfDay());
		p1.addComment(trip.getUserName(), trip.getComment());
		Log.d("tag", p1.getPlaceName() + p1.getFromLocation() + p1.getToLocation() + p1.getMonth() + p1.getTime() + p1.getComments());
		mPlaces.add(p1);
    }
}