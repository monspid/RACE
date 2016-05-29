package objects;

public class Boom extends MapObject{
	private static final String IMAGE_URL = "truck.png";
	private static final int FRAMES = 0;
	private static final int WIDTH = 40;
	private static final int HEIGHT = 96;
	private int frame_counter = 0;
	
	public Boom(int x, int y){
		super(x, y, IMAGE_URL);
	}
	

	public void animate(){
	}
	
}
