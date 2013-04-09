package com.gpelayo.app.gawalaro;

import android.hardware.*;

public class TiltInputManager implements SensorEventListener{
	public static float[] accelormenterValues, geomagneticMatrix;
	public static boolean isReady = false;
	
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

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
		// TODO Auto-generated method stub
	}
		
}
