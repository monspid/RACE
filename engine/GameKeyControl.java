package engine;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
 
public class GameKeyControl implements KeyListener {

	private Client game;
	
	public GameKeyControl(Client g){
		game = g;
	}
	
    @Override
    public void keyPressed(KeyEvent e) {
    	switch (e.getKeyCode()) {
			case KeyEvent.VK_UP : game.setKeyUp(true); break;
			case KeyEvent.VK_DOWN : game.setKeyDown(true); break;
			case KeyEvent.VK_LEFT : game.setKeyLeft(true); break;
			case KeyEvent.VK_RIGHT : game.setKeyRight(true); break;
			
			case KeyEvent.VK_W : game.setKeyUp(true); break;
			case KeyEvent.VK_S : game.setKeyDown(true); break;
			case KeyEvent.VK_A : game.setKeyLeft(true); break;
			case KeyEvent.VK_D : game.setKeyRight(true); break;

			case KeyEvent.VK_ESCAPE : RacingGame.g_state = RacingGame.State.MENU; break;
    	}
    }
 
    @Override
    public void keyReleased(KeyEvent e) {
    	switch (e.getKeyCode()) {
			case KeyEvent.VK_UP : game.setKeyUp(false); break;
			case KeyEvent.VK_DOWN : game.setKeyDown(false); break;
			case KeyEvent.VK_LEFT : game.setKeyLeft(false); break;
			case KeyEvent.VK_RIGHT : game.setKeyRight(false); break;
			
			case KeyEvent.VK_W : game.setKeyUp(false); break;
			case KeyEvent.VK_S : game.setKeyDown(false); break;
			case KeyEvent.VK_A : game.setKeyLeft(false); break;
			case KeyEvent.VK_D : game.setKeyRight(false); break;
    	}
    }
 
    @Override
    public void keyTyped(KeyEvent e) {
    	//game.keyPressed(e);
    }

}