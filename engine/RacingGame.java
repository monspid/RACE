package engine;

import java.io.IOException;

import org.omg.CORBA.portable.UnknownException;

import graphics.*;
import menu.GameMenu;
import menu.MouseControl;

public class RacingGame{
	private GameWindow window;
	private GameView view;
	private Client game;
	private GameMenu menu;
	private MouseControl mouseControl;
	private GameKeyControl keycontrol;
	
	 
	
	public static enum State {MENU, GAME, EXIT};
	
	public static State g_state;
	
	private RacingGame(){
		window = new GameWindow("RacingGame");
		view = new GameView(window);
		
		menu = new GameMenu(view);
		mouseControl = new MouseControl(menu);
		window.addMouseListener(mouseControl);
		
		g_state = State.GAME;
	}
	
	private void wait(int ms){
		if (ms < 0) return;
		try{
			Thread.sleep(ms);
		}		
		catch(InterruptedException e) {}
	}
	
	private void mainLoop() throws UnknownException, ClassNotFoundException, IOException{
		long frameTime = 1;
		long startFrameTime;
		long act_frames = 0, frames = 0;
		long sTime = System.currentTimeMillis();
		while(window.isVisible()){
			startFrameTime = System.currentTimeMillis();
			
			if (g_state == State.GAME){
				game = new Client(view);
				keycontrol = new GameKeyControl(game);
				window.addKeyListener(keycontrol);
				game.start();
			}
			else if (g_state == State.MENU){
				menu.draw();
			}
			else if (g_state == State.EXIT){
				System.exit(0);
			}
			view.drawText("frame_time: " + (double)(frameTime) + "ms", 10, 10);
			view.drawText("FPS: " + act_frames, 10, 30);
			view.show();
			
			
			frames++;
			frameTime = System.currentTimeMillis() - startFrameTime;
			if(System.currentTimeMillis() - sTime > 1000)
			{
				act_frames = frames;
				sTime += 1000;
				frames = 0;
			}
			wait((int)(1000/Const.FPS - frameTime));
			
		}
	}
	
	public static void main(String[] args) throws UnknownException, ClassNotFoundException, IOException {
		RacingGame game = new RacingGame();
		game.mainLoop();
	}
}
