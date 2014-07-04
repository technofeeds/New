package com.example.test.util;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created with IntelliJ IDEA.
 * User: ruby
 * Date: 11/6/13
 * Time: 2:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class GetFont {
	
    public static final int FONT_KG_HAPPY = 1;
    public static final int FONT_SHOES_CENTER = 2;

    private static GetFont ourInstance;

    private static  Context mContext;
    private static Typeface mTypeface1;
    private static Typeface mTypeface2;
    
    public static GetFont getInstance(Context context) {
        mContext = context;
        if(ourInstance == null)
            ourInstance = new GetFont();
        
        if(mTypeface1 == null)
            mTypeface1 = Typeface.createFromAsset(mContext.getAssets(),"font/KGHAPPY.ttf");
        if(mTypeface2 == null)
            mTypeface2 = Typeface.createFromAsset(mContext.getAssets(),"font/Shoes_center.ttf");
        return ourInstance;
    }

    public Typeface getFont(int type)
    {
        switch (type)
        {
            case FONT_KG_HAPPY:
                return mTypeface1;
            case FONT_SHOES_CENTER:
                return mTypeface2;
            default:
                return mTypeface1;
        }
    }


}
