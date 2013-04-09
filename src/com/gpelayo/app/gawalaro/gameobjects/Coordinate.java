package com.gpelayo.app.gawalaro.gameobjects;

import android.util.FloatMath;

public class Coordinate {
	public float x;
	public float y;
	
	public Coordinate(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	//@Optimization both for x and y use seperate var for the difference 
	public float calculateDistance(Coordinate endPoint)
	{
		return FloatMath.sqrt((float)(Math.pow(this.x - endPoint.x, 2) + Math.pow((this.y - endPoint.y), 2)));
	}
}
