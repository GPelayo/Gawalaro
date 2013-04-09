package com.gpelayo.app.gawalaro;

import java.text.DecimalFormat;
import java.util.ArrayList;

import com.gpelayo.app.gawalaro.gameobjects.*;

import android.graphics.*;

public class GameManager{
	static final float AVATAR_SPAWN_LOCATION_X = GlobalDisplayVariables.getMiddlePointX();
	static final float AVATAR_SPAWN_LOCATION_Y = GlobalDisplayVariables.getMiddlePointY();
	static final float FPS_X_LOCATION = 10;
	static final float FPS_Y_LOCATION = 10;

	private long timeOfLastUpdate, currentTime;
	private int fps, framesMade;
	private GameThread gameThread;
	private ArrayList<BaseGameObject> gameObjects;
	
	public GameManager(GameView gameView)	{
		this.gameObjects = new ArrayList<BaseGameObject>();
		this.initGameObjects();
		this.gameThread = new GameThread(gameView, this);
		this.timeOfLastUpdate = System.currentTimeMillis();
		fps = 0;
	}
	
	//TODO Combine draws into one method
    public void drawForeground(Canvas g)    {
    	g.drawColor(Color.BLACK);
    	for(BaseGameObject _gameObject : this.gameObjects)	{
    		_gameObject.draw(g);
    	} 
    }
    
    public void drawDebugDisplay(Canvas g)    {
    	for(BaseGameObject _gameObject : this.gameObjects)	{
    		_gameObject.drawDebugDisplay(g);
    	}
    	DecimalFormat fpsFormat = new DecimalFormat("#.##");
    	StringBuilder fpsInfo = new StringBuilder();
    	fpsInfo.append("FPS: ");
    	fpsInfo.append(fpsFormat.format(fps));
    	Paint fpsBrush = new Paint();
    	fpsBrush.setColor(Color.WHITE);
    	g.drawText(fpsInfo.toString(), FPS_X_LOCATION, FPS_Y_LOCATION, fpsBrush);
    }
    
    public void updateObjects()	{
    	for(BaseGameObject _gameObject : this.gameObjects)	{
    		_gameObject.update();
    	}
    	currentTime = System.currentTimeMillis();
    	framesMade++;
    	if(currentTime - timeOfLastUpdate > 1000)	{
    		fps = framesMade;
    		framesMade = 0;    		
        	timeOfLastUpdate = System.currentTimeMillis();
    	}
    }
    
    public void initGameObjects()
    {
    	ForegroundGameObject testUnit = new ForegroundGameObject(new Coordinate(AVATAR_SPAWN_LOCATION_X, AVATAR_SPAWN_LOCATION_Y));
    	this.gameObjects.add(testUnit);
    }
    
    public void startThreads(){
		this.gameThread.start();
    }
}