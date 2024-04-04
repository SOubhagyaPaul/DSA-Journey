package treeProblems;

//Write a recursive function to find the maximum and minimum number is the given list
//that solves this using divide and conquer.

class FindMinMax{
	int find_min(int A[],int n) {
		if(n==1)
			return A[0];
		return Math.min(A[n-1],find_min(A,n-1));
	}
	
	int find_max(int A[],int n) {
		if(n==1)
			return A[0];
		return Math.max(A[n-1],find_max(A,n-1));
	}


}

public class Prblm2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMinMax obj=new FindMinMax();
		int a[]= {12,9,8,6,4,7};
		System.out.println(obj.find_min(a,a.length));
		System.out.println(obj.find_max(a,a.length));
		
	}

}
