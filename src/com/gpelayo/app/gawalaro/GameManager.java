/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gpelayo.app.gawalaro;

import java.util.ArrayList;

import com.gpelayo.app.gawalaro.gameObjects.*;


import android.graphics.*;

public class GameManager{
	static final int AVATAR_SPAWN_LOCATION_X = (int)GlobalDisplayVariables.getMiddlePointX();
	static final int AVATAR_SPAWN_LOCATION_Y = (int)GlobalDisplayVariables.getMiddlePointY();
	
	private GameThread dartThread;
	private ArrayList<BaseGameObject> gameObjects;
	
	public GameManager(GameView gameView)
	{
		gameObjects = new ArrayList<BaseGameObject>();
		initGameObjects();
		dartThread = new GameThread(gameView, this);
		dartThread.start();
	}
	
    public void drawForeground(Canvas g)
    {
    	g.drawColor(Color.BLACK);
    	
    	for(BaseGameObject iGameObject : gameObjects)
    	{
    		iGameObject.draw(g);
    	}
    }
    
    public void updateObjects()
    {
    	for(BaseGameObject iGameObject : gameObjects)
    	{
    		iGameObject.update();
    	}
    }
    
    public void initGameObjects()
    {
    	Avatar testUnit = new Avatar(new Coordinate(AVATAR_SPAWN_LOCATION_X, AVATAR_SPAWN_LOCATION_Y));
    	gameObjects.add(testUnit);
    }
/*    
    private void safetlyAddGameObjectToArray(GameObject newElement, GameObject[] array)
    {
    	boolean noVacantElements = true;
		
		for(int index = 0; (index < array.length)&&noVacantElements; index++)
        {
			if((array[index] == null)||(array[index].isCondemned()))
			{
				array[index] = newElement;
				noVacantElements = false;
			}
        }
		
		if(noVacantElements)
		{
			array[0] = newElement;
		}
    }
*/
}