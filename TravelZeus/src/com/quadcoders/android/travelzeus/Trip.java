package com.quadcoders.android.travelzeus;

import java.util.ArrayList;
import java.util.UUID;

import android.util.Log;

public class Trip {

	private UUID mId;
	private String mUserName;
	private String mPlace;
	private String mFrom;
	private String mTo;
	private String mMonth;
	private String mTimeOfDay;
	private String mComment;
	public static ArrayList<String> items;
	
	static {
		items = new ArrayList<String>();
		items.add("Morning");
		items.add("Afternoon");
		items.add("Evening");
		items.add("Night");
		Log.d("14", "trip.java finished");
	}
	
	public Trip() {
		mId = UUID.randomUUID();
	}

	public String getPlace() {
		return mPlace;
	}

	public void setPlace(String place) {
		mPlace = place;
	}

	public String getFrom() {
		return mFrom;
	}

	public void setFrom(String from) {
		mFrom = from;
	}
	
	public String getUserName() {
		return mUserName;
	}

	public void setUserName(String userName) {
		mUserName = userName;
	}

	public String getTo() {
		return mTo;
	}

	public void setTo(String to) {
		mTo = to;
	}

	public String getMonth() {
		return mMonth;
	}

	public void setMonth(String month) {
		mMonth = month;
	}

	public String getTimeOfDay() {
		return mTimeOfDay;
	}

	public void setTimeOfDay(String timeOfDay) {
		mTimeOfDay = timeOfDay;
	}

	public String getComment() {
		return mComment;
	}

	public void setComment(String comment) {
		mComment = comment;
	}

	public UUID getId() {
		return mId;
	}
	
}
