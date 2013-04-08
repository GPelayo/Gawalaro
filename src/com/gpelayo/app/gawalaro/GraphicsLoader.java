package com.gpelayo.app.gawalaro;

import java.util.ArrayList;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class GraphicsLoader {
	public static ArrayList<Integer> _resourceIDs = new ArrayList<Integer>();
	public static ArrayList<Bitmap> _graphics = new ArrayList<Bitmap>();
	
	public static void load(Resources res)
	{
		_graphics.clear();
		
		for(int iter_resourceId : _resourceIDs)
		{
			_graphics.add(BitmapFactory.decodeResource(res, iter_resourceId));
		}
	}
	
	public static void addBitmap(int resourceID)
	{
		_resourceIDs.add(resourceID);
	}
	
	public static Bitmap getBitmap(int resourceID)
	{
		return _graphics.get(_resourceIDs.lastIndexOf(resourceID));
	}
}