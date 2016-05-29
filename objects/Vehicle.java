package objects;

abstract public class Vehicle extends MapObject {
	private static final int FRAMES = 0;
	private int max_speed;				//do jakiej predkosci dany pojazd sie rozpedza
	private double speed;

	public Vehicle(int m_s, int x, int y, String i_u, int w, int h){
		super(x, y, i_u, w, h);
		max_speed = m_s;
		speed = max_speed / 5;
	}
	
	public Vehicle(int m_s, Position p, String i_u, int w, int h){
		super(p, i_u, w, h);
		max_speed = m_s;
		speed = max_speed / 5;
	}
	
	public void animate(){
		if(getFrame() < FRAMES)
			setFrame(getFrame() + 1); 
		else
			setFrame(0);
	}
	
	public void update(){
		setY(getY() + (int)speed);
	}

	
	public void setMaxSpeed(int n_max_speed) {
		max_speed = n_max_speed;
	}
	public int getMaxSpeed() {
		return max_speed;
	}
	
	public void setSpeed(double n_speed) {
		if (n_speed <= max_speed && n_speed >= 0)
			speed = n_speed;
	}
	public double getSpeed() {
		return speed;
	}
	
}
