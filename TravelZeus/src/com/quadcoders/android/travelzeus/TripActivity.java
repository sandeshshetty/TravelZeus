package com.quadcoders.android.travelzeus;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

public class TripActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		return new HomeTripFragment();
	}
	
}
