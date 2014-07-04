package com.example.test.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.example.test.R;
import com.example.test.adapter.MyPagerAdapter;
import com.example.test.model.Story;

public class MainFragmentActivity extends FragmentActivity {

	private static final String TAG = MainFragmentActivity.class
			.getSimpleName();
	private ArrayList<Story> mStories;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mStories = new ArrayList<Story>();
		mStories.add(new Story("Nonsense 1", getResources().getString(
				R.string.lorem_ipsum_more), ""));
		mStories.add(new Story("Nonsense 2", getResources().getString(
				R.string.lorem_ipsum_more), ""));
		mStories.add(new Story("Nonsense 3", getResources().getString(
				R.string.lorem_ipsum_more), ""));

		MyPagerAdapter adapter = new MyPagerAdapter(
				getSupportFragmentManager(), mStories);
		ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
		viewPager.setOffscreenPageLimit(0);
		viewPager.setAdapter(adapter);

		testMethod();
	}

	public static String VIEW_NAME = "tours_view";
	public static String TABLE_NAME = "tours";
	public static String ROUTE_ID = "route_id";
	public static String DESCRIPTION = "description";
	public static String NAME = "name";
	public static String IMAGE = "image";
	public static String DURATION = "duration";
	public static String COMMENTARY = "commentary";
	public static String DISTANCE = "distance";
	public static String HIGHLIGHTS = "highlights";

	public static String START = "start";
	public static String FINISH = "finish";
	public static String PATH = "path";

	public static String Routes_TABLE_NAME = "routes";
	public static String Routes_VIEW_NAME = "routes_view";

	private void testMethod() {
		String _ID = "_id";
		String[] STMT_CREATE = {
				"CREATE TABLE [" + TABLE_NAME + "] (" + "[" + BaseColumns._ID
						+ "] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
						+ "[" + NAME + "] VARCAHR(100) NOT NULL, " + "["
						+ ROUTE_ID + "] VARCAHR(200) NULL, " + "[" + IMAGE
						+ "] VARCAHR(200) NOT NULL, " + "[" + DURATION
						+ "] VARCAHR(50) NOT NULL, " + "[" + COMMENTARY
						+ "] VARCAHR(50) NOT NULL, " + "[" + DISTANCE
						+ "] VARCAHR(50) NOT NULL, " + "[" + HIGHLIGHTS
						+ "] TEXT NOT NULL, " + "[" + DESCRIPTION
						+ "] TEXT NOT NULL, " + "FOREIGN KEY([" + ROUTE_ID
						+ "]) REFERENCES [" + Routes_TABLE_NAME + "](["
						+ BaseColumns._ID + "])" + ")",
				"CREATE INDEX IF NOT EXISTS fk_route_tours_route_id ON ["
						+ TABLE_NAME + "]([" + ROUTE_ID + "])",
				"CREATE VIEW [" + VIEW_NAME + "] AS " + "SELECT T.*, R.["
						+ START + "], R.[" + FINISH + "]" + " FROM ["
						+ TABLE_NAME + "] T JOIN [" + Routes_VIEW_NAME
						+ "] R ON T.[" + ROUTE_ID + "]=R.[" + _ID + "]"
						+ "ORDER BY R.[" + _ID + "]" };

		// STMT_CREATE
		for (int i = 0; i < STMT_CREATE.length; i++) {
			try {
				Log.i(TAG, "STMT_CREATE : " + STMT_CREATE[i]);
				Log.e(TAG, "STMT_CREATE : " + STMT_CREATE[i]);
			} catch (Exception e) {
				e.printStackTrace();
				Log.i(TAG, "Error in printing STMT_CREATE");
				Log.e(TAG, "Error in printing STMT_CREATE");
			}
		}
	}
}
