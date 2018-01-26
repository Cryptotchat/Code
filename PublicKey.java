import java.math.BigInteger;
import java.util.Random;

public class PublicKey {

	public static BigInteger P;
	public static BigInteger Q;
	public BigInteger N;
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
		this.N = P.multiply(Q);
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
		return "P = " + PublicKey.P + " \nQ = " + PublicKey.Q+" \nM = "+PublicKey.M+" \nClé publique = ("+this.N+","+genererNombre()+")\n"+PublicKey.gcd;
	}

}
