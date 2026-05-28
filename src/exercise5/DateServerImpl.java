// this is the server 

import java.rmi.*;
import java.rmi.server.*;
import java.util.Date;

public class DateServerImpl extends UnicastRemoteObject implements DateServer {
  public DateServerImpl () throws RemoteException {
  }

  public Date getDate () throws RemoteException {
    System.out.println("Invocation of getDate()");
    return new Date ();
  }

  public static void main (String[] args) {

    try {
      DateServerImpl dateServer = new DateServerImpl ();

      Clubs football = new Clubs("FC");
      Clubs basketball = new Clubs("BC");

      remoteInterface stub = (remoteInterface) UnicastRemoteObject.exportObject(dateServer, 1099);
      remoteInterface foot = (remoteInterface) UnicastRemoteObject.exportObject((Remote) football, 1099);
      remoteInterface basket = (remoteInterface) UnicastRemoteObject.exportObject((Remote)basketball, 1099);

      // bind the rmote obj into the registry 
      Naming.rebind ("myObject", dateServer);
      Naming.rebind ("footballObj", foot);
      Naming.rebind("basketballObj", basket);

      System.out.println("The server is up");

      
    } catch (Exception e) {
		System.out.println("DateServerImpl: " + e.getMessage());
		e.printStackTrace();
	}
  }
}
