package Forward_Recursion;
/*
 * Write a Program to reverse an array using a recursive function.
 * 
 */
public class Prblm7 {
	static int [] reverse(int arr[],int low, int high) {
		if(low>=high) return arr;
		int temp=arr[low];
		arr[low]=arr[high];
		arr[high]=temp;
		return reverse(arr,low+1, high-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,3,4,5,6,3,5};
		int rev[];
		rev=reverse(arr,0,arr.length-1);
		for(int i=0;i<rev.length;i++)
			System.out.println(rev[i]);

	}

}
