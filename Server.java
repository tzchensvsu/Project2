// The server class will implement the functions listed in the project description. 

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Server {
    
    int serverPort;
    int MAX_CONNECTED_CLIENTS;
    static ServerSocket listener;
    static int numClients;
    static ArrayList<Connection> connectionList;

    
    public Server(){
        serverPort=5000;
        MAX_CONNECTED_CLIENTS=20;
        listener=null;
        numClients=0;
        connectionList= new ArrayList<Connection>();
    }
    
    public static void main(String args[])
    {
        
        //First, let's start our server and bind it to a port(5000).
       Socket socket;
       
       listener = new ServerSocket(5000);
          
        //Next let's start a thread that will handle incoming connections
              
       ServerSocketHandler connectionHandler = new ServerSocketHandler();
       
       connectionHandler.start();
       
        
        // Note in programs shown in class, at this point we listen for incoming connections in the main method. However for this project since the server has to handle incoming connections and also handle user input simultaneously, we start a separate thread to listen for incoming connections in the Server. This is the ServerSocketHandler thread, which will in turn spawn new Connection Threads, for each client connection.
        
        //Done! Now main() will just loop for user input!.
       ObjectInputStream iStream ;
       
       Socket clientInput = listener.accept();
       
        while (true)
        {
        	try {           
            // wait on user inputs
                iStream = new ObjectInputStream(clientInput.getInputStream());
                
                //Reading incoming Packets
                Packet packet = (Packet) iStream.readObject();
                
        	}
        }
        //will quit on user input
        
    }

    public void printConnection(Packet p) {
    	  System.out.println("Port : " + p.port_number);
          System.out.println("IP: " + p.peerIP);
          System.out.println("Client Connected. Total Registered Clients :" + numClients);
          System.out.println("---------------");
          System.out.println("Peer ID : " + p.peerID);
          System.out.println("FILE_VECTOR : " + p.FILE_VECTOR);
    }
    // add other methods as necessary. For example, you will prbably need a method to print the incoming connection info.
}

