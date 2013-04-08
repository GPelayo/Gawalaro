package com.gpelayo.app.gawalaro.gameObjects;

import android.graphics.Canvas;
import android.graphics.Color;

public class Avatar extends BaseGameObject{
	static final float UNIT_WIDTH = 25;
	static final float UNIT_HEIGHT = 25;	
	
	public Avatar(Coordinate spawnLocation)
	{
		super(spawnLocation);
		brush.setColor(Color.WHITE);
		_gameComponents.add(new TiltMoveComponent(this));
	}
	
	@Override
	public void draw(Canvas g) {
		for(GameComponent iGameComponent : _gameComponents)	{
			iGameComponent.drawEffect(g);
		}
		
		g.drawRect(location.getFloatX(), location.getFloatY(), location.getFloatX() + UNIT_WIDTH/2, location.getFloatY() + UNIT_HEIGHT/2, brush);
	}
}
