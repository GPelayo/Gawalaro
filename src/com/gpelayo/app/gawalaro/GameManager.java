/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gpelayo.app.gawalaro;

import java.text.DecimalFormat;
import java.util.ArrayList;

import com.gpelayo.app.gawalaro.gameObjects.*;

import android.graphics.*;


public class GameManager{
	static final int AVATAR_SPAWN_LOCATION_X = (int)GlobalDisplayVariables.getMiddlePointX();
	static final int AVATAR_SPAWN_LOCATION_Y = (int)GlobalDisplayVariables.getMiddlePointY();
	static final int SENSOR_STATUS_DEBUG_TEXT_LOC_X = 10;
	static final int SENSOR_STATUS_DEBUG_TEXT_LOC_Y = 10;

	private GameThread gameThread;
	private ArrayList<BaseGameObject> gameObjects;
	
	public GameManager(GameView gameView)
	{
		this.gameObjects = new ArrayList<BaseGameObject>();
		initGameObjects();
		this.gameThread = new GameThread(gameView, this);
	}
	
    public void drawForeground(Canvas g)    {
    	g.drawColor(Color.BLACK);
    	
    	for(BaseGameObject iGameObject : gameObjects)	{
    		iGameObject.draw(g);
    	} 
    }
    
    public void drawDebugDisplay(Canvas g)    {
    	Paint debugTextPaint = new Paint();
    	
    	float[] orientValues = new float[3];
    	String accelStatus = "Not Ready";
    	
    	debugTextPaint.setColor(Color.GREEN);
    	
    	if(TiltInputManager.geomagneticMatrix != null
    		&&	TiltInputManager.accelormenterValues != null)    	{
    		orientValues = TiltInputManager.accelormenterValues;
    		StringBuilder m_stringBuilder = new StringBuilder();
    		m_stringBuilder.append("X: ");
    		m_stringBuilder.append(new DecimalFormat("#.##").format(orientValues[0]));
    		m_stringBuilder.append(" Y: ");
    		m_stringBuilder.append(new DecimalFormat("#.##").format(orientValues[1]));
    		m_stringBuilder.append(" Z: ");
    		m_stringBuilder.append(new DecimalFormat("#.##").format(orientValues[2]));
    		accelStatus = m_stringBuilder.toString();
    	}
    	
    	g.drawText(accelStatus, SENSOR_STATUS_DEBUG_TEXT_LOC_X, SENSOR_STATUS_DEBUG_TEXT_LOC_Y, debugTextPaint); 
    }
    
    public void updateObjects()
    {
    	for(BaseGameObject iGameObject : gameObjects)
    	{
    		iGameObject.update();
    	}
    }
    
    public void resetObjectLocations()
    {
    	for(BaseGameObject iGameObject : gameObjects)
    	{
    		iGameObject.resetToSpawnLocation();
    	}
    }
    
    public void initGameObjects()
    {
    	Avatar testUnit = new Avatar(new Coordinate(AVATAR_SPAWN_LOCATION_X, AVATAR_SPAWN_LOCATION_Y));
    	gameObjects.add(testUnit);
    }
    
    public void startThreads()
    {
		this.gameThread.start();
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