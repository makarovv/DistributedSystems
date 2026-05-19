
import java.io.*;
import java.net.*;

public class TCPServer {
  public static void main (String args[]) {

    // load two clubs objects in here 
    Clubs footballClubs = new Clubs("Football");
    Clubs basketballClubs = new Clubs("Basketball");

    try{
      System.out.println("The Server is running");
	    int serverPort = 7896;
	    ServerSocket listenSocket = new ServerSocket (serverPort);
	    while(true) {
	      Socket clientSocket = listenSocket.accept();
	      System. out.println("New Connection");

        // for every new connection give it also the server-side club objects
	      Connection c = new Connection(clientSocket, footballClubs, basketballClubs);
	    }
    } catch( IOException e) {System.out.println(" Listen :"+ e.getMessage());}

  }// main
}//class


class Connection extends Thread {
  ObjectInputStream in;
  ObjectOutputStream out;
  Socket clientSocket;

  // refer to the server side Clubs
  Clubs footballClubs;
  Clubs basketballClubs;

  public Connection (Socket aClientSocket, Clubs football, Clubs basketball) {
    try {
      clientSocket = aClientSocket;
      footballClubs = football;
      basketballClubs = basketball;

      //change DataOut/InputStream to Object bc we r sending more than just UTF and Strings
      // Output first on both server and client side in order to avoid header infinite deadlock

      out = new ObjectOutputStream ( clientSocket.getOutputStream() );
      in = new ObjectInputStream ( clientSocket.getInputStream() );     
      
      this.start();
    } catch( IOException e) {System.out.println(" Connection:"+ e.getMessage());}
  }

  public void run(){
    try {

      // TODO: read the serialized msg that the client sent via readObject and println what is being received
      Message msg = (Message) in.readObject();

    
      // TODO: if the msg returns a proxyobj that is on the server side set target to club obj else output "unknown obj"
      Clubs target = null;

      //TODO: create a switchcase um zu wissen welche methode angefragt wird(getMethodName) and send result obj back with target.teammethod
      Object[] p = msg.getParams();
      Object result;

      // TODO:send result back via out.writeobj anb flush
      out.writeObject(result);
      out.flush();

	    System.out.println("Sent result: " + result);	  
    } catch( EOFException e) {System.out.println(" EOF:"+ e.getMessage());
    } catch( IOException e) {System.out.println(" IO:"+ e.getMessage());} 
      catch (ClassNotFoundException e)  { System.out.println(" CNF:" + e.getMessage()); }
  }
}