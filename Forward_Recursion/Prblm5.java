package Forward_Recursion;
/*
 * Write a recursive function to find the sum of the following series.
(a) S= 2 + 4 + 6 + 8 + . . . . . + N (Input N).
(b) S= 1^2- 3^2+ 5^2- 7^2+ + N (Input N).
(c) S= x3- x3/3 + x3/9 - x3/27 + x3/81 - x3/243 ....(Input X,N).
 */
public class Prblm5 {
	static int series_a(int n) {
		if(n==1) return 2;
		else
			return(2*n+series_a(n-1));
	}
	
	
	static int series_b(int n) {
		if(n==1) return 1;
		else {
			int p=(int)Math.pow(-1,n-1);
			
			return (int) (Math.pow(2*n-1, 2)*p+series_b(n-1));
		}
	}
	static double series_c(int x,int n) {
		if(n==1) return (Math.pow(x,3));
		else {
			int p=(int)Math.pow(-1,n-1);
			int d=(int)Math.pow(3, n-1);
			return (Math.pow(x,3)/d*p+series_c(x,n-1));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(series_a(4));
		System.out.println(series_b(4));
		System.out.println(series_c(3,5));
	}

}
