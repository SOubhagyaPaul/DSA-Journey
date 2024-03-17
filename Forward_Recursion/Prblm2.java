package Forward_Recursion;
/*
 * Write a recursive function to print the first n Fibonacci numbers.
 */
public class Prblm2 {
	static int fibo(int n) {
		if(n<2) return n;
		else
			return (fibo(n-1)+fibo(n-2));
	}
	public static void main(String[] args) {
		
		System.out.println(fibo(4));
		
	}

}
