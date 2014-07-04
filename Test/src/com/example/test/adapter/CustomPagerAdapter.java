package com.example.test.adapter;

import java.util.ArrayList;

import com.example.test.R;
import com.example.test.model.Story;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

public class CustomPagerAdapter extends PagerAdapter {
	
	private View convertView;
	private ArrayList<Story> mStories;
	private LayoutInflater mInflater;
	
	public CustomPagerAdapter(Context context,ArrayList<Story> stories){
		mStories = stories;
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		return mStories.size();
	}
	
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}
	
	@Override
	public View instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.pager_item, null);
		}
		TextView textView = (TextView) convertView.findViewById(R.id.title);
		WebView webView = (WebView) convertView.findViewById(R.id.webView);
		
		textView.setText(mStories.get(position).getTitle());
		String html = "<html><head></head><body>"
				/*+ "<img src=\"" + imagePath + "\">"*/
						+ "My Text"+mStories.get(position).getBody()
						+ "</body></html>";
		webView.loadDataWithBaseURL("", html, "text/html", "utf-8", "");
		return convertView;
	}
	
	/*@Override
	public View instantiateItem(View convertView, int position) {
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.pager_item, null);
		}
		TextView textView = (TextView) convertView.findViewById(R.id.title);
		WebView webView = (WebView) convertView.findViewById(R.id.webView);
		
		textView.setText(mStories.get(position).getTitle());
		String html = "<html><head></head><body>"
				+ "<img src=\"" + imagePath + "\">"
						+ "My Text"+mStories.get(position).getBody()
						+ "</body></html>";
		webView.loadDataWithBaseURL("", html, "text/html", "utf-8", "");
		return convertView;
	}
	*/
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		//super.destroyItem(container, position, object);
		(container).removeView((View) object);
	}
	
	@Override
	public int getItemPosition(Object object) {
		return super.getItemPosition(object);
	}
	
	@Override
	public Parcelable saveState() {
		return super.saveState();
	}	
	
}
