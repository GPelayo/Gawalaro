package com.gpelayo.app.gawalaro.gameObjects;

import java.util.ArrayList;

import android.graphics.Canvas;


public class MoveComponent extends GameComponent{
	private static final int MINIMUM_MOVE_DISTANCE = 10;  //Should be smaller than the parent
	
	int _movementSpeed, _step, dashMultiPlier;
	double _currentSpeed;
	ArrayList<Coordinate> _pathPoints;
    Coordinate _destination, touchLocation;
	
    public MoveComponent(BaseGameObject parent)
	{
    	_currentSpeed = -1;
    	_parent = parent;
    	_destination = parent._location;
		_step = 0;
		_movementSpeed = _parent.currentStats.runSpeed;
		_pathPoints = new ArrayList<Coordinate>();
		dashMultiPlier = 1;
	}
	
	@Override
	public void update() {
		Coordinate location = _parent._location;
		_currentSpeed = -1.0;
		if(TouchInputManager.touchLocation != null)
		{
			if((Math.abs(location.calculateDistance(TouchInputManager.touchLocation)) > MINIMUM_MOVE_DISTANCE)
					&& !_destination.equals(TouchInputManager.touchLocation))
			{
				_destination = TouchInputManager.touchLocation;
						
				if(_step == 0)
				{
					System.out.println("step is zero");
				}
				_pathPoints.clear();
				
				//Calculates Path from Current Location to Destination
				//===================================================================================
		    	final double time = (Math.sqrt((Math.pow(_destination.x - location.x, 2) + Math.pow(_destination.y - location.y, 2)))/_movementSpeed);
		        final double yStepSize = (_destination.y - location.y)/(time*(_movementSpeed/**GlobalDisplayVariables.screenHeightRatio*/));
		        final double xStepSize = (_destination.x - location.x)/(time*(_movementSpeed/**GlobalDisplayVariables.screenWidthRatio*/));
		
		        for(int calcStep = 0; calcStep < time; calcStep++)
		        {
		            _pathPoints.add(new Coordinate(location.x + Math.round(calcStep*_movementSpeed*xStepSize)
		                                    , location.y + Math.round(calcStep*_movementSpeed*yStepSize)));
		        }
		        //===================================================================================
		        _step = 0;
		        
		        
			}
			
			try
			{
				_currentSpeed = _parent.getLocation().calculateDistance(_pathPoints.get(_step));
				_parent.setLocation(_pathPoints.get(_step));
				_step++;
			}
			catch(IndexOutOfBoundsException e)
			{
				System.err.println(e.getMessage());
			}
		}
	}
	
	public void setDestination(Coordinate destination)
	{
		_destination = destination;
	}
	
	public Coordinate getDestination()
	{
		return _destination;
	}
	
	
	public void displayDebugMessage(String g)
	{
		
	}

	@Override
	public void drawEffect(Canvas g) {
		// TODO Auto-generated method stub
		
	}
}
