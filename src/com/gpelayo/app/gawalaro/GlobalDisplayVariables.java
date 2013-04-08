package com.gpelayo.app.gawalaro;

import android.app.Activity;
import android.view.*;

public class GlobalDisplayVariables {
	
	private final static float BASE_RESOLUTION_X = 480;
	private final static float BASE_RESOLUTION_Y = 800;
	
	public static float screenWidthRatio, screenHeightRatio; 
	public static float screenHeight, screenWidth;
	
	private static Display _display;
	
	public GlobalDisplayVariables(Activity activity)
	{
		intializeSize(activity);
	}
	
	public static void intializeSize(Activity activity) 
	{
		_display = activity.getWindowManager().getDefaultDisplay();
		screenWidthRatio = _display.getHeight()/BASE_RESOLUTION_Y;
		screenHeightRatio = _display.getWidth()/BASE_RESOLUTION_X;
		screenHeight = _display.getHeight();
		screenWidth = _display.getWidth();
	}
	
	public static float getMiddlePointX()
	{
		return screenWidth/2;
	}
	
	public static float getMiddlePointY()
	{
		return screenHeight/2;
	}	
}
