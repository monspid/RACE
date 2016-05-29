package objects;

import java.io.Serializable;

public class Position implements Serializable{
	private static final long serialVersionUID = 1L;
	private int x_pos;
	private int y_pos;
	
	public Position(){
	}
	
	public Position(int x, int y){
		x_pos = x;
		y_pos = y;
	}
	
	public void setX(int n_x_pos){
		x_pos = n_x_pos;
	}
	public int getX(){
		return x_pos;
	}
	
	public void setY(int n_y_pos){
		y_pos = n_y_pos;
	}
	public int getY(){
		return y_pos;
	}
}
