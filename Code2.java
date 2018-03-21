import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Code {

	private static BigInteger C;
	private static BigInteger N;
	private static BigInteger U;
	private static String A;
	private static String B;
	private final static String wall = "O";

	
	/* -------------------- Récuperation des clés ------------------------------------------------- */
		
	public Code() {
	}

	/* -------------------- CHIFFREMENT ------------------------------------------------- */
	public static String chiffrer(String scan, BigInteger n, BigInteger c) {
		BigInteger N = n;
		BigInteger C = c;
		String m1 = "";
		BigInteger ch1;
		BigInteger ch2;
		for(int i=0;i<scan.length();i++) {
			String m0 = "" + (int)scan.charAt(i);

			ch1 = new BigInteger(m0);
			ch2 = ch1.modPow(C, N);
			m1 = m1+ch2.toString()+wall;

		}

		return m1;
	}

	/* -------------------- DÉCHIFFREMENT ------------------------------------------------- */
	public static String dechiffrer(String de1, BigInteger n, BigInteger u) {
		BigInteger N = n;
		BigInteger U = u;
		String de3 = "";
		String de4 = "";
		BigInteger de2;
		System.out.println("message recu = "+de1);
		
		String[] parts = de1.split(wall);
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
