import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import java.awt.Frame;
import java.io.*;
public class Client {
	
	// IP and port
	private static String ip = "localhost";
	private static int port = 3001;
	private static Socket socket;
	public static ObjectOutputStream outputObject;
	public static ObjectInputStream inputObject;
	public static void main(String[] args) {
		LoginView view = new LoginView();
		 view.LaunchView();
		try{
			socket = new Socket(ip, port);
			System.out.println("Socket created");
			
				outputObject = new ObjectOutputStream(socket.getOutputStream());
				inputObject = new ObjectInputStream(socket.getInputStream());
				JSONObject response = new JSONObject();
				outputObject.flush();
				
				while(true) {
					response = (JSONObject) inputObject.readObject();
					System.out.println(response);
					System.out.println("reaching here");
					String name = (String) response.get("username");
					Scrabble.startTheGame(name);
				}

		} catch (UnknownHostException e) {
			System.out.print("Unkown Host");
		} catch (IOException e) {
			System.out.print("Wrong Input");
		} catch (ClassNotFoundException e) {
			System.out.print("Class not found");
			e.printStackTrace();
		}
	}
	//for creating login request
	public void loginRequest(String[] actions) {
		try {
			JSONObject player = new JSONObject();
			player.put("username", actions[0]);
			System.out.print(player.get("username"));
            outputObject.writeObject(player);
            outputObject.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}