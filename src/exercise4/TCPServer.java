
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
  Clubs footballClubs = new Clubs("FC Europe");
  Clubs basketballClubs = new Clubs("BC America");

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

      // read the serialized msg that the client sent via readObject and println what is being received
      Message msg = (Message) in.readObject();
      System.out.println("Call: " + msg.getproxyObj() + " " + msg.getMethodName());
    
      // if the msg returns a proxyobj that is on the server side set target to club obj else output "unknown obj"
      Clubs target = null;
      if ("football".equals(msg.getproxyObj()))
        target= footballClubs;
      if ("basketball".equals(msg.getproxyObj()))
        target = basketballClubs;

      if(target == null){
        out.writeObject("Club not found");
        out.flush();
        return;
      }

      // create a switchcase um zu wissen welche methode angefragt wird(getMethodName) and send result obj back with target.teammethod
      Object[] p = msg.getParams();
      Object result = new Object();

      switch (msg.getMethodName()) {
        case "addTeam":
          target.addTeam((String) p[0], (String) p[1], (String) p[2]);
          result = "Method addTeam called";
          break;
        case "search_Team":
          target.search_Team((String)p[0]);
          result = "Method search_Team called";
        break;
        case "getAllTeams":
          target.getAllTeams();
          result = "Method getAllTeams called";
        break;
        case "returnClubName":
          target.returnClubName();
          result = "Method returnClubName called";
        break;
        default: System.out.println("Invalid Method chosen");
          break;
      }

      // send result back via out.writeobj anb flush
      out.writeObject(result);
      out.flush();

      System.out.println("Send Result: " + result);

    } catch( EOFException e) {System.out.println(" EOF:"+ e.getMessage());
    } catch( IOException e) {System.out.println(" IO:"+ e.getMessage());} 
      catch (ClassNotFoundException e)  { System.out.println(" CNF:" + e.getMessage()); }
  }
}