package engine;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import objects.Car;


public class Server {
	public static final int PORT = 1234;
	private int usersConnected;
	private GameEngine gameEng;
	private int lane;
	Server(){
		usersConnected = 0;
		lane = 0;
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Server server = new Server();
		server.runServer();
	}
	
	public void runServer() throws IOException, ClassNotFoundException{		
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("Server ready");
			gameEng = new GameEngine();
			Thread game = new Thread(new Game());
			game.start();
			while(true) {
				Socket clientSocket = serverSocket.accept();	
				usersConnected++; 
				
				Thread tServer = new Thread(new ClientsHandle(clientSocket));
				tServer.start();		
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public class Game implements Runnable{
		public void run(){
			while(true){
				gameEng.makeObjects(100);
				gameEng.updateVehicles();
				try {
				    Thread.sleep(1000);        // za szybko produkuje trzeba go trochę uspokoic random wartosc
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
			}
				
		}
	}
	
	public class ClientsHandle implements Runnable {
		Socket socket;
		ObjectInputStream objectInputStream;
		ObjectOutputStream objectOutputStream;
		
		public ClientsHandle(Socket clientSocket) {
			try{
				socket = clientSocket;
				objectInputStream = new ObjectInputStream(socket.getInputStream());
				objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void run() {
			Message msg;
			String name = "Player";
			try {
				name = (String)objectInputStream.readObject();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Player player = new Player(name, new Car(lane, 0, usersConnected));
			lane++;
			gameEng.addPlayer(player);
			try {
				while ((msg = (Message)objectInputStream.readObject()) != null) {
					gameEng.updatePlayer(player, msg.getUp(), msg.getDown(), msg.getLeft(),  msg.getRight());
					//gameEng.removeObjects(player);
					//gameEng.checkPlayerCollisions(player);
					//gameEng.checkOCollisions(player);
					Map map = gameEng.getMap();
					Message returnMessage = new Message();
					returnMessage.setMap(map);
					returnMessage.setPlayer(player);
					objectOutputStream.writeObject(returnMessage);
					objectOutputStream.reset();
				}
				socket.close();
			}catch(SocketException e){
				System.out.println("is disconnected");
				usersConnected--;
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}

}
