import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements ServerInt {
    protected Server() throws RemoteException {
    }

    @Override
    public void estConnecte() throws RuntimeException {
        int a = 0;
        a++;
    }

    @Override
    public void messageEnvoye(String msg) throws RuntimeException {

    }

    @Override
    public void seConnecte(ClientInt a) throws RemoteException {

    }

    public String toString(){
        return " vonnecté";
    }
}
