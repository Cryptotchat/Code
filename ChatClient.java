import java.math.BigInteger;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
 
public class ChatClient  extends UnicastRemoteObject implements ChatClientInt{
	
	private static final long serialVersionUID = 1L;
	private String name = " ";
	private ChatUI ui;	
	private Vector listecontac;
	public ChatClient (String n) throws RemoteException {
		name=n;
		}

	public String toString(){
		return this.name;
	}

	public void tell(String st, BigInteger n, BigInteger u, String a, String m) throws RemoteException{
		System.out.println(st);
		ui.writeMsg(st, n, u, a, m);
	}
	public String getName() throws RemoteException{
		return name;
	}
	
	public void setGUI(ChatUI t){ 
		ui=t ; 
	}

}


