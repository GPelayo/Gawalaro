
package com.gpelayo.app.gawalaro;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;

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
    	this.sensorManager.registerListener( new TiltInputManager(), 
    			this.sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
    			SensorManager.SENSOR_DELAY_NORMAL);
    }
    
    public void initDisplay()
    {      
    	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    	this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    	//Must be before app is in fullscreen but before the GameView since it uses these global vars.
		GlobalDisplayVariables.intializeSize(this);
    	GameView gameDisplay = new GameView(this);
    	gameDisplay.setRenderer(new GameRenderer());
        this.setContentView(gameDisplay);
    }
}