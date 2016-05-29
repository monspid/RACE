package engine;

import java.awt.Color;

import graphics.GameView;
import objects.*;

public class Display {
	private Map map;
	private GameView view;
	private Player player;
	
	public Display(GameView v, Map m, Player p){
		view = v;
		player = p;
		map = m;
	}

	
	private void showMapBack(){
		view.drawImage(map.getBackImage(), 0, player.getY() % Const.W_HEIGHT);
		view.drawImage(map.getBackImage(), 0, player.getY() % Const.W_HEIGHT - Const.W_HEIGHT);
	}
	
	private void showMapObjects()
	{
		for(MapObject m : map.getMapObjects()) 
			if(m.getY() - player.getY() < Const.W_HEIGHT)
				view.drawImage(m.getSprite().getImage(), m.getX(), 
							   -(m.getY() - player.getY()) + Const.W_HEIGHT / 2, 
							   m.getFrame()
							   );
	}
	
	public void animateObjects() {
		for(MapObject m : map.getMapObjects()) {
			m.animate();
		}
	}
	
	public void showGameOver(){
		view.drawText("GAME OVER", 150, 300, 30, Color.RED);
	}
	
	public void showGame(){
		showMapBack();
		showMapObjects();
		if(player.isLost())
			showGameOver();
	}
	
	
}

