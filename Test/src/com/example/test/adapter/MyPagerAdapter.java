package com.example.test.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.test.fragment.StoryFragment;
import com.example.test.model.Story;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
	
	private List<Fragment> mFragments;
	private ArrayList<Story> mStories;
	
	public MyPagerAdapter(FragmentManager fm, ArrayList<Story> stories) {
		super(fm);
		mStories = stories;
		mFragments = new ArrayList<Fragment>();
		for (Story story : stories) {
			mFragments.add(new StoryFragment(story));
		}
	}
	
	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		return mFragments.get(position);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mFragments.size();
	}
	
}
