package com.gpelayo.app.gawalaro;

import java.util.ArrayList;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class GraphicsManager {
	public static ArrayList<Integer> resourceIDs = new ArrayList<Integer>();	
	public static ArrayList<Bitmap> graphics = new ArrayList<Bitmap>();
	
	public static void load(Resources res)
	{
		graphics.clear();
		
		for(int _resourceId : resourceIDs)
		{
			graphics.add(BitmapFactory.decodeResource(res, _resourceId));
		}
	}
	
	public static void addBitmap(int resourceID)
	{
		resourceIDs.add(resourceID);
	}
	
	public static Bitmap getBitmap(int resourceID)
	{
		return graphics.get(resourceIDs.lastIndexOf(resourceID));
	}
}