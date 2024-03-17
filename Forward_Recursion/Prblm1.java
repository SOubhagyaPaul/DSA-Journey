package Forward_Recursion;

import java.util.Scanner;

/*
 * Write a recursive function to calculate the gcd of two numbers.
 */



public class Prblm1 {
	static int gcd(int n1, int n2) {
	    if (n2 != 0)
	        return gcd(n2, n1 % n2);
	    else
	        return n1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1,n2;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter 1st positive integers: ");
		n1=sc.nextInt();
		System.out.println("Enter 2nd positive integers: ");
		n2=sc.nextInt();
		System.out.println("G.C.D of "+n1+" and "+n2+" is "+gcd(n1,n2));
		sc.close();
	}

}
