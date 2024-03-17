package Forward_Recursion;
/*
 * Write a recursive function to calculate the power of a two number(consider the degree as a
negative/positive integer).
 * 
 */

public class Prblm3 {
	static double power(double a, int b) {
		if(b==0) return 1;
		else if (b>0) return (a*power(a,b-1));
		else return ((1/a) * power(a,b+1));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(3,-2));
		System.out.println(power(3,2));
		
	}

}
