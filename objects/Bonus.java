package objects;

public class Bonus extends MapObject{
	private static final String IMAGE_URL = "coin.png";
	private static final int FRAMES = 6;
	private static final int WIDTH = 26;
	private static final int HEIGHT = 26;
	private int point_bonus;
	private int speed_bonus;
	private int frame_counter = 0;

	public Bonus(Position p){
		super(p, IMAGE_URL,  WIDTH, HEIGHT);
	}
	
	public Bonus(int x, int y){
		super(x, y, IMAGE_URL,  WIDTH, HEIGHT);
	}
	
	public Bonus(Position p, int p_b, int s_b){
		super(p, IMAGE_URL,  WIDTH, HEIGHT);
		point_bonus = p_b;
		speed_bonus = s_b;
	}
	
	public Bonus(int x, int y,  int p_b, int s_b){
		super(x, y, IMAGE_URL, WIDTH, HEIGHT);
		point_bonus = p_b;
		speed_bonus = s_b;
	}
	
	public void animate(){
		frame_counter++;
		if(frame_counter >= 5){
			if(getFrame() < FRAMES)
				setFrame(getFrame() + 1); 
			else
				setFrame(0);
		frame_counter = 0;
		}
	}
	
	public int getPointBonus(){
		return point_bonus;
	}
	
	public void setPointBonus(int n_p){
		point_bonus = n_p;
	}
	
	public int getSpeedBonus(){
		return speed_bonus;
	}
	
	public void setSpeedBonus(int n_s){
		speed_bonus = n_s;
	}
}
