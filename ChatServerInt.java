import java.math.BigInteger;
import java.rmi.*;
import java.util.*;
 
public interface ChatServerInt extends java.rmi.Remote{
	public boolean seConnecter (ChatClientInt a) throws RemoteException ;
	public Vector estConnecté() throws RemoteException ;
	public void publicationClé( BigInteger ncle, BigInteger ccle, BigInteger ucle, String pseudo) throws RemoteException;
	public Vector<BigInteger> getListeclefpublicc() throws RemoteException;
	public Vector<BigInteger> getListeclefpublicn() throws RemoteException;
	public Vector<BigInteger> getListeclefpriveeu() throws RemoteException;
	public Vector getListeNom() throws RemoteException;
	public void ajoutecontact(String lbNc) throws RemoteException;
	public Vector recupere()throws RemoteException;
	public void envoie(String st, String a, String d) throws RemoteException;
	public void ajouter(ChatClientInt a) throws RemoteException;

	public void affiche() throws RemoteException;
}
