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
	
	public void tell(String st) throws RemoteException{
		System.out.println(st);
		ui.writeMsg(st);
	}
	public String getName() throws RemoteException{
		return name;
	}
	
	public void setGUI(ChatUI t){ 
		ui=t ; 
	}
	
	public void recupereContact() {
		
	}


}

