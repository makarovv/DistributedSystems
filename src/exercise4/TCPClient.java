
import java.io.*;
import java.net.*;

public class TCPClient {
  public static void main (String args[]) {
  // args[0]: Message, currently disabled, only input is the Servername
  // args[1]: Server
  
    try{
		String host = args.length > 0 ? args[0] : "localhost";
		int serverPort = 7896;

		// TODO: init two clubproxy clone objs

		// TODO: add some teams 

		// TODO: for every team t in football grab all the teams and system print em
		
		// TODO: init found teams and search for a football team and then system print
		
		// TODO: same thing with a basketball team

    }catch (UnknownHostException e){
	  System.out.println(" Sock:"+ e.getMessage());
    }catch (EOFException e){ System.out.println(" EOF:"+ e.getMessage());
    }catch (IOException e){ System.out.println(" IO:"+ e.getMessage());}
  }// main
}// class