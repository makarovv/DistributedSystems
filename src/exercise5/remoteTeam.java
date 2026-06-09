import java.rmi.RemoteException;

public interface remoteTeam {
    String getName() throws RemoteException;
    String getLeague() throws RemoteException;
    String getSport() throws RemoteException;
    String setLeague(String league) throws RemoteException;
}
