package objects;

public class Car extends Vehicle{
	private static final String IMAGE_BLUE_URL = "car.png";
	private static final String IMAGE_RED_URL = "car_destroyed.png";
	private static final String IMAGE_GREEN_URL = "car_destroyed.png";
	private static final int MAX_SPEED = 15;
	private static final int WIDTH = 34;
	private static final int HEIGHT = 62;
	
	public Car(Position p){
		super(MAX_SPEED, p, getRandomImageUrl(),  WIDTH, HEIGHT);
	}
	
	public Car(int x, int y){
		super(MAX_SPEED, x, y, getRandomImageUrl(),  WIDTH, HEIGHT);
	}
	
	public Car(Position p, int color){
		super(MAX_SPEED, p, getImageUrl(color), WIDTH, HEIGHT);
	}
	
	public Car(int x, int y, int color){
		super(MAX_SPEED, x, y, getImageUrl(color), WIDTH, HEIGHT);
	}
	
	private static String getRandomImageUrl(){
		int rand = (int)(Math.random() * 2);
		return getImageUrl(rand);
	}
	
	private static String getImageUrl(int c){
		switch(c){
		case 1:
			return IMAGE_BLUE_URL;
		case 2:
			return IMAGE_RED_URL;
		default:
			return IMAGE_GREEN_URL;
		}
	}
}
