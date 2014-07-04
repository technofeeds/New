package com.example.test.application;

import android.app.Application;
import android.app.TabActivity;
import android.content.Context;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;

public class MyApplication extends Application{
	
	private static Context mContext;
	private static ConnectivityManager mConnectivityManager;
    private static String mPrivateFilePath;
    
	@Override
	public void onCreate() {
		super.onCreate();
		mContext = getApplicationContext();
		initSingletons();
	}
	
	private void initSingletons(){
		mConnectivityManager =
                (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
	}
	
	public static Context getContext() {
        return mContext;
    }
    
    public static boolean isNetworkConnected(){
    	NetworkInfo activeNetwork = mConnectivityManager.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                              activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
    
    public static String getPrivateFilePath(){
    	if(TextUtils.isEmpty(mPrivateFilePath))
    		mPrivateFilePath = mContext.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
    	return mPrivateFilePath;
    }
    
}
