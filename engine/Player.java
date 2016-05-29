package engine;
import java.io.Serializable;

import objects.Position;
import objects.Vehicle;

public class Player implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private Vehicle vehicle;
	private int points;
	private boolean lost;
	
	public Player(String n, Vehicle v){
		name = n;
		vehicle = v;
		lost = false;
	}
	
	public void setName(String n_name){
		name = n_name;
	}
	public String getName(){
		return name;
	}
	
	public void setPosition(Position n_position){
		vehicle.setPosition(n_position);
	}
	public Position getPosition(){
		return vehicle.getPosition();
	}
	
	public void setSpeed(double n_speed){
		vehicle.setSpeed(n_speed);
	}
	public double getSpeed(){
		return vehicle.getSpeed();
	}
	
	public void hit(){
		vehicle.hit();
	}
	
	public void addPoints(int n_points){
		points += n_points;
	}
	public int getPoints(){
		return points;
	}
	
	public void setVehicle(Vehicle n_vehicle){
		vehicle = n_vehicle;
	}
	public Vehicle getVehicle(){
		return vehicle;
	}
	
	public void setX(int n_x){
		vehicle.getPosition().setX(n_x);
	}
	public int getX(){
		return vehicle.getPosition().getX();
	}
	
	public void setY(int n_y){
		vehicle.getPosition().setY(n_y);
	}
	public int getY(){
		return vehicle.getPosition().getY();
	}
	
	public void setLost(){
		lost = true;
	}
	
	public boolean isLost(){
		return lost;
	}
}
