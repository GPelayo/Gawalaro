package com.gpelayo.app.gawalaro.gameObjects;

import java.util.ArrayList;

import com.gpelayo.app.gawalaro.TouchInputManager;


import android.graphics.Canvas;


public class TouchMoveComponent extends GameComponent{
	private static final int MINIMUM_MOVE_DISTANCE = 10;  //Should be smaller than the parent
	
	int movementSpeed, step, dashMultiPlier;
	double currentSpeed;
	ArrayList<Coordinate> pathPoints;
    Coordinate destination, touchLocation;
	
    public TouchMoveComponent(BaseGameObject parent)	{
    	this.currentSpeed = -1;
    	this.parent = parent;
    	this.destination = parent.location;
		this.step = 0;
		this.movementSpeed = parent.currentStats.runSpeed;
		this.pathPoints = new ArrayList<Coordinate>();
		this.dashMultiPlier = 1;
	}
	
	@Override
	public void update() {
		Coordinate location = this.parent.location;
		
		this.currentSpeed = -1.0;
		if(TouchInputManager.touchLocation != null)	{
			if((Math.abs(location.calculateDistance(TouchInputManager.touchLocation)) > MINIMUM_MOVE_DISTANCE)
					&& !this.destination.equals(TouchInputManager.touchLocation))	{
				this.destination = TouchInputManager.touchLocation;
						
				if(this.step == 0)
				{
					System.out.println("step is zero");
				}
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
			}
			
			try			{
				this.currentSpeed = this.parent.location.calculateDistance(this.pathPoints.get(this.step));
				this.parent.location = this.pathPoints.get(this.step);
				this.step++;			}
			catch(IndexOutOfBoundsException e)
			{
				System.err.println(e.getMessage());
			}
		}
	}
	
	public void setDestination(Coordinate destination)	{
		this.destination = destination;
	}
	
	public Coordinate getDestination()	{
		return this.destination;
	}
	
	
	public void displayDebugMessage(String g)	{
		
	}

	@Override
	public void drawEffect(Canvas g) {
		// TODO Auto-generated method stub
		
	}
}
