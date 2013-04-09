package com.gpelayo.app.gawalaro.gameobjects;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.gpelayo.app.gawalaro.GraphicsManager;
import com.gpelayo.app.gawalaro.R;
import com.gpelayo.app.gawalaro.gameobjects.components.*;

public class ForegroundGameObject extends BaseGameObject{
	private static final int UNIT_WIDTH = 39;
	private static final int UNIT_HEIGHT = 42;	
	private static final int STARTING_SPEED = 2;
	private static final int IDLE_FPS = 5;
	private static final int WALKING_FPS = 20;	
	private static final int DEFAULT_FOREGROUND_COLOR = Color.WHITE;
	private static final int DEFUALT_TEXT_COLOR = Color.BLACK;
	private static final String NO_IMAGE_TEXT	= "";//"No Image Loaded";
	
	public Sprite currentSprite;
	public ImageState currentImageState;
	public CardinalDirection currentDirectionFacing;
 	
	public ForegroundGameObject(Coordinate spawnLocation)	{
		super(spawnLocation);
		currentImageState = ImageState.Idle;
		this.currentDirectionFacing = CardinalDirection.East;
		currentSprite = new Sprite(new Animation(), null);
		AnimationComponent animationComp = new AnimationComponent(this);
		//===================Sprite Data======================================
		//TODO Serialize This
		Bitmap WALKING_SPRITESHEET = GraphicsManager.getBitmap(R.drawable.megaman_walking);
		Rect SPRITE_FRAME_AREA = new Rect(0, 0, 42, 43); 
		Animation walkingAnimation = new Animation(ImageState.Moving, 
															13, SPRITE_FRAME_AREA, WALKING_FPS, WALKING_SPRITESHEET,Alignment.horizontal);
		walkingAnimation.directionFacing = CardinalDirection.East;
		
		Bitmap IDLE_SPRITESHEET = GraphicsManager.getBitmap(R.drawable.megaman_idle);
		Animation idleAnimation = new Animation(ImageState.Idle, 
															4, SPRITE_FRAME_AREA, IDLE_FPS, IDLE_SPRITESHEET, Alignment.horizontal);
		idleAnimation.setProbablity(0.10f);
		idleAnimation.directionFacing = CardinalDirection.East;
		
		Animation idle2Animation = new Animation(ImageState.Idle, 
								1, SPRITE_FRAME_AREA, IDLE_FPS, IDLE_SPRITESHEET, Alignment.horizontal);
		idle2Animation.setProbablity(0.90f);
		idle2Animation.directionFacing = CardinalDirection.East;
		//===================Sprite Data======================================
		
		animationComp.addAnimation(walkingAnimation);
		animationComp.addAnimation(idleAnimation);
		animationComp.addAnimation(idle2Animation);
		super.baseStats.runSpeed = STARTING_SPEED;
		super.gameComponents.add(animationComp);
		super.gameComponents.add(new TouchDashComponent(this));
	}
	
	private Coordinate calcDisplayLocation(Coordinate location, int width, int height)	{
		Coordinate newCoordinate = new Coordinate(location.x, location.y);
		
		newCoordinate.x = location.x - width/2;
		newCoordinate.y = location.y - height/2;
		
		return newCoordinate;
	}
	
	@Override
	public void draw(Canvas g) {
		Coordinate displayLocation;
		Paint foregroundPaint = new Paint();
		Paint textPaint = new Paint();
		foregroundPaint.setColor(DEFUALT_TEXT_COLOR);
		textPaint.setColor(DEFAULT_FOREGROUND_COLOR);
		if(this.currentSprite.bitmap != null) {
			displayLocation = calcDisplayLocation(super.location, 
					this.currentSprite.bitmap.getWidth(), this.currentSprite.bitmap.getHeight());
				g.drawBitmap(currentSprite.bitmap, displayLocation.x, displayLocation.y, null);
		}
		else	{
			displayLocation = calcDisplayLocation(super.location, 
					UNIT_WIDTH, UNIT_HEIGHT);
			g.drawRect(displayLocation.x, displayLocation.y,
					   displayLocation.x + UNIT_WIDTH/2, 
					   displayLocation.y + UNIT_HEIGHT/2, foregroundPaint);
			g.drawText(NO_IMAGE_TEXT, displayLocation.x, displayLocation.y, foregroundPaint);
		}
	}

	@Override
	public void drawDebugDisplay(Canvas g) {		
		for(GameComponent _gameComponent : super.gameComponents)	{
			_gameComponent.drawDebugInfo(g);
		}
	}
}