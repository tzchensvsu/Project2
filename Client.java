// The client class will implemnet the functions listed in the project description. 
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
import java.lang.*; 

public class Client {

     int serverPort;
     InetAddress ip=null; 
     Socket s; 
     ObjectOutputStream outputStream ;
     ObjectInputStream inputStream ;
     int peerID;
     int peer_listen_port;
     char FILE_VECTOR[];
     

    public static void main(String args[])
    {
        // parse client config and server ip.
    	
    	File file = new File("clientconfig1.txt");
    	
    	Scanner terry = new Scanner(file);
    	
    	Client c = new Client();
    	
    	c.peerID = terry.nextInt();
    	
    	c.serverPort = terry.nextInt();
    	
    	c.peer_listen_port = terry.nextInt();
    	
    	c.FILE_VECTOR = terry.next;
    	
        // create client object and connect to server. If successfull, print success message , otherwise quit.
        try {
        	c.s = new Socket("localhost",5000);
        	System.out.println("Connection Success!");
        }
        // Once connected, send registration info, event_type=0
       // start a thread to handle server responses. This class is not provided. You can create a new class called ClientPacketHandler to process these requests.
       
        //done! now loop for user input
            while (true){
                
               // wait for user commands.
        }
       
    }

 
    // implement other methods as necessary

}
