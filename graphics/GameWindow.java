package graphics;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;

import engine.Const;

public class GameWindow extends Canvas{

	private static final long serialVersionUID = 1L;
	private BufferStrategy buffer;
	private JFrame window;
	

	public GameWindow(String name){
		window = new JFrame(name);
		JPanel panel = (JPanel)window.getContentPane();
		setBounds(0,0,Const.W_WIDTH,Const.W_HEIGHT);
		panel.setPreferredSize(new Dimension(Const.W_WIDTH,Const.W_HEIGHT));
		panel.setLayout(null);
		panel.add(this);
		window.setBounds(0,0,Const.W_WIDTH,Const.W_HEIGHT);
		window.setVisible(true);
		window.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				}
			});
		window.setResizable(false);
		createBufferStrategy(2);
		buffer = getBufferStrategy();
		requestFocus();
	}
	
	public BufferStrategy getBuffer(){
		return buffer;
	}
	
	public JFrame getWindow(){
		return window;
	}
}
