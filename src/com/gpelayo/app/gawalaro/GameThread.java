package com.gpelayo.app.gawalaro;


import android.graphics.Canvas;

public class GameThread extends Thread {
	public boolean isThreadEnabled;
	
	private GameView dartView;
	private GameManager engine;
	
	public GameThread(GameView dartView, GameManager engine) {
		this.dartView = dartView;
		this.isThreadEnabled = true;
		this.engine = engine;
	}
	
	@Override
	public void run() {	
		while(true)
		{
			if(isThreadEnabled)
			{
				this.engine.updateObjects();
				Canvas c = null;
				try {
					c = this.dartView.getHolder().lockCanvas(null);
					synchronized (this.dartView) {
						if(c != null)
						{
							this.dartView.doDraw(c);
						}
					}
				} finally {
					if (c != null) {
						this.dartView.getHolder().unlockCanvasAndPost(c);
					}
				}
			}
		}
	}
}