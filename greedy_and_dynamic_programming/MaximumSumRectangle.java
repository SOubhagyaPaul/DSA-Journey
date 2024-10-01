package greedy_and_dynamic_programming;

import java.util.Arrays;

public class MaximumSumRectangle {
	public static int kadane(int arr[]) {
		int maxsum=0;
		int cursum=0;
		for(int i=0;i<arr.length;i++) {
			cursum+=arr[i];
			if(cursum>maxsum)
				maxsum=cursum;
			if(cursum<0)
				cursum=0;	
		}
		return maxsum;
	}
	
	public static int maxsumRec(int arr[][]) {
		int r=arr.length;
		int c=arr[0].length;
		int maxsum=Integer.MIN_VALUE;
		int sum[]=new int[c];
		for(int j=0;j<c;j++) {
			Arrays.fill(sum, 0);
			for(int i=j;i<c;i++) {
				for(int row=0;row<r;row++) {
					sum[row]+=arr[row][i];
				}
				maxsum=Math.max(maxsum, kadane(sum));
			}
		}
		return maxsum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][]= {
				{1,2,-1,-4,-20},
				{-8,-3,4,-2,1},
				{3,8,9,1,3},
				{-4,-1,1,7,-6},
				{-2,-3,8,1,-1}
				};
		System.out.println(maxsumRec(arr));
		
	}

}
