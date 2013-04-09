package com.gpelayo.app.gawalaro.gameObjects;

public class Coordinate {
	public float x;
	public float y;
	
	public Coordinate(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double calculateDistance(Coordinate endPoint)
	{
		return Math.sqrt(Math.pow(this.x - endPoint.x, 2) + Math.pow((this.y - endPoint.y), 2));
	}
	
	public float getFloatX()
	{
		return (float)this.x;
	}
	
	public float getFloatY()
	{
		return (float)this.y;
	}
}
