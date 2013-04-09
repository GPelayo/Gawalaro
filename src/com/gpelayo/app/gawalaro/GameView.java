/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gpelayo.app.gawalaro;


import android.content.Context;
import android.graphics.*;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class GameView extends GLSurfaceView implements SurfaceHolder.Callback {
    public GameManager gameManager;
 //   private Bitmap background;
    private GestureDetector gestureDectector;
    
    public boolean onTouchEvent(MotionEvent evt)
    {
    	this.gestureDectector.onTouchEvent(evt);
    	return true;
    }
    
    public GameView(Context context) {
		super(context);
		this.initGameObjects();
		this.initInputs();
	}
    
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.initGameObjects();
		this.initInputs();
	}
	
    private void initGameObjects()    {
    	//add and load graphics
    	this.gameManager = new GameManager(this);
    }
    
    private void initInputs()
    {
    	this.gestureDectector = new GestureDetector(new TouchInputManager());
    }
    
    public void doDraw(Canvas canvas) {
		this.gameManager.drawForeground(canvas);
		this.gameManager.drawDebugDisplay(canvas);
	}
    
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		this.gameManager.startThreads();
		//resize background
		//initialize screen dimension based varibles in manager
	}
	
	public void surfaceCreated(SurfaceHolder holder) {
		//initialize screen dimension based varibles in engine
    	
	}
	
	public void surfaceDestroyed(SurfaceHolder holder) {
	}
	
	
}