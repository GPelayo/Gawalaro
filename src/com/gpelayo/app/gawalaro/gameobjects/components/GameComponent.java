package com.gpelayo.app.gawalaro.gameobjects.components;

import android.graphics.Canvas;

import com.gpelayo.app.gawalaro.gameobjects.BaseGameObject;

public abstract class GameComponent {
	public BaseGameObject parent;
	
	public abstract void update(long gametime);
	public abstract void drawDebugInfo(Canvas g);
}
