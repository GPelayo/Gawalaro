package com.gpelayo.app.gawalaro.gameobjects;

public final class CardinalDirection {
	
	public final static CardinalDirection North = new CardinalDirection(1);
	public final static CardinalDirection South = new CardinalDirection(-1);;
	public final static CardinalDirection West = new CardinalDirection(2);;
	public final static CardinalDirection East = new CardinalDirection(-2);;
	public final static CardinalDirection None = new CardinalDirection(1337);

	private int value;
	
	private CardinalDirection(int i)	{
		this.value = i;
	}
	
	public boolean isFacingOppositeOf(CardinalDirection direction){
		return (direction.value + this.value) == 0;
	}
}
