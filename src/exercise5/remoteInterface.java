
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface remoteInterface extends Remote{
    String sayHi() throws RemoteException;
}
