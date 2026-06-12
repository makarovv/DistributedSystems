
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface remoteClub extends Remote{
    //String sayHi() throws RemoteException; 
    // ^ this was an example from the Oracle Java RMI Documentation
    Teams search_Team(String name) throws RemoteException;
    void addTeam(String name, String sport, String league) throws RemoteException;
    Teams[] getAllTeams() throws RemoteException;
    String returnClubName () throws RemoteException;
}

