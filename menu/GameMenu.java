package menu;

import java.util.ArrayList;

import engine.*;
import objects.*;
import graphics.GameView;


public class GameMenu {
	private ArrayList<MenuObject> menu_objects;
	private GameView view;
	private MenuObject back;
	private MenuObject title;
	private MenuObject play;
	private MenuObject exit;
	
	public GameMenu(GameView v){
		view = v;
		menu_objects = new ArrayList<MenuObject>();
		
		back = new MenuObject("menu.png", 0, 0, 450, 800);
		menu_objects.add(back);
		
		title = new MenuObject("title.png", 25, 50, 400, 193);
		menu_objects.add(title);
		
		play = new MenuObject("buttonPlay.png", 50, 400, 350, 110);
		menu_objects.add(play);
		
		exit = new MenuObject("buttonExit.png", 50, 550, 350, 110);
		menu_objects.add(exit);

	}
	
	public void clicked(int mx, int my)
	{
		if(RacingGame.g_state == RacingGame.State.MENU)
		{
			if(mouseOver(mx, my, play.getX(), play.getY(), play.getWidth(), play.getHeight()))
				RacingGame.g_state = RacingGame.State.GAME;
				
			
			if(mouseOver(mx, my, exit.getX(), exit.getY(), exit.getWidth(), exit.getHeight()))
				RacingGame.g_state = RacingGame.State.EXIT;
		}	
	}
	
	public void draw()
	{
		for(MenuObject o : menu_objects)
            view.drawImage(o.getImage(), o.getX(), o.getY());
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width)
            if(my > y && my < y + height)
                return true;
        return false;
    }

}
