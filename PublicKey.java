package jh;

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
		this.Substract();
	}

	public void Substract(){
		byte [] v = {1};
		BigInteger un = new BigInteger(v);
		this.M = P.subtract(un).multiply(Q.subtract(un));
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
		return "P = " + this.P + " \nQ = " + this.Q+" \nM = "+this.M;
	}

}
