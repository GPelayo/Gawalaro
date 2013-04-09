package com.gpelayo.app.gawalaro.gameObjects;
import android.graphics.Canvas;

public abstract class GameComponent {
	public BaseGameObject parent;
	
	public abstract void update();
	public abstract void drawEffect(Canvas g);
}
