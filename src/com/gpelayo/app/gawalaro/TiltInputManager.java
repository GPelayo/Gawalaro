package com.gpelayo.app.gawalaro;

import android.hardware.*;

public class TiltInputManager implements SensorEventListener{
	static public float[] accelormenterValues, geomagneticMatrix;
	static public boolean isReady = false;
	
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	public void onSensorChanged(SensorEvent event) {
		switch(event.sensor.getType())
		{
			case Sensor.TYPE_ACCELEROMETER:
				accelormenterValues = event.values.clone();
			case Sensor.TYPE_MAGNETIC_FIELD:
				geomagneticMatrix = event.values.clone();
				isReady = true;
		}
		
	}
		
}
