package com.quadcoders.android.travelzeus;

import java.util.UUID;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class PlaceFragmentActivity extends FragmentActivity {
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.fragment_info);
		UUID placeId = (UUID) getIntent().getSerializableExtra(PlaceListFragment.EXTRA_PLACE_ID);
		
		Bundle args = new Bundle();
		args.putSerializable(PlaceListFragment.EXTRA_PLACE_ID, placeId);
		BriefInfoFragment briefInfo = new BriefInfoFragment();
		briefInfo.setArguments(args);
		CommentsListFragment commentList = new CommentsListFragment();
		commentList.setArguments(args);
		
		FragmentManager manager = getSupportFragmentManager();
		FragmentTransaction transcation = manager.beginTransaction();
		
		transcation.add(R.id.dateAndTime, briefInfo, "top");
		//transcation.add(R.id.picturesThumbnails, "middle");
		transcation.add(R.id.userCommentList, commentList, "bottom");
		
		transcation.commit();
	}

}
