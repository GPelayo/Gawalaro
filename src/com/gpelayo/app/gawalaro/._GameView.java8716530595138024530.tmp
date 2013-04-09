/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gpelayo.app.gawalaro;

import android.content.Context;
import android.graphics.*;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class GameView extends GLSurfaceView implements SurfaceHolder.Callback {
    public GameManager _gameManager;
    private Bitmap background;
    private boolean isStopped = true; 
    public boolean onTouchEvent(MotionEvent evt)
    {
    	_gameManager.resetObjectLocations();
    	if(isStopped)	{
    		//_gameManager.startThreads();
    		isStopped = false;
    	}
    	return true;
    }
    
    public GameView(Context context) {
		super(context);
		initGameObjects();
	}
    
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initGameObjects();
	}
	
    private void initGameObjects()
    {
    	//add and load graphics
    	_gameManager = new GameManager(this);
    }
    
    public void doDraw(Canvas canvas) {
		_gameManager.drawForeground(canvas);
		_gameManager.drawDebugDisplay(canvas);
	}
    
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		_gameManager.startThreads();
		//resize background
		//initialize screen dimension based varibles in manager
	}
	
	public void surfaceCreated(SurfaceHolder holder) {
		//initialize screen dimension based varibles in engine
    	
	}
	
	public void surfaceDestroyed(SurfaceHolder holder) {
	}
	
	
}