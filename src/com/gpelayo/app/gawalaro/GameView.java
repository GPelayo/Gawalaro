/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gpelayo.app.gawalaro;

import android.content.Context;
import android.graphics.Canvas;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.gpelayo.app.gawalaro.R;
import com.gpelayo.app.gawalaro.R.drawable;

public class GameView extends GLSurfaceView implements SurfaceHolder.Callback{
    public GameManager gameManager;
 //   private Bitmap background;
    private GestureDetector gestureDectector; 
    
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
    	//Graphics must be loaded before the GameManager is initialized
    	GraphicsManager.addBitmap(R.drawable.megaman_walking);
    	GraphicsManager.addBitmap(R.drawable.megaman_idle);
    	GraphicsManager.load(this.getResources());
    	this.gameManager = new GameManager(this);
    }
    
    private void initInputs()
    {
    	this.gestureDectector = new GestureDetector((OnGestureListener) new TouchInputManager());
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
	
	public boolean onTouchEvent(MotionEvent evt)    {
    	this.gestureDectector.onTouchEvent(evt);
    	return true;
    }
}