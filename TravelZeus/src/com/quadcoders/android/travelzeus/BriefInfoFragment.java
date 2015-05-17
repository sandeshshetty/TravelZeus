package com.quadcoders.android.travelzeus;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BriefInfoFragment extends Fragment {

	TextView mFromName;
	TextView mToName;
	TextView mMonth;
	TextView mTime;
	// Has to be replaced in this class
	Places mPlace;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		UUID placeId = (UUID) getArguments().getSerializable(
				PlaceListFragment.EXTRA_PLACE_ID);
		setHasOptionsMenu(true);
		ArrayList<Places> places = PlacesLab.get(getActivity()).getPlaces();
		for (Places p : places) {
			if (p.getId().equals(placeId)) {
				mPlace = p;
				break;
			}
		}
		getActivity().setTitle(mPlace.getPlaceName());
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_brief_info, container,
				false);

		mFromName = (TextView) v.findViewById(R.id.briefFrom);
		mToName = (TextView) v.findViewById(R.id.briefTo);
		mMonth = (TextView) v.findViewById(R.id.briefMonth);
		mTime = (TextView) v.findViewById(R.id.briefTime);

		mFromName.setText(mPlace.getFromLocation());
		mToName.setText(mPlace.getToLocation());
		mMonth.setText(mPlace.getMonth());
		mTime.setText(mPlace.getTime());

		return v;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		setRetainInstance(true);
		inflater.inflate(R.menu.fragment_brief_info, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == R.id.briefInfoLocation) {
			try {
				String address = mPlace.getPlaceName(); // Replace with place name address
												// =
				address.replace(' ' , '+');
				Intent geoIntent = new Intent(
						android.content.Intent.ACTION_VIEW,
						Uri.parse("geo:0,0?q=" + address));
				startActivity(geoIntent);
			} catch (Exception e) {
				Log.e("Insert Info error", e.toString());
			}
		}
		return super.onOptionsItemSelected(item);
	}

}
