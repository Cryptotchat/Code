import java.math.BigInteger;
import java.util.Random;

public class PublicKey {

	public static BigInteger P;
	public static BigInteger Q;
	public static BigInteger C;
	public static BigInteger N;
	public static BigInteger M;
	public static BigInteger gcd;

	public PublicKey(){
		PublicKey.P = genererPremier();
		PublicKey.Q = genererPremier();
		this.Substract();
	}
	
	public void Substract(){
		byte [] v = {1};
		BigInteger un = new BigInteger(v);
		PublicKey.N = P.multiply(Q);
		PublicKey.M = P.subtract(un).multiply(Q.subtract(un));
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
		System.out.println(bi);
		gcd = M.gcd(bi);
		}while (gcd.compareTo(new BigInteger("1")) != 0 || bi.compareTo(Min)<=0 || bi.compareTo(M)>=0);
		return bi;
	}
	
	public static BigInteger C() {
		return C=genererNombre();
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
	
	public static BigInteger chiffrer() {
		BigInteger ch1 = new BigInteger("66");
		BigInteger ch2;
		ch2 = ch1.modPow(C, N);
		
		return ch2;
	}

	public static BigInteger dechiffrer() {
		BigInteger de1 = new BigInteger("386");
		BigInteger de2;
		de2 = de1.modPow(new BigInteger("4279"),N);
		
		return de2;
	}
	
	/*public static BigInteger trouverU() {
		BigInteger r = PublicKey.gcd;
		BigInteger r2 = PublicKey.M;
		BigInteger u = new BigInteger("1");
		BigInteger u2 = new BigInteger("0");
		BigInteger v = new BigInteger("0");
		BigInteger v2 = new BigInteger("1");
		
		while (r2 != new BigInteger("0"))
			    q = (entier) r/r2
			    rs = r, us = u, vs = v,
			    r = r2, u = u2, v = v2,
			    r2 = rs - q*r2, u2 = us - q*u2, v2 = vs - q*v2
			 Fin tant que
			 return u;
	}*/
	
	

	public String toString(){
		return "P = " + PublicKey.P + " \nQ = " + PublicKey.Q+" \nM = "+PublicKey.M+" \nClé publique = ("+PublicKey.N+","+C()+")\nPGCD = "+PublicKey.gcd;
	}

}


