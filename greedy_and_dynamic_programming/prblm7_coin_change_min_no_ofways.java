package greedy_and_dynamic_programming;
/*
 * Write a program to find out the minimum no of coins to make change of given amount
For example, for N = 10 and S = {1,5,6,9}, there are two solutions: {5,5},{1,9} So output should
be 2. [Infinite Supply of coins]
 */
public class prblm7_coin_change_min_no_ofways {

	
	
	public static int min_no_ways(int set[],int sum) {
		int n=set.length;
		int t[][]=new int [n+1][sum+1];
		
		for(int i=0;i<sum+1;i++) {
			t[0][i]=Integer.MAX_VALUE-1;
		}
		for(int i=0;i<n+1;i++)
			t[i][0]=1;
		
		for(int i=1,j=1;j<sum+1;j++) {
			if(j%set[0]==0)
				t[i][j]=j/set[0];
			else
				t[i][j]=Integer.MAX_VALUE-1;
		}
		for(int i=2;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(set[i-1]<=j)
					t[i][j]=Math.min(t[i][j-set[i-1]]+1, t[i-1][j]);
				else
					t[i][j]=t[i-1][j];
			}
		}
		return t[n][sum];
	}
	public static void main(String[] args) {
		int S[] = {1,5,6,9};
		int sum=10;
		System.out.println(min_no_ways(S,sum));
	}
}
