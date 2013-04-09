package com.gpelayo.app.gawalaro.gameobjects.components;

import java.text.DecimalFormat;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.gpelayo.app.gawalaro.TiltInputManager;
import com.gpelayo.app.gawalaro.gameobjects.BaseGameObject;
import com.gpelayo.app.gawalaro.gameobjects.Coordinate;

public class TiltMoveComponent extends GameComponent	{
	static final int SENSOR_STATUS_DEBUG_TEXT_LOC_X = 10;
	static final int SENSOR_STATUS_DEBUG_TEXT_LOC_Y = 10;
	
	private int movementSpeed;
	
    public TiltMoveComponent(BaseGameObject parent)	{
    	this.parent = parent;
		this.movementSpeed = this.parent.currentStats.runSpeed;
	}
    
	@Override
	public void update(long gametime) {
		if(TiltInputManager.accelormenterValues != null)	{
			float newX = this.parent.location.x + this.movementSpeed * (-1*TiltInputManager.accelormenterValues[1]);
			float newY = this.parent.location.y + this.movementSpeed * TiltInputManager.accelormenterValues[0];
			this.parent.location = new Coordinate(newX, newY);
		}
		
	}

	@Override
	public void drawDebugInfo(Canvas g) {
		float[] orientValues = new float[3];
    	String accelStatus = "Not Ready";
    	Paint debugTextPaint = new Paint();
    	
    	debugTextPaint.setColor(Color.GREEN);
    	
    	if(TiltInputManager.geomagneticMatrix != null
    		||	TiltInputManager.accelormenterValues != null)    	{
    		orientValues = TiltInputManager.accelormenterValues;
    		StringBuilder stringBuilder = new StringBuilder();
    		stringBuilder.append("X: ");
    		stringBuilder.append(new DecimalFormat("#.##").format(orientValues[0]));
    		stringBuilder.append(" Y: ");
    		stringBuilder.append(new DecimalFormat("#.##").format(orientValues[1]));
    		stringBuilder.append(" Z: ");
    		stringBuilder.append(new DecimalFormat("#.##").format(orientValues[2]));
    		accelStatus = stringBuilder.toString();
    	}
    	
    	g.drawText(accelStatus, SENSOR_STATUS_DEBUG_TEXT_LOC_X, SENSOR_STATUS_DEBUG_TEXT_LOC_Y, debugTextPaint); 
		
	}
}

