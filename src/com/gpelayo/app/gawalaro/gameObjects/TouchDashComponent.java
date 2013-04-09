package com.gpelayo.app.gawalaro.gameObjects;

import com.gpelayo.app.gawalaro.TouchInputManager;

import android.graphics.Canvas;
import android.graphics.Color;

public class TouchDashComponent extends TouchMoveComponent{
	static final double DASH_SPEED_MULTIPLIER = 2;
	
	public TouchDashComponent(BaseGameObject parent)	{
		super(parent);
	}
	
	@Override
	public void update()	{		
		if(TouchInputManager.touchLocation != null)	{
			if(!TouchInputManager.touchLocation.equals(super.destination))	{
				if(TouchInputManager.wasDoubleTapped)	{
					super.movementSpeed = (int)(DASH_SPEED_MULTIPLIER *super. parent.baseStats.runSpeed);
				}
				else	{
					super.movementSpeed = super.parent.baseStats.runSpeed;
				}
			}
		}		
		
		super.update();
	}
	

	public void drawEffect(Canvas g) {
		if(TouchInputManager.wasDoubleTapped && (super.currentSpeed > 0))	{
			super.parent.brush.setColor(Color.RED);
		}
		else
		{
			super.parent.brush.setColor(Color.WHITE);
		}
	}
}
