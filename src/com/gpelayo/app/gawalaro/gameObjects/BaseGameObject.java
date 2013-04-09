package com.gpelayo.app.gawalaro.gameObjects;

import java.util.ArrayList;
import android.graphics.*;


public abstract class BaseGameObject{
	public Stats currentStats =  new Stats();;
	public Paint brush = new Paint();
	public boolean isDebug = false;	
	public Coordinate location, spawnLocation;
	
	protected Stats baseStats =  new Stats();
    protected boolean isOutOfPlay = false;
    protected boolean isVisible = true;
    protected String id;
    protected ArrayList<GameComponent> gameComponents = new ArrayList<GameComponent>();
    protected GameObjectStatus currentObjectStatus = new GameObjectStatus(); 
    
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
		this.currentObjectStatus.reset();
	}
    
    public void drawIfVisible(Canvas g)   {
        if(this.isVisible)
        {
            draw(g);
        }
    }
    
    public void addGameComponent(GameComponent newGameComponent)
    {
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
    		_gameComponent.update();
    	}
    }
    
    abstract public void draw(Canvas g);
}