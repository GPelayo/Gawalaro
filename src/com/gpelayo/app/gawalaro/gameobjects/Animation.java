 package com.gpelayo.app.gawalaro.gameobjects;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;

public class Animation {
	public int noOfFrames, fps, firstFrameIndex, lastFrameIndex;
	private float probability; 	//If more than one animation is assigned to a state, 
								//the "probability" value is used to determine what 
								//is the probability of an animation being displayed as a percent
	public CardinalDirection directionFacing;
	public ImageState animationState;
	public Rect firstFrameArea;
	public Bitmap spriteSheet, mirroredSpriteSheet;
	public Alignment symmetricalness;
	
	public Animation(ImageState animationState, int noOfFrames, Rect firstStringArea, 
			int fps, Bitmap spriteSheet, Alignment symmetricalness)
	{
		this.animationState = animationState;
		this.firstFrameArea = firstStringArea;
		this.noOfFrames = noOfFrames;
		this.fps = fps;
		this.spriteSheet = spriteSheet;
		this.symmetricalness = symmetricalness;
		this.directionFacing = CardinalDirection.None;
		if(Alignment.None != symmetricalness)	{
			Matrix inverser = new Matrix();
			inverser.preScale(-1.0f, 1.0f); //TODO Make Matrix will be different depending on the 
			mirroredSpriteSheet = Bitmap.createBitmap(spriteSheet,
					0, 0, spriteSheet.getWidth(), spriteSheet.getHeight()
					, inverser, false);
		}
	}
	
	public Animation(ImageState animationState, int noOfFrames, Rect firstStringArea, int fps, Bitmap spriteSheet)	{
		this(animationState, noOfFrames, firstStringArea, fps, spriteSheet, Alignment.None);		
	}
	
	public Animation()	{
		this.animationState = ImageState.Null;
		this.firstFrameArea = new Rect(0,0,0,0);
		this.noOfFrames = 0;
		this.fps = 0;
		//this.spriteSheet = GraphicsManager.getBitmap("R.blahblah.DummyImage") //TODO implement once dummyImage is set
		this.symmetricalness = Alignment. None;
		this.directionFacing = CardinalDirection.None;
	}
	
	public void setProbablity(float probability){
		if(probability > 1)	{
			probability = 1;  
		}
		this.probability = probability;
	}
	
	public float getProbablity(){
		return this.probability;
	}
}