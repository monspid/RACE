package objects;

public class Motorbike extends Vehicle{
	private static final String IMAGE_URL = "motorbike.png";
	private static final int MAX_SPEED = 20;
	private static final int WIDTH = 22;
	private static final int HEIGHT = 50;
	
	public Motorbike(Position p){
		super(MAX_SPEED, p, IMAGE_URL,  WIDTH, HEIGHT);
	}
	
	public Motorbike(int x, int y){
		super(MAX_SPEED, x, y, IMAGE_URL,  WIDTH, HEIGHT);
	}
}