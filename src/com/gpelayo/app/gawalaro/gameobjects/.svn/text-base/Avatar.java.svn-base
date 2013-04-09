package barebones.gameObjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Unit extends BaseGameObject{
	static final float UNIT_WIDTH = 25;
	static final float UNIT_HEIGHT = 25;
	static final int UNIT_SPEED = 10;
	
	public Unit(Coordinate spawnLocation)
	{
		_location = spawnLocation;
		
		_gameComponents.add(new MoveComponent(UNIT_SPEED));
	}
	
	@Override
	public void draw(Canvas g) {
		Paint brush = new Paint();
		brush.setColor(Color.BLUE);
		g.drawRect(_location.getFloatX(), _location.getFloatY(), _location.getFloatX() + UNIT_WIDTH, _location.getFloatY() + UNIT_HEIGHT, brush);		
	}

}
