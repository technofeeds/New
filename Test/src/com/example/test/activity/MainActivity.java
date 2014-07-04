package com.example.test.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;

import com.example.test.R;
import com.example.test.adapter.CustomPagerAdapter;
import com.example.test.model.Story;

public class MainActivity extends Activity implements
		LoaderCallbacks<ArrayList<Story>> {

	private static final String TAG = MainActivity.class.getSimpleName();

	private ViewPager mViewPager;
	private CustomPagerAdapter mAdapter;
	private ArrayList<Story> mStories;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mViewPager = (ViewPager) findViewById(R.id.viewPager);

		mStories = new ArrayList<Story>();
		mStories.add(new Story("Test1", "Test1 - content",
				"Test 1 - coverImagePath"));
		mStories.add(new Story("Test2", "Test2 - content",
				"Test 2 - coverImagePath"));
		mStories.add(new Story("Test3", "Test3 - content",
				"Test 3 - coverImagePath"));
		mAdapter = new CustomPagerAdapter(this, mStories);
		mViewPager.setAdapter(mAdapter);
		mAdapter.notifyDataSetChanged();

	}

	@Override
	public Loader<ArrayList<Story>> onCreateLoader(int id, Bundle args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onLoadFinished(Loader<ArrayList<Story>> arg0,
			ArrayList<Story> arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLoaderReset(Loader<ArrayList<Story>> arg0) {
		// TODO Auto-generated method stub

	}

}
