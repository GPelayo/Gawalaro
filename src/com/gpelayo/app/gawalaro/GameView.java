/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gpelayo.app.gawalaro;

import com.gpelayo.app.gawalaro.gameObjects.TouchInputManager;

import android.content.Context;
import android.graphics.*;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class GameView extends GLSurfaceView implements SurfaceHolder.Callback {
    public GameManager _engine;
    //private Bitmap background;
    private GestureDetector _gestureDectector;
    
    public boolean onTouchEvent(MotionEvent evt)
    {
    	_gestureDectector.onTouchEvent(evt);
    	return true;
    }
    
    public GameView(Context context) {
		super(context);
		initGameObjects();
		initInputs();
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initGameObjects();
	}
	
    private void initGameObjects()
    {
    	//add and load graphics
    	_engine = new GameManager(this);
    }
    
    private void initInputs()
    {
    	_gestureDectector = new GestureDetector(new TouchInputManager());
    }
    
    public void doDraw(Canvas canvas) {
		_engine.drawForeground(canvas);
	}
    
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		//resize background
		
		//initialize screen dimension based varibles in manager
	}
	
	public void surfaceCreated(SurfaceHolder holder) {
		//initialize screen dimension based varibles in engine
	}
	
	public void surfaceDestroyed(SurfaceHolder holder) {
	}
	
	
}