package com.quadcoders.android.travelzeus;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class PlaceListActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		// TODO Auto-generated method stub
		PlaceListFragment fragment = new PlaceListFragment();
		Bundle args = new Bundle();
		args.putString(HomeTripFragment.EXTRA_SEARCH_NAME, getIntent().getStringExtra(HomeTripFragment.EXTRA_SEARCH_NAME));
		fragment.setArguments(args);
		return fragment;
	}

}
