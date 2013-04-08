package com.gpelayo.app.gawalaro.gameObjects;

import android.graphics.Canvas;

public class Avatar extends BaseGameObject{
	static final float UNIT_WIDTH = 25;
	static final float UNIT_HEIGHT = 25;	
	
	public Avatar(Coordinate spawnLocation)
	{
		_location = spawnLocation;
		
		baseStats.runSpeed = 5;
		
		resetStats();
		_gameComponents.add(new DashComponent(this));
	}
	
	@Override
	public void draw(Canvas g) {
		//g.drawColor(Color.BLACK);
		for(GameComponent iGameComponent : _gameComponents)	{
			iGameComponent.drawEffect(g);
		}
		
		g.drawRect(_location.getFloatX(), _location.getFloatY(), _location.getFloatX() + UNIT_WIDTH/2, _location.getFloatY() + UNIT_HEIGHT/2, brush);
		
	}
}
