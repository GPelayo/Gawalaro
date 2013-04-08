package com.gpelayo.app.gawalaro;

import android.graphics.Canvas;

public class GameThread extends Thread {
	public boolean isThreadEnabled;
	
	private GameView thisDartView;
	private GameManager _engine;
	
	public GameThread(GameView dartView, GameManager engine) {
		thisDartView = dartView;
		isThreadEnabled = true;
		_engine = engine;
	}
	
	@Override
	public void run() {	
		while(true)
		{
			if(isThreadEnabled)
			{
				_engine.updateObjects();
				Canvas c = null;
				try {
					c = thisDartView.getHolder().lockCanvas(null);
					synchronized (thisDartView) {
						if(c != null)
						{
							thisDartView.doDraw(c);
						}
					}
				} finally {
					if (c != null) {
						thisDartView.getHolder().unlockCanvasAndPost(c);
					}
				}
			}
		}
	}
}