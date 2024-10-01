package greedy_and_dynamic_programming;
/*
 * Write a program to find out the total number of ways to make change of given amount.
For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1}, {1,1,2}, {2,2}, {1,3}.
So output should be 4. [Infinite Supply of coins]
 */
public class Prblm6_coin_change_maxno_ofways {
	public static int maxWays(int set[],int sum) {
		
		int n=set.length;
		int t[][]=new int[n+1][sum+1];
		
		for(int i=0;i<n+1;i++) {
			t[i][0]=1;
		}
//		for(int i=1;i<sum+1;i++) {
//			t[0][i]=0;
//		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(set[i-1]<=j)
					t[i][j]=t[i-1][j] + t[i][j-set[i-1]];
				else
					t[i][j]=t[i-1][j];
			}
		}
		return t[n][sum];
		
	}
	public static void main(String []args) {
		int S []= {1,2,3};
		int sum=4;
		System.out.println(maxWays(S,sum));
	}
}
