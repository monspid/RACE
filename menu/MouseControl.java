package menu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseControl extends MouseAdapter {
	
	private GameMenu menu;
	
	public MouseControl(GameMenu m) {
		menu = m;
	}
	
	public void mousePressed(MouseEvent e) {
			menu.clicked(e.getX(), e.getY());
	}

}
