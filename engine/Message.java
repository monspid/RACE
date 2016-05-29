package engine;

import java.io.Serializable;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	private Map map;
	private Player player;

	private int number;
	
	public Message(boolean u, boolean d, boolean l, boolean r){
		up = u;
		down = d;
		left = l;
		right = r;
	}
	
	public Message(){
		up = down = left = right = false;
	}
	
	public boolean getUp(){
		return up;
	}
	
	public boolean getDown(){
		return down;
	}
	
	public boolean getLeft(){
		return left;
	}
	
	public boolean getRight(){
		return right;
	}
	
	public void setMap(Map m){
		map = m;
	}
	
	public Map getMap(){
		return map;
	}
	
	public void setPlayer(Player p){
		player = p;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public void setNumber(int n){
		number = n;
	}
	
	public int getNumber(){
		return number;
	}
}
