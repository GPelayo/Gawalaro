package com.gpelayo.app.gawalaro;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

import com.gpelayo.app.gawalaro.gameobjects.Coordinate;

public class TouchInputManager extends SimpleOnGestureListener{
	public static Coordinate touchLocation;
	public static boolean wasDoubleTapped = false;

	public TouchInputManager()
	{
		wasDoubleTapped = false;
	}
	
	@Override
	public boolean onDoubleTap(MotionEvent e) {
		wasDoubleTapped = true;
		TouchInputManager.touchLocation = new Coordinate(e.getX(), e.getY());
		return true;
	}
	
    @Override
    public boolean onDown(MotionEvent e) {
    	return true;
    } 
    
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e)
    {    	
    	return true;
    }
    
    @Override
    public boolean onSingleTapUp(MotionEvent e)
    {
    	wasDoubleTapped = false;
    	TouchInputManager.touchLocation = new Coordinate(e.getX(), e.getY());
    	return true;
    }
}
