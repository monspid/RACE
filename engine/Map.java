package engine;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

import graphics.Sprite;
import objects.MapObject;
import objects.Vehicle;

public class Map implements Serializable{
	private static final long serialVersionUID = 1L;
	private Sprite back;
	private Sprite gameOver;
	private int width;
	private ArrayList<MapObject> map_objects;
	private ArrayList<Vehicle> vehicles;
	
	public Map(String b_u, String gOver_u, int w)
	{
		map_objects = new ArrayList<MapObject>(0);
		vehicles = new ArrayList<Vehicle>(0);
		back = new Sprite(b_u);
		gameOver = new Sprite(gOver_u);
		width = w;
	}
	
	public int getWidth(){
		return width;
	}
	public void setWidth(int n_width){
		width = n_width;
	}
	
	public ArrayList<MapObject> getMapObjects(){
		return map_objects;
	}
	
	public MapObject getMapObject(int index){
		return map_objects.get(index);
	}
	
	public void addMapObject(MapObject o){
		map_objects.add(o);
	}
	
	public int getNumberOfObjects(){
		return map_objects.size();
	}
	
	public void removeObject(MapObject o){
		map_objects.remove(o);
	}
	
	public ArrayList<Vehicle> getVehicles(){
		return vehicles;
	}
	
	public MapObject getVehicle(int index){
		return vehicles.get(index);
	}
	
	public void addVehicle(Vehicle v){
		vehicles.add(v);
	}
	
	public void removeVehicle(Vehicle o){
		vehicles.remove(o);
	}
	
	public int getNumberOfVehicles(){
		return vehicles.size();
	}
	
	public BufferedImage getBackImage(){
		return back.getImage();
	}
	
	public BufferedImage getGameOverImage(){
		return gameOver.getImage();
	}
	
	public void setBackImage(String n_img_url){
		back = new Sprite(n_img_url);
	}
}
