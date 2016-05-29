package engine;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;

import org.omg.CORBA.portable.UnknownException;

import graphics.GameView;
import graphics.GameWindow;

public class Client {
	private static Socket socket;
	private static String name;
	private static KeyPressed key;
	private static GameView view;
	
	private class KeyPressed {
		boolean up;
		boolean down;
		boolean left;
		boolean right;
	}

	public Client(GameView v, String n){
		view = v;
		name = n; 
		key = new KeyPressed();
	}
	public Client(GameView v){
		view = v;
		name = "Player";
		key = new KeyPressed();
	}
	
	public void start() throws UnknownException, IOException, ClassNotFoundException{
		socket = new Socket ("localhost", Server.PORT);
		Display display;

		try{
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
			objectOutputStream.writeObject(name);
			while(true){
				Message message = new Message(key.up, key.down, key.left, key.right);
				objectOutputStream.writeObject(message); 
				Message returnMessage = (Message)objectInputStream.readObject();
				display = new Display(view, returnMessage.getMap(), returnMessage.getPlayer());
				display.animateObjects();
				display.showGame();
				
			}
		}catch(ConnectException e){
			System.out.println("Server unreachable"); 
		}catch(SocketException e){
			System.out.println("Server connection lost");
		}
	}

	public void setKeyUp(boolean b){
		key.up= b;
	}
	public void setKeyDown(boolean b){
		key.down = b;
	}
	public void setKeyLeft(boolean b){
		key.left = b;
	}
	public void setKeyRight(boolean b){
		key.right = b;
	}

}
