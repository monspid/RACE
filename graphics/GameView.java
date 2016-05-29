package graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import engine.Const;

public class GameView {

	public long usedTime;
	private GameWindow window;
	private Graphics2D graphics;
	

	public GameView(GameWindow w) {
		window = w;
		graphics = (Graphics2D)window.getBuffer().getDrawGraphics();
	}
	
	public void drawImage(BufferedImage img, int dx, int dy, int dw, int dh, int sx, int sy, int sw, int sh){
		graphics.drawImage(img, dx, dy, dx + dw, dy + dh, sx, sy, sx + sw, sy + sh, window);
	}
	
	public void drawImage(BufferedImage img, int dx, int dy, int frame){
		graphics.drawImage(img, dx, dy, dx + Const.S_WIDTH, dy + Const.S_HEIGHT, frame * Const.S_WIDTH, 0, (frame+1) * Const.S_WIDTH, Const.S_HEIGHT, window);
	}
	
	public void drawImage(BufferedImage img, int dx, int dy){
		graphics.drawImage(img, dx, dy, window);
	}
	
	public void drawText(String txt, int x, int y){
		graphics.setColor(Color.white);
		graphics.drawString(txt,x,y);
	}
	
	public void drawText(String txt, int x, int y, int size, Color color){
		this.setFontSize(size);
		graphics.setColor(color);
		graphics.drawString(txt,x,y);
		this.setFontSizeDefault();
	}
	
	public void setFontSize(int size){
		graphics.setFont(new Font("TimesRoman", Font.PLAIN, size)); 
	}
	public void setFontSizeDefault(){
		graphics.setFont(new Font("default",Font.PLAIN, 12)); 
	}
	
	
	public void fill(){
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, Const.W_WIDTH, Const.W_HEIGHT);
	}
	
	public void show(){
		window.getBuffer().show();
	}
}
