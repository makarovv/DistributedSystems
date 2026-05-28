// this is the interface, not server
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

// 1. dont forget to first start the rmiregistry 
// start rmiregistry

// 2. then start the server 

public interface DateServer extends Remote {
  // example of task 1
  public Date getDate () throws RemoteException;

  // Club methods
  public Teams search_Team () throws RemoteException;

  public void addTeam (String name, String sport, String league) throws RemoteException;

  public Teams[] getAllTemas() throws RemoteException;

  public String returnClubName() throws RemoteException;
}