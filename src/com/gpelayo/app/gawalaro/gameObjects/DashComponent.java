package com.gpelayo.app.gawalaro.gameObjects;

import android.graphics.Canvas;
import android.graphics.Color;

public class DashComponent extends MoveComponent{
	static final double DASH_SPEED_MULTIPLIER = 2;
	
	public DashComponent(BaseGameObject parent)
	{
		super(parent);
	}
	
	@Override
	public void update()	{
		
		if(TouchInputManager.touchLocation != null)	{
			if(!TouchInputManager.touchLocation.equals(_destination))	{
				if(TouchInputManager.wasDoubleTapped)	{
					_movementSpeed = (int)(DASH_SPEED_MULTIPLIER * _parent.baseStats.runSpeed);
				}
				else	{
					_movementSpeed = _parent.baseStats.runSpeed;
				}
			}
		}		
		
		super.update();
	}
	

	public void drawEffect(Canvas g) {
		if(TouchInputManager.wasDoubleTapped && (_currentSpeed > 0))	{
			_parent.brush.setColor(Color.RED);
		}
		else
		{
			_parent.brush.setColor(Color.WHITE);
		}
	}
}
