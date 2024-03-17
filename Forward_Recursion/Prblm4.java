package Forward_Recursion;
/*
 * Write a recursive function to calculate the sum of all digits of a number entered by the user.
 */
public class Prblm4 {
	static int sum=0;
	static int sum_digit(int digit) {
		if(digit==0) return sum;
		 return (digit % 10 + sum_digit(digit / 10));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(sum_digit(98));
		System.out.println(sum_digit(68));
		
	}

}
