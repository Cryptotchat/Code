import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ChatLancementServeur {

    public final static int DPORT = 10000;

    public ChatLancementServeur(){
        IntGraph graph = new IntGraph();

    }


    public static void main(String[] args){
        try {
            ServerInt server = new Server();
            Registry registry = LocateRegistry.createRegistry(DPORT);
            registry.rebind("client", server); // publie notre instance sous le nom "Add"
            System.out.println("serveur en écoute sur le port : "+DPORT);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
