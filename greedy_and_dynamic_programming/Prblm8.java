package greedy_and_dynamic_programming;
/*
 * Given a set of non-negative integers, and a value sum, Write a program to determine if there is a
subset of the given set with sum equal to given sum. Input: set [] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True [ There is a subset (4, 5) with sum 9]
 */
import java.util.*;

public class Prblm8 {
	public static boolean IscontainSubsetSum(int set[],int sum) {
		
		int n=set.length;
		boolean t[][]=new boolean[n+1][sum+1];
		
		for(int i=0;i<n+1;i++) {
			t[i][0]=true;
		}
		for(int i=1;i<sum+1;i++) {
			t[0][i]=false;
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(set[i-1]<=j)
					t[i][j]=t[i-1][j] || t[i-1][j-set[i-1]];
				else
					t[i][j]=t[i-1][j];
			}
		}
		return t[n][sum];
		
	}
	
	
	
	public static int countSubsetSum(int set[],int sum) {
		
		int n=set.length;
		int t[][]=new int[n+1][sum+1];
		
		for(int i=0;i<n+1;i++) {
			t[i][0]=1;
		}
		for(int i=1;i<sum+1;i++) {
			t[0][i]=0;
		}
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<sum+1;j++) {
				if(set[i-1]<=j)
					t[i][j]=t[i-1][j] + t[i-1][j-set[i-1]];
				else
					t[i][j]=t[i-1][j];
			}
		}
		return t[n][sum];
		
	}
	
	public static void main(String [] args) {
		int set[]={3, 34, 4, 12, 5, 2};
		int sum=9;
		int cnt=countSubsetSum(set,sum);
		System.out.println(cnt);
		System.out.println(IscontainSubsetSum(set,sum));
	}
}
