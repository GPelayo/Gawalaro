
package com.gpelayo.app.gawalaro;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class GawalaroActivity extends Activity {
	private SensorManager sensorManager;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        this.initDisplay();        
        this.sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }
    
    @Override
    public void onResume()
    {
    	super.onResume();
    	this.sensorManager.registerListener( (SensorEventListener) new TiltInputManager(), 
    			this.sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
    			SensorManager.SENSOR_DELAY_NORMAL);
    }
    
    public void initDisplay()
    {
    	GameView gameDisplay = new GameView(this);
    	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    	this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    	//Must be before app is in fullscreen but before the GameView since it uses these global vars.
		GlobalDisplayVariables.intializeSize(this);
    	((GLSurfaceView) gameDisplay).setRenderer(new GameRenderer());
        this.setContentView(gameDisplay);
    }
}