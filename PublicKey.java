import java.math.BigInteger;
import java.util.Random;

public class PublicKey {

	public BigInteger P;
	public BigInteger Q;
	public BigInteger M;
	public BigInteger C;

	public PublicKey(){
		this.P = genererPremier();
		this.Q = genererPremier();
		this.M = P.multiply(Q);
	}

	public BigInteger IE(){
		BigInteger M1= P.add(-1);

	}

	public static boolean estPremier(long n) {
		int l = 1;
	    for(int i=2;i<=Math.sqrt(n);i+=l) {
	    	if(i==3){
	    		l=2;
	    	}
	    	System.out.println("i="+i);
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

	public static BigInteger genererPremier() {

		      // create a BigInteger object
		      BigInteger bi;

		      // create and assign value to bitLength
		      int bitLength = 256;

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
		return "P = " + this.P + " \nQ = " + this.Q;
	}
	public static void main(String[] args) {
		long P = 4001L;

		System.out.println(P+" est t-il premier ? "+estPremier(P));
	}
}
