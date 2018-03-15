import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class code {

	private static BigInteger C;
	private static BigInteger N;
	private static BigInteger U;
	private static String A;
	private static String B;

	
	/* -------------------- Récuperation des clés ------------------------------------------------- */
	
	public static void recuperationPublicKey() {		
		try
		{
			File f = new File ("D:\\Clément\\Desktop\\PublicKey.txt");
			FileReader fr = new FileReader (f);
			BufferedReader br = new BufferedReader (fr);

			try
			{
				String line = br.readLine();

				if (line != null)
				{							
					A=line;
					line = br.readLine();
				}
				B=line;
				br.close();
				fr.close();
				N = new BigInteger(A);
				C = new BigInteger(B);
			}
			catch (IOException exception)
			{
				System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
			}
		}
		catch (FileNotFoundException exception)
		{
			System.out.println ("Le fichier n'a pas été trouvé");
		}
	}

	public static void recuperationPrivateKey() {

		try
		{
			File f = new File ("D:\\Clément\\Desktop\\PrivateKey.txt");
			FileReader fr = new FileReader (f);
			BufferedReader br = new BufferedReader (fr);

			try
			{
				String line = br.readLine();

				if (line != null)
				{							
					A=line;
					line = br.readLine();
				}
				B=line;
				br.close();
				fr.close();
				N = new BigInteger(A);
				U = new BigInteger(B);
			}
			catch (IOException exception)
			{
				System.out.println ("Erreur lors de la lecture : " + exception.getMessage());
			}
		}
		catch (FileNotFoundException exception)
		{
			System.out.println ("Le fichier n'a pas été trouvé");
		}
	}

	public code() {
	}

	/* -------------------- CHIFFREMENT ------------------------------------------------- */
	public static String chiffrer(String scan) {
		recuperationPublicKey();
		String m1 = "";
		BigInteger ch1;
		BigInteger ch2;
		for(int i=0;i<scan.length();i++) {
			String m0 = "" + (int)scan.charAt(i);

			ch1 = new BigInteger(m0);
			ch2 = ch1.modPow(C, N);
			m1 = m1+ch2.toString()+"O";

		}

		return m1;
	}

	/* -------------------- DÉCHIFFREMENT ------------------------------------------------- */
	public static String dechiffrer(String de1) {
		recuperationPrivateKey();
		String de3 = "";
		String de4 = "";
		BigInteger de2;
		System.out.println("message recu = "+de1);
		
		String[] parts = de1.split("O");
		for (String part: parts) {
		    de2 = new BigInteger(part);
		    de2 = de2.modPow(U,N);
			de3 = de2.toString();
			
			if (de3.length() % 3 != 0)
			{
				de3 = '0' + de3;
			}
			de4 = de4 +de3;
				
		}
		String result = "";
		for (int i = 0; i < de4.length(); i += 3)
		{
			result += (char)(Integer.parseInt(de4.substring(i, i + 3)));
		}
		return result;
	}
}
