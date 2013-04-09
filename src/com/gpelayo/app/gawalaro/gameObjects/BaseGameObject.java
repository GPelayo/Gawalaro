package com.gpelayo.app.gawalaro.gameObjects;

import java.util.ArrayList;
import android.graphics.*;


public abstract class BaseGameObject{
	protected Stats baseStats =  new Stats();
	
	public Stats currentStats =  new Stats();;
	public Paint brush = new Paint();
	public boolean isDebug = false;	
	public Coordinate location, spawnLocation;
	
    protected boolean isOutOfPlay = false;
    protected boolean isVisible = true;
    protected String _id;
    protected ArrayList<GameComponent> _gameComponents = new ArrayList<GameComponent>();
    protected OFF_GameObjectStatus currentObjectStatus = new OFF_GameObjectStatus(); 
    
    public BaseGameObject(Coordinate spawnLocation)	{
		location = spawnLocation;
		this.spawnLocation = spawnLocation;
		baseStats.runSpeed = 1;		
		resetStats();
	}
    
    public boolean isCondemned()    {
        return isOutOfPlay;
    }
    
    public String getId() {
        return _id;
    }
    
    public void setId(String id) {
        this._id = id;
    }
    
    public boolean getVisibility() {
        return isVisible;
    }

    public void setVisibility(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    public void resetStats()
	{
		currentStats = baseStats;
		currentObjectStatus.reset();
	}
    
    public void drawIfVisible(Canvas g)
    {
        if(isVisible)
        {
            draw(g);
        }
    }
    
    public void addGameComponent(GameComponent newGameComponent)
    {
    	_gameComponents.add(newGameComponent);
    }
    
    public void resetToSpawnLocation()
    {
    	this.location = spawnLocation;
    }
    
    public void update()
    {
    	for(GameComponent iGameComponent : _gameComponents)
    	{
    		iGameComponent.update();
    	}
    }
    
    abstract public void draw(Canvas g);
}