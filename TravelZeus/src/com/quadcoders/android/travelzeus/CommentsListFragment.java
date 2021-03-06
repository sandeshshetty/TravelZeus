package com.quadcoders.android.travelzeus;

import java.util.ArrayList;
import java.util.UUID;

import com.quadcoders.android.travelzeus.Places.Comment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CommentsListFragment extends ListFragment {
	private ArrayList<Comment> mComments;		// To be changed
	UUID placeId;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//mTrips = new ArrayList<>();		// To be done
		placeId = (UUID)getArguments().getSerializable(PlaceListFragment.EXTRA_PLACE_ID);
		ArrayList<Places> places = PlacesLab.get(getActivity()).getPlaces();
		for(Places p: places) {
			if(p.getId().equals(placeId)) {
				mComments = p.getComments();
				break;
			}
		}
		CommentAdapter adapter = new CommentAdapter(mComments);
		setListAdapter(adapter);
		setRetainInstance(true);
	}
	
	// To be changed to comment
	private class CommentAdapter extends ArrayAdapter<Comment> {
		public CommentAdapter(ArrayList<Comment> trips) {
			super(getActivity(), android.R.layout.simple_list_item_1, mComments);
			Log.d("tag", mComments.size() + " size");
			Toast.makeText(getActivity(), mComments.size() + " size", Toast.LENGTH_SHORT).show();
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if(convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_comment,  null);
			}
			Comment comment = getItem(position);
			TextView mCommentName = (TextView) convertView.findViewById(R.id.commentName);
			TextView mCommentText = (TextView) convertView.findViewById(R.id.commentText);
			mCommentName.setText(comment.getPersonName());
			mCommentText.setText(comment.getComment());
			return convertView;
		}
	}
}
