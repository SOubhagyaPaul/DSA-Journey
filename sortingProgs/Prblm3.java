package sortingProgs;



/*
Write functions for each of the following sorting techniques
a. Radix
b. Heap sort
*/





public class Prblm3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,1,2,2,5,5,5,3,6,7,7,4,4};
		CountSort ob=new CountSort(arr);
		ob.sort();
		ob.disp();
		System.out.println();
		int arr1[]= {81,91,552,442,590,54,564,399,688,777,79,046,444};
		RadixSort obj=new RadixSort(arr1);
		obj.sort();
		obj.disp();
		System.out.println();
		int arr2[]= {12,54,88,77,5,21};
		HeapSort obj1=new HeapSort(arr2);
		obj1.sort(arr2, arr2.length-1);
		obj1.disp();
	}

}
