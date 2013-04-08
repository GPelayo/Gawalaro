
package com.gpelayo.app.gawalaro;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class GawalaroActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        initDisplay();
    }
    
    public void initDisplay()
    {      
    	this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE);
    	//Must be before app is in fullscreen but before the GameView since it uses these global vars.
		GlobalDisplayVariables.intializeSize(this); 
    	GameView gameDisplay = new GameView(this);
    	gameDisplay.setRenderer(new GameRenderer());
        setContentView(gameDisplay);
    }
}