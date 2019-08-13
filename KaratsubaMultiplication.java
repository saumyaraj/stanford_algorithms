/**
 * 
 */
package week1;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 * @author szala
 *
 */
public class KaratsubaMultiplication {

	private static Scanner scr;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
scr = new Scanner(System.in);
System.out.println("Enter first number");
BigInteger a = scr.nextBigInteger();
System.out.println("Enter second number");
BigInteger b = scr.nextBigInteger();
Random random = new Random();
BigInteger ans = karatsubaMultiplication(a,b);
System.out.println("Result of multiplication is "+ ans);
}
	
	
	public static BigInteger karatsubaMultiplication(BigInteger first, BigInteger second) {
		int firstOperandLength = first.toString().length();
		int secondOperandLength = second.toString().length();
		if(firstOperandLength > 1 &&  secondOperandLength > 1 && firstOperandLength == secondOperandLength && firstOperandLength %2 == 0) {
			int s = firstOperandLength/2;
			BigInteger a = new BigInteger(first.toString().substring(0, s));
			BigInteger b = new BigInteger(first.toString().substring(s));
			BigInteger c = new BigInteger(second.toString().substring(0, s));
			BigInteger d = new BigInteger(second.toString().substring(s));
			BigInteger ac = karatsubaMultiplication(a,c);
			BigInteger bd = karatsubaMultiplication(b,d);
			BigInteger intermidiate = karatsubaMultiplication(a.add(b),c. add(d)).subtract(ac).subtract(bd);
			return ac.multiply(new BigInteger("10").pow(firstOperandLength)).add(bd).add(intermidiate.multiply(new BigInteger("10").pow(s)));		
		} else {
			return first.multiply(second);
		}
		
	}

}
