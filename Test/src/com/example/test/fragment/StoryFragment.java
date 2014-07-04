package com.example.test.fragment;

import com.example.test.R;
import com.example.test.application.MyApplication;
import com.example.test.model.Story;
import com.example.test.util.GetFont;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class StoryFragment extends Fragment {
	
	private static final String TAG = StoryFragment.class.getSimpleName();
	private WebView mWebView;
	private Story mStory;
	private TextView mTitleView;
	
	public StoryFragment(Story story) {
		mStory = story;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view 	= inflater.inflate(R.layout.pager_item, container, false);
		mWebView 	= (WebView) view.findViewById(R.id.webView);
		mTitleView 	= (TextView) view.findViewById(R.id.title);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		initView();
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void initView(){
		Log.i(TAG, "mStory.getTitle() : "+mStory.getTitle());
		mTitleView.setText(mStory.getTitle());
		mTitleView.setTypeface(GetFont.getInstance(MyApplication.getContext()).getFont(GetFont.FONT_KG_HAPPY));
		String preText = "<html><head><style type=\"text/css\">@font-face {font-family: MyFont;src: url(\"file:///android_asset/font/KGHAPPY.ttf\")}body {font-family: MyFont;font-size: medium;text-align: justify;}</style></head><body>";
		String postText = "</body></html>";
		String myHtmlString = preText + mStory.getBody() + postText;
		mWebView.loadDataWithBaseURL(null, 
				myHtmlString, 
				"text/html", null, null);
		/*mWebView.loadDataWithBaseURL(null, 
				"<html><body>"+mStory.getBody()+"</body></html>", 
				"text/html", null, null);*/
		WebSettings settings = mWebView.getSettings();
		//settings.setSupportZoom(true);
		settings.setBuiltInZoomControls(true);
		
	}
	
}
