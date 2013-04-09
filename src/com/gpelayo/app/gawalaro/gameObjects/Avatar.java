package com.gpelayo.app.gawalaro.gameObjects;

import android.graphics.Canvas;
import android.graphics.Color;

public class Avatar extends BaseGameObject{
	static final float UNIT_WIDTH = 25;
	static final float UNIT_HEIGHT = 25;	
	static final int STARTING_SPEED = 4;
	
	public Avatar(Coordinate spawnLocation)
	{
		super(spawnLocation);
		super.brush.setColor(Color.WHITE);
		super.gameComponents.add(new TouchDashComponent(this));
		super.baseStats.runSpeed = STARTING_SPEED;
	}
	
	@Override
	public void draw(Canvas g) {
		for(GameComponent _gameComponent : super.gameComponents)	{
			_gameComponent.drawEffect(g);
		}
		
		g.drawRect(super.location.getFloatX(), super.location.getFloatY(),  
				   super.location.getFloatX() + UNIT_WIDTH/2, 
				   super.location.getFloatY() + UNIT_HEIGHT/2, super.brush);		
	}
}
