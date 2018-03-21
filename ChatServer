import java.math.BigInteger;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
 
public class ChatServer  extends UnicastRemoteObject implements ChatServerInt{
	
	private Vector v=new Vector();
	private Vector listeclefpublicn = new Vector();
	private Vector listeclefpublicc = new Vector();
	private Vector listeclefpriveeu = new Vector();
	public Vector listenom = new Vector();
	public Vector listedecontact = new Vector();
	
	public ChatServer() throws RemoteException{}
		
	public boolean seConnecter(ChatClientInt client) throws RemoteException{
		System.out.println(client.getName() + "  s'est connecté");
		envoie(client.getName()+ " s'est connecté");
		System.out.println("---");
		v.add(client);
		return true;
	}
	
	public void envoie(String s) throws RemoteException{
	    System.out.println(s);
		for(int i=0;i<v.size();i++){
		    try{
		    	ChatClientInt tmp=(ChatClientInt)v.get(i);
			tmp.tell(s);
		    }catch(Exception e){
		    }
		}
	}

	public Vector estConnecté() throws RemoteException {
		return null;
	}

	public void publicationClé(BigInteger nclr, BigInteger cclr, BigInteger uclr, String nom) throws RemoteException{
			listeclefpublicn.add(nclr);
			listeclefpublicc.add(cclr);
			listeclefpriveeu.add(uclr);
			listenom.add(nom);		
	}

	public Vector getListeclefpublicn() {
		return listeclefpublicn;
	}

	public void setListeclefpublicn(Vector listeclefpublicn) {
		this.listeclefpublicn = listeclefpublicn;
	}

	public Vector getListeclefpublicc() {
		return listeclefpublicc;
	}

	public void setListeclefpublicc(Vector listeclefpublicc) {
		this.listeclefpublicc = listeclefpublicc;
	}
	
	public Vector getListeNom() {
		return listenom;
	}
	
    public void ajoutecontact(String S) {
		for (int i = 0; i < listedecontact.size(); i++) {
		if (S.equals(listedecontact.get(i)));
		System.out.println("contact déja existant");

		}
		listedecontact.add(S);

}}
