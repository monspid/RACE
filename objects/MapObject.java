package objects;

import java.io.Serializable;

import engine.Const;
import graphics.Sprite;

abstract public class MapObject implements Serializable{
	private static final long serialVersionUID = 1L;
	private Position position;
	private Sprite sprite;							
	private Sprite hit;	
	private int frame;
	private int width;
	private int height;
	
	public MapObject(Position p, String i_u, int w, int h)
	{
		p.setX(p.getX() * Const.S_WIDTH + 16);
		
		position = p;
		sprite = new Sprite(i_u);
		width = w;
		height = h;
	}
	
	public MapObject(int x, int y, String i_u, int w, int h)
	{
		position = new Position(x * Const.S_WIDTH + 16, y);
		sprite = new Sprite(i_u);
		width = w;
		height = h;
	}
	
	public MapObject(int x, int y, String i_u)
	{
		position = new Position(x, y);
		sprite = new Sprite(i_u);
	}
	
	abstract public void animate();
	
	public void hit(){
		sprite = hit;
	}
	
	public Position getPosition(){
		return position;
	}
	
	public void setPosition(Position n_position){
		position = n_position;
	}
	
	public Sprite getSprite(){
		return sprite;
	}
	
	public void setSprite(String n_img_url){
		sprite = new Sprite(n_img_url);
	}
	
	public int getFrame(){
		return frame;
	}
	
	public void setFrame(int n_frame){
		frame = n_frame;
	}
	
	public int getWidth(){
		return width;
	}
	
	public void setWidth(int n_width){
		width = n_width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setHeight(int n_height){
		height = n_height;
	}
	
	public void setX(int n_x){
		getPosition().setX(n_x);
	}
	public int getX(){
		return getPosition().getX();
	}
	
	public void setY(int n_y){
		getPosition().setY(n_y);
	}
	public int getY(){
		return getPosition().getY();
	}
}
