package com.gpelayo.app.gawalaro.gameobjects.components;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.gpelayo.app.gawalaro.TouchInputManager;
import com.gpelayo.app.gawalaro.gameobjects.*;


public class TouchMoveComponent extends GameDisplayableComponent{
	private static final int MINIMUM_MOVE_DISTANCE = 10;  //Should be smaller than the parent

	protected int currentSpeed, movementSpeed;
	protected Coordinate destination;
	
	private int step;
	private ArrayList<Coordinate> pathPoints;	
	
    public TouchMoveComponent(ForegroundGameObject parent)	{
    	super.parent = parent;
    	this.destination = parent.location;
		this.step = 0;
		this.movementSpeed = parent.currentStats.runSpeed;
		this.pathPoints = new ArrayList<Coordinate>();
	}
	
	@Override
	public void update(long gametime) {
		Coordinate location = this.parent.location;
		
		if(TouchInputManager.touchLocation != null)		{
			if((Math.abs(location.calculateDistance(TouchInputManager.touchLocation)) > MINIMUM_MOVE_DISTANCE)
					&& !this.destination.equals(TouchInputManager.touchLocation))	{
				this.destination = TouchInputManager.touchLocation;
				this.pathPoints.clear();
				
				//Calculates Path from Current Location to Destination
				//===================================================================================
		    	final double time = (Math.sqrt((Math.pow(this.destination.x - location.x, 2) 
		    								  + Math.pow(this.destination.y - location.y, 2)))
		    								  /this.movementSpeed);
		        final double yStepSize = (this.destination.y - location.y)
		        						/(time*(this.movementSpeed));
		        final double xStepSize = (this.destination.x - location.x)/(time*(this.movementSpeed));
		        		        
		        for(int _calcStep = 0; _calcStep < time; _calcStep++)
		        {
		            this.pathPoints.add(new Coordinate(location.x + Math.round(_calcStep*movementSpeed*xStepSize)
		            								 , location.y + Math.round(_calcStep*movementSpeed*yStepSize)));
		        }
		        //===================================================================================
		        this.step = 0;
		        
		        //TODO probably temp
		        if(xStepSize < 0) parent.currentDirectionFacing = CardinalDirection.West;
		        else parent.currentDirectionFacing = CardinalDirection.East;
			}
			
			//TODO create another animation state change for Begin Walking using the "steps" variable.
			
			if(step < pathPoints.size())	{
				this.currentSpeed = this.movementSpeed;
				this.parent.location = this.pathPoints.get(this.step);
				this.step++;
				parent.currentImageState = ImageState.Moving;
			}
			else	{
				this.currentSpeed = 0;
				parent.currentImageState = ImageState.Idle;
			}
		}
	}
	
	public void setDestination(Coordinate destination)	{
		this.destination = destination;
	}
	
	public Coordinate getDestination()	{
		return this.destination;
	}

	@Override
	public void drawDebugInfo(Canvas g) {
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		g.drawText("Current Speed: " + currentSpeed, 10, 25, paint);
	}
}
