import java.rmi.RemoteException;
import java.util.Vector;

public class ChatClient extends RemoteException implements ClientInt, Runnable {

    public final static String NDC = "utilisateur";
    public final static String MDP = "1234";
    private String ndc;
    private String mdp;
    private Vector<ChatClient> listeamis;

    public ChatClient(){
        this.ndc = NDC;
        this.mdp = MDP;
    }

    @Override
    public void creationCompte(String ndc, String mdp) throws RemoteException {
        this.ndc = ndc;
        this.mdp = mdp;
    }

    @Override
    public String message(String message) throws RemoteException {
        return message;
    }

    @Override
    public void ajouter(ChatClient a) throws RemoteException {
        listeamis.add(a);
    }

    @Override
    public void run() {

    }
}
