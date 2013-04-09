package com.gpelayo.app.gawalaro;

import android.app.Activity;
import android.view.*;

public class GlobalDisplayVariables {
	
	private final static float BASE_RESOLUTION_X = 480;
	private final static float BASE_RESOLUTION_Y = 800;
	
	public static float screenWidthRatio, screenHeightRatio; 
	public static float screenHeight, screenWidth;
	
	private static Display display;
	
	public GlobalDisplayVariables(Activity activity)
	{
		intializeSize(activity);
	}
	
	public static void intializeSize(Activity activity) 
	{
		display = activity.getWindowManager().getDefaultDisplay();
		screenWidthRatio = display.getHeight()/BASE_RESOLUTION_Y;
		screenHeightRatio = display.getWidth()/BASE_RESOLUTION_X;
		screenHeight = display.getHeight();
		screenWidth = display.getWidth();
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
