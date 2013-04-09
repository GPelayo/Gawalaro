package com.gpelayo.app.gawalaro.gameobjects;

import java.util.ArrayList;

import android.graphics.Canvas;

import com.gpelayo.app.gawalaro.gameobjects.components.*;


public abstract class BaseGameObject{
	public Stats baseStats =  new Stats();
	public Stats currentStats =  new Stats();
	public boolean isDebug = false;	
	public Coordinate location, spawnLocation;
	
    protected boolean isOutOfPlay = false;
    protected boolean isVisible = true;
    protected String id;
    protected ArrayList<GameComponent> gameComponents = new ArrayList<GameComponent>();
    
    public BaseGameObject(Coordinate spawnLocation)	{
		this.location = spawnLocation;
		this.spawnLocation = spawnLocation;
		this.resetStats();
	}
    
    public boolean isCondemned()    {
        return isOutOfPlay;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public boolean getVisibility() {
        return isVisible;
    }

    public void setVisibility(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    public void resetStats()	{
		this.currentStats = this.baseStats;
	}
    
    public void drawIfVisible(Canvas g)
    {
        if(this.isVisible)
        {
            draw(g);
        }
    }
    
    public void addGameComponent(GameComponent newGameComponent)    {
    	this.gameComponents.add(newGameComponent);
    }
    
    public void resetToSpawnLocation()
    {
    	this.location = spawnLocation;
    }
    
    public void update()
    {
    	for(GameComponent _gameComponent : this.gameComponents)
    	{
    		_gameComponent.update(System.currentTimeMillis());
    	}
    }
    
    abstract public void draw(Canvas g);
    abstract public void drawDebugDisplay(Canvas g);
}