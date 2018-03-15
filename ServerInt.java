import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInt extends Remote{

    public void estConnecte() throws RemoteException;
    public void messageEnvoye(String msg) throws RemoteException;
    public void seConnecte(ClientInt a) throws RemoteException;

}
