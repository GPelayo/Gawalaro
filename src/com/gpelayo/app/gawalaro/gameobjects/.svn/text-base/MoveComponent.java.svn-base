package barebones.gameObjects;

import java.util.ArrayList;

import barebones.android.InputData;


public class MoveComponent implements GameComponent{
	int _speed, _step;
	ArrayList<Coordinate> _pathPoints;
    Coordinate _destination, touchLocation;
	
	public MoveComponent(int speed)
	{
		_destination = new Coordinate(0,0);
		_step = 0;
		_speed = speed;
		_pathPoints = new ArrayList<Coordinate>();
	}
	
	@Override
	public void update(BaseGameObject parent) {
		Coordinate location = parent.getLocation();
		
		if((Math.abs(location.calculateDistance(_destination)) <= 10)||(_pathPoints.size() == _step))
		{
			_pathPoints.clear();
			if(_destination != InputData.touchLocation)
			{
				_destination = InputData.touchLocation;
			}
			//Calculates Path from Current Location to Destination
			//===================================================================================
	    	final double time = (Math.sqrt((Math.pow(_destination.x - location.x, 2) + Math.pow(_destination.y - location.y, 2)))/_speed);
	        final double yStepSize = (_destination.y - location.y)/(time*_speed);
	        final double xStepSize = (_destination.x - location.x)/(time*_speed);
	
	        for(int calcStep = 0; calcStep < time; calcStep++)
	        {
	            _pathPoints.add(new Coordinate(location.x + Math.round(calcStep*_speed*xStepSize)
	                                    , location.y + Math.round(calcStep*_speed*yStepSize)));
	        }
	        //===================================================================================
	        _step = 0;
		}
		
		parent.setLocation(_pathPoints.get(_step));
		_step++;
	}
	
	public void setDestination(Coordinate destination)
	{
		_destination = destination;
	}
	
	public Coordinate getDestination()
	{
		return _destination;
	}
		
}
