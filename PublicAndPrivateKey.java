package okok;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class PublicAndPrivateKey {

	private static BigInteger P;
	private static BigInteger Q;
	private static BigInteger C;
	private static BigInteger N;
	private static BigInteger M;
	private static BigInteger U;
	private static BigInteger gcd;
	private BigInteger bi;
	private BigInteger Min;
	private final static int bit = 64;
	
	public PublicAndPrivateKey(){
		PublicKey();
		PrivateKey();
	}

	/* -------------------- GENERATION CLÉ PUBLIQUE ------------------------------------------------- */
	public void PublicKey() {

		do {
			P = genererPremier();
			Q = genererPremier();
			N = P.multiply(Q);
			M = P.subtract(new BigInteger("1")).multiply(Q.subtract(new BigInteger("1")));

			if (P.compareTo(Q) <= 0)
				Min = Q;
			else
				Min = P;

			bi = new BigInteger(bit, new Random());
			C = bi.mod(M);
			System.out.println("C = "+C);
			gcd = M.gcd(C);

		}while (gcd.compareTo(new BigInteger("1")) != 0 || bi.compareTo(Min)<=0 || bi.compareTo(M)>=0);
		
		// Création du fichier texte pour le programme
		File fichierTexte = new File ("C:\\Users\\admin\\Desktop\\PublicKey.txt");
		FileWriter ecrireFichier;
		
		try{
			// Instanciation de l'objet ecrireFichier qui va écrire dans fichierTexte.txt
			ecrireFichier = new FileWriter(fichierTexte);
			// Écriture d'une chaîne de caractères dans le fichier texte
			String A = N.toString();
			String B = C.toString();
			ecrireFichier.write(A+"\r\n"+B);
			// "Fermeture" du FileWriter
			ecrireFichier.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BigInteger genererPremier() {
		BigInteger p1;
		Random rnd = new Random();
		p1 = BigInteger.probablePrime(bit, rnd);
		return p1;
	}

	/* -------------------- GENERATION CLÉ PRIVÉE ------------------------------------------------- */
	public void PrivateKey() {
		BigInteger x = new BigInteger("0");
		BigInteger y = new BigInteger("1");
		BigInteger m = M;
		BigInteger n = m;
		BigInteger c = C;
		BigInteger lastx = new BigInteger("1");
		BigInteger lasty = new BigInteger("0");
		BigInteger temp;
		do{
			BigInteger q = c.divide(n);
			BigInteger r = c.remainder(n);

			c = n;
			n = r;

			temp = x;
			x = lastx.subtract(q.multiply(x));
			lastx = temp;

			temp = y;
			y = lasty.subtract(q.multiply(y));
			lasty = temp;            

		}while (n.compareTo(new BigInteger("0"))>0);

		if (lastx.compareTo(new BigInteger("0"))<=0) {
			lastx = lastx.subtract(m.multiply(new BigInteger("-1")));
		}
		U = lastx;
		TEST();
		// Création du fichier texte pour le programme
				File fichierTexte = new File ("C:\\Users\\admin\\Desktop\\PrivateKey.txt");
				// Création de "l'écrivain"
				FileWriter ecrireFichier;
				
				try{
					// Instanciation de l'objet ecrireFichier qui va écrire dans fichierTexte.txt
					ecrireFichier = new FileWriter(fichierTexte);
					// Écriture d'une chaîne de caractères dans le fichier texte
					String A = N.toString();
					String B = U.toString();
					ecrireFichier.write(A+"\r\n"+B);
					// "Fermeture" du FileWriter
					ecrireFichier.close();
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

	}

	/* -------------------- TEST DU PROGRAMME ------------------------------------------------- */
	public void TEST() {
		BigInteger BASE = new BigInteger("66");
		BigInteger RES;
		BigInteger RES2;

		RES = BASE.modPow(C, N);
		System.out.println("ch2 = "+RES);
		RES2 = RES.modPow(U,N);
		System.out.println("de2 = " + RES2);
		if (RES2.compareTo(new BigInteger("66")) != 0) {
			PublicKey();
			genererPremier();
			PrivateKey();
		}	
	}

	

	/* -------------------- ToString ------------------------------------------------- */
	public String toString(){
		return "P = " + P + " \nQ = " + Q+" \nM = "+M+" \nClé publique = ("+N+","+C+")\nClé Privé = ("+N+", "+U+")\n";
	}

}
