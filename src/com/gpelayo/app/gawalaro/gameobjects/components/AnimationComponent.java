package com.gpelayo.app.gawalaro.gameobjects.components;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.gpelayo.app.gawalaro.gameobjects.*;

public class AnimationComponent extends GameDisplayableComponent{	
	public int currentFrameNo;
	public Animation currentAnimation;
	public ImageState currentDisplayState;
	
	private Bitmap currentFrame, currentSpriteSheet;
	private ArrayList<Animation> animations, matchingAnimations; //TODO make it an arrayOfArrays or AnimationTree
																//TODO @Optimization set *matchingAnimations* to animationSize-1;
	private int frameNumber;
	private long timeOfLastFrame, currentFPS;
	private Random frameRNG;
	
	public AnimationComponent(ForegroundGameObject parent)	{
		super.parent = parent;
		animations = new ArrayList<Animation>();
		matchingAnimations = new ArrayList<Animation>();
		frameNumber = 0;
		timeOfLastFrame = 0;
		currentDisplayState = ImageState.Null;
		frameRNG = new Random();
	}
	
	public void addAnimation(Animation animation)	{
		//asserts if an animation has the same name
		for(Animation _animation : animations)	{
			assert _animation.animationState != animation.animationState : "Animation state already used!";
		}	
			
		if(currentAnimation == null)	{
			currentAnimation = animation;
		}
		boolean needSorting = true;
		
		for(int i = 0; (i < animations.size()) && needSorting; i++)	{
			if(animations.get(i).getProbablity() < animation.getProbablity()) {
				needSorting = false;
				animations.add(i, animation);
			}					
		}
		
		if(needSorting){
			this.animations.add(animation);
		}
	}
	
	@Override
	public void update(long gametime) {
		boolean animationDoesntExist = true, mirroredHorizontally = true, lastFrameHasLooped = true;
		
		mirroredHorizontally = (this.currentAnimation.symmetricalness != Alignment.None
				&& parent.currentDirectionFacing.isFacingOppositeOf(this.currentAnimation.directionFacing));
		
		if(this.currentDisplayState != parent.currentImageState)	{ //nest resets the display once the animation changes
			matchingAnimations.clear();
			//for(int i = 0; i < this.animations.size(); i++)	{
			for(Animation _animation : this.animations)	{
				if((_animation.animationState == parent.currentImageState)){
					this.matchingAnimations.add(_animation);
				}
			}
			
			float randomFloat = frameRNG.nextFloat();
			for(Animation _animation : this.matchingAnimations)	{
				if(randomFloat <= _animation.getProbablity() || animationDoesntExist)	{
					this.currentAnimation = _animation;
					animationDoesntExist = false;
				}
			}
			
			if(!mirroredHorizontally)
			{
				this.frameNumber = currentAnimation.noOfFrames-1;
			}
			else 
			{
				this.frameNumber = 0;
			}
			this.timeOfLastFrame = 0;
			this.currentDisplayState = parent.currentImageState;
			
			if(animationDoesntExist)	{
				System.err.println("Animation for the state: " + currentDisplayState.toString() 
						+ " doesn't exist in of animation component");
			}
		}
		
		if((gametime - timeOfLastFrame) >= currentFPS)	{					
			if(mirroredHorizontally) {
					currentSpriteSheet = currentAnimation.mirroredSpriteSheet;
			}
			else	{
				currentSpriteSheet = currentAnimation.spriteSheet;
			}
			
			int width = currentAnimation.firstFrameArea.width();
			int x = currentAnimation.firstFrameArea.left
					+ width * frameNumber;
			currentFrameNo = frameNumber;
			currentFPS = 1000 / currentAnimation.fps;
			currentFrame = Bitmap.createBitmap(currentSpriteSheet, x, currentAnimation.firstFrameArea.top, 
					width,
					currentAnimation.firstFrameArea.height());
			timeOfLastFrame = gametime;
			
			
			if(mirroredHorizontally)
			{
				if(this.frameNumber > 0)
				{
					this.frameNumber--;
				}
				else
				{
					this.frameNumber = currentAnimation.noOfFrames-1;
					lastFrameHasLooped = true;
				}
			}
			else
			{
				if(this.frameNumber < (currentAnimation.noOfFrames-1))
				{
					this.frameNumber++;
				}
				else
				{
					frameNumber = 0;
					lastFrameHasLooped = true;
				}
			}
		}
	
		if(lastFrameHasLooped) 
		{				
			float randomFloat = frameRNG.nextFloat();
			for(Animation _animation : this.matchingAnimations)	{
				if(randomFloat <= _animation.getProbablity() || animationDoesntExist)	{
					this.currentAnimation = _animation;
					animationDoesntExist = false;
				}
			}
			
			lastFrameHasLooped = false;
		}

		parent.currentSprite.bitmap = currentFrame;
	}		
	
	public void drawDebugInfo(Canvas g) {
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		g.drawText("Animation State:" + currentAnimation.animationState.toString(), 150, 10, paint);
		g.drawText("Animation Frame:" + currentFrameNo, 150, 25, paint);		
	}
}
