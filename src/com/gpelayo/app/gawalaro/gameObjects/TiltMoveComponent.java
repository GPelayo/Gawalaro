package com.gpelayo.app.gawalaro.gameObjects;

import com.gpelayo.app.gawalaro.TiltInputManager;

import android.graphics.Canvas;

public class TiltMoveComponent extends GameComponent	{
	
	private int movementSpeed;
	
    public TiltMoveComponent(BaseGameObject parent)	{
    	this._parent = parent;
		this.movementSpeed = this._parent.currentStats.runSpeed;
	}
	
	@Override
	public void update() {
		if(TiltInputManager.accelormenterValues != null)	{
			float newX = this._parent.location.x + this.movementSpeed * (-1*TiltInputManager.accelormenterValues[0]);
			float newY = this._parent.location.y + this.movementSpeed * TiltInputManager.accelormenterValues[1];
			this._parent.location = new Coordinate(newX, newY);
		}
	}	
	
	public void displayDebugMessage(String g)	{
		
	}

	@Override
	public void drawEffect(Canvas g) {
		
	}
}
