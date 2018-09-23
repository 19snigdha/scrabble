
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import javax.net.ServerSocketFactory;

import org.json.simple.JSONObject;


public class Server {
	
	private static int port= 3001;
	private static int clientCounter = 0;
	public static void main(String[] args) {
		
		ServerSocketFactory sfactory = ServerSocketFactory.getDefault();
		try(ServerSocket server = sfactory.createServerSocket(port)){
			System.out.println("Waiting for client connection..");
			
			// Wait for connections.
			while(true){
				Socket client = server.accept();
				clientCounter++;
				System.out.println("Client "+clientCounter+": Connecting!!");
	            ObjectInputStream inputObject = new ObjectInputStream(client.getInputStream());
	            ObjectOutputStream outputObject = new ObjectOutputStream(client.getOutputStream());
	            JSONObject username;
	            username = (JSONObject) inputObject.readObject();
	            System.out.println("Client "+username+": joined!");
	            outputObject.writeObject(username);
//				Thread t = new Thread(new ClientHandler(client,clientCounter, dictionary));
//				t.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

		
	}
	