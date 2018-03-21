import java.rmi.*;
 
public class StartServer {
	public static void main(String[] args) {
		try {
				java.rmi.registry.LocateRegistry.createRegistry(10000);
			 	System.out.println( "--");
				ChatServerInt b=new ChatServer();
			 	System.out.println( "--");
				Naming.rebind("rmi://127.0.0.1:10000/myabc", b);
			 	System.out.println( "--");
				System.out.println("[System] pret");
			}catch (Exception e) {
					System.out.println(e);
			}
	}
}
