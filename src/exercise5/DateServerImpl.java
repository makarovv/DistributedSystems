// this is the server 
// a remote object implementation that implements the remote interface

import java.rmi.*;
import java.rmi.server.*;

public class DateServerImpl extends UnicastRemoteObject implements remoteClub, remoteTeam {
  
  //add internall clubs objs
  private Clubs football;
  private Clubs basketball;
  
  public DateServerImpl () throws RemoteException {
    super();
    this.football = new Clubs("FC");
    this.basketball = new Clubs("bC");

  }
 //Remote Club methods
  @Override
  public Teams search_Team(String name) throws RemoteException {
    System.out.println("Calling search for team");
    return new Teams();
  }

  @Override
  public void addTeam(String name, String sport, String league) throws RemoteException {
    System.out.println("Calling addTeam(" + name + ", " + sport + ", " + league + ")");
    returnClubName().addTeam(name, sport, league);
  }

  @Override
  public String returnClubName() throws RemoteException {
    System.out.println("Getting Club name of team");
    return .search_Team(teamName);
  }

  @Override
  public Teams[] getAllTeams(String clubName) throws RemoteException {
      System.out.println("getAllTeams(" + clubName + ")");
      return resolve(clubName).getAllTeams();
  }

  //RemoteTeams methods
  @Override
  public String getName() throws RemoteException{
    System.out.println("Getting Team name");
    return 
  }
  
  /*
  public Date getDate () throws RemoteException {
    System.out.println("Invocation of getDate()");
    return new Date ();
  }
  */

  public static void main (String[] args) {

    try {
      DateServerImpl dateServer = new DateServerImpl ();

      Clubs football = new Clubs("FC");
      Clubs basketball = new Clubs("BC");

      remoteClub stub = (remoteClub) UnicastRemoteObject.exportObject(dateServer, 1099);
      //remoteTeam stub2 = (remoteTeam) UnicastRemoteObject.exportObject(dateServer, 1099);

      // bind the remote obj into the registry 
      //Naming.rebind ("myObject", dateServer);

      Naming.rebind ("footballObj", stub);
      Naming.rebind("basketballObj", stub);
      System.out.println("Rebinding the two Club objects...");

      System.out.println("The server is up");

      
    } catch (Exception e) {
		  System.out.println("DateServerImpl: " + e.getMessage());
		  e.printStackTrace();
	  }
  }
}
