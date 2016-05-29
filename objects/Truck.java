package objects;

public class Truck extends Vehicle{
	private static final String IMAGE_URL = "truck.png";
	private static final int MAX_SPEED = 10;
	private static final int WIDTH = 40;
	private static final int HEIGHT =96;
	
	public Truck(Position p){
		super(MAX_SPEED, p, IMAGE_URL,  WIDTH, HEIGHT);
	}
	
	public Truck(int x, int y){
		super(MAX_SPEED, x, y, IMAGE_URL, WIDTH, HEIGHT);
	}
}