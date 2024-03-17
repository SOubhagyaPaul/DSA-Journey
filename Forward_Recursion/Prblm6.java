package Forward_Recursion;
/*
 * Write a Program to implement Binary Search using a recursive function.
 */

public class Prblm6 {
	static boolean bin_search(int a[],int find,int low, int high) {
		if(high>=low && low<a.length) {
		int mid=(low+high)/2;
		if(a[mid]==find) return true;
		if (a[mid]<find)
			return bin_search(a,find,mid+1,high);
		return bin_search(a,find,low,mid-1);
		}
		return false;
		
	}
	public static void main(String[] args) {
		int a[]= {12,34,55,66,88,98,134};
		System.out.println(bin_search(a,3,0,a.length));
		System.out.println(bin_search(a,134,0,a.length));
		System.out.println(bin_search(a,55,0,a.length));
		

	}

}
