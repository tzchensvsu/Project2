// This thread simply listens for connections on port 5000 and starts a new Connection Thread for each incoming connection
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

class ServerSocketHandler extends Thread
{
    public void run(){
        Socket clientSocket;
        while (true){
           // wait for incoming connectioins. Start a new Connection Thread for each incoming connection.
        	        try {
        	        	
        	        	//Always accpeting Clients     	
        	        	clientSocket = Server.listener.accept();
        	        	
        	        	//.toString() is a built in method to print
        	        	System.out.println("A new Client is Connecting.... " + clientSocket.toString());
        	        	
        	        	//Start a new connections per client
        	        	Connection c = new Connection(clientSocket);
        	        	Server.numClients++;
        	        	c.start();
        	        	
        	        	Server.connectionList.add(c);
        	        	
        	        }
        	    
        }
    }
    
    //other methods may be necessary. Include them when appropriate.

}