package barebones.gameObjects;

import java.util.ArrayList;
import android.graphics.*;


public abstract class BaseGameObject{
	public boolean isDebug = false;
	
    protected Coordinate _location;
    protected boolean isOutOfPlay = false;
    protected boolean isVisible = true;
    protected String _id;
    protected ArrayList<GameComponent> _gameComponents = new ArrayList<GameComponent>();
    
    public boolean isCondemned()
    {
        return isOutOfPlay;
    }
    
    public String getId() {
        return _id;
    }
    
    public void setId(String id) {
        this._id = id;
    }   
    
    public Coordinate getLocation() {
        return _location;
    }

    public void setLocation(Coordinate location) {
        this._location = location;
    }
    
    public boolean getVisibility() {
        return isVisible;
    }

    public void setVisibility(boolean isVisible) {
        this.isVisible = isVisible;
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
    
    public void update()
    {
    	for(GameComponent iGameComponent : _gameComponents)
    	{
    		iGameComponent.update(this);
    	}
    }
    
    abstract public void draw(Canvas g); 
}