import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInt extends Remote{

    public void creationCompte(String ndc, String mdp) throws RemoteException;
    public String message(String message) throws RemoteException;
    public void ajouter(ChatClient pseudoAmis) throws RemoteException;

}
