package com.gpelayo.app.gawalaro.gameobjects;

import android.graphics.Bitmap;

public class Sprite {
	public Animation parentAnimation;
	public Bitmap bitmap;

	public Sprite(Animation animation, Bitmap spriteImage){
		this.parentAnimation = animation;
		this.bitmap = spriteImage;
	}
}
