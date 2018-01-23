package jh;

import java.math.BigInteger;
import java.util.Random;

public class PublicKey {

	public static BigInteger P;
	public static BigInteger Q;
	public BigInteger N;
	public static BigInteger M;
	public BigInteger C;
	public BigInteger gcd;

	public PublicKey(){
		PublicKey.P = genererPremier();
		PublicKey.Q = genererPremier();
		this.Substract();
		this.gcd();
	}
	
	public void Substract(){
		byte [] v = {1};
		BigInteger un = new BigInteger(v);
		this.N = P.multiply(Q);
		PublicKey.M = P.subtract(un).multiply(Q.subtract(un));
	}
	
	public void gcd(){
		C = genererNombre();
		gcd = M.gcd(C);
	}
	public static BigInteger genererNombre() {
		BigInteger bi;
		BigInteger Min;
		if (P.compareTo(Q) <= 0)
			Min = Q;
		else
			Min = P;
		do {
		bi = new BigInteger(8, new Random());
		bi = bi.mod(M);
		
		//while (bi.compareTo(P) == 1 && bi.compareTo(Q) == 1)
		//	genererNombre();
		//return bi;
		}while (bi.compareTo(Min)<=0);
		return bi;
	}
	
	public static BigInteger genererPremier() {

		      // create a BigInteger object
		      BigInteger bi;

		      // create and assign value to bitLength
		      int bitLength = 8;

		      // create a random object
		      Random rnd = new Random();

		      // assign probablePrime result to bi using bitLength and rnd
		      // static method is called using class name
		      bi = BigInteger.probablePrime(bitLength, rnd);

		      //String str = "ProbablePrime of bitlength " + bitLength + " is " +bi;

		      // print bi value
		      //System.out.println( str );
		      return bi;
	}

	public String toString(){
		return "P = " + PublicKey.P + " \nQ = " + PublicKey.Q+" \nM = "+PublicKey.M+" \nC = "+this.C+"\nClé publique = ("+this.N+","+this.C+")\n"+this.gcd;
	}

}