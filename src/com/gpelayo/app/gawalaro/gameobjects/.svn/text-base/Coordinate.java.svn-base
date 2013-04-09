package barebones.gameObjects;

public class Coordinate {
	public double x;
	public double y;
	
	public Coordinate(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double calculateDistance(Coordinate endPoint)
	{
		return Math.sqrt(Math.pow(x - endPoint.x, 2) + Math.pow((y - endPoint.y), 2));
	}
	
	public float getFloatX()
	{
		return (float)x;
	}
	
	public float getFloatY()
	{
		return (float)y;
	}
}
