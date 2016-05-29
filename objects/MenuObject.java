package objects;

import java.awt.image.BufferedImage;

import graphics.Sprite;

public class MenuObject {
	private Sprite picture;
	private int x;
	private int y; 
	private int width;
	private int height;
	
	public MenuObject(String picName, int ax, int ay, int w, int h){
		picture = new Sprite(picName);
		x = ax;
		y = ay;
		width = w;
		height = h;
	}
	
	public BufferedImage getImage(){
		return picture.getImage();
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
}
