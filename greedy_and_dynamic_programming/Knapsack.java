package greedy_and_dynamic_programming;
//Write a program to implement Fractional knapsack and 0/1 knapsack.
import java.util.Arrays;
public class Knapsack {
	static int t[][];
	Knapsack(){}
	Knapsack(int n,int w){
		t=new int[n+1][w+1];
		for (int[] row : t) {
		    Arrays.fill(row, -1);
		}
	}
	public static int recursive_knap(int wt[],int val[],int w,int n ){
		if(w==0 || n==0)
			return 0;
		else if(wt[n-1]<=w)
			return Math.max(val[n-1]+recursive_knap(wt,val,w-wt[n-1],n-1), recursive_knap(wt,val,w,n-1) );
		else
			return recursive_knap(wt,val,w,n-1);
		
	}
	public static int recursive_Memoization_knap(int wt[],int val[],int w,int n ){
		if(w==0 || n==0)
			return 0;
		if(t[n][w]!= -1)
			return t[n][w];
		else if(wt[n-1]<=w)
			return t[n][w]= Math.max(val[n-1]+recursive_knap(wt,val,w-wt[n-1],n-1), recursive_knap(wt,val,w,n-1) );
		else
			return t[n][w]=recursive_knap(wt,val,w,n-1);
		
	}
	
	public static int topDown_knap(int wt[],int val[],int w,int n) {
		for(int i=0;i<n+1;i++)
			t[i][0]=0;
		for(int j=0;j<w+1;j++)
			t[0][j]=0;
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<w+1;j++) {
				if(wt[i-1]<=j) {
					t[i][j]=Math.max(val[i-1]+t[i-1][j-wt[i-1]] , t[i-1][j] );
				}
				else
					t[i][j]=t[i-1][j];
			}
		}
		return t[n][w];
	}
	
	public static void main(String [] args) {
		
		  int profit[] = new int[] { 60, 100, 120 };
	        int weight[] = new int[] { 10, 20, 30 };
	        int W = 50;
	        int n = profit.length;
	        System.out.println(recursive_knap(weight,profit,W,n));
	        Knapsack ob=new Knapsack(3,W);
	        
	        System.out.println(recursive_Memoization_knap(weight,profit, W, n));
	        
	        System.out.println(topDown_knap(weight,profit, W, n));
	}


	

}
