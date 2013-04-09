package com.gpelayo.app.gawalaro.gameobjects.components;

import com.gpelayo.app.gawalaro.TouchInputManager;
import com.gpelayo.app.gawalaro.gameobjects.*;

public class TouchDashComponent extends TouchMoveComponent{
	static final int DASH_SPEED_MULTIPLIER = 2;
	
	public TouchDashComponent(ForegroundGameObject parent)	{
		super(parent);
	}
	
	@Override
	public void update(long gametime)	{		
		if(TouchInputManager.touchLocation != null)	{
			if(!TouchInputManager.touchLocation.equals(super.destination))	{
				if(TouchInputManager.wasDoubleTapped)	{
					super.movementSpeed = DASH_SPEED_MULTIPLIER *super.parent.baseStats.runSpeed;
				}
				else	{
					super.movementSpeed = super.parent.baseStats.runSpeed;
				}
			}
		}		
		
		super.update(gametime);
	}
}
