package sortingProgs;
/*
Write functions for each of the following sorting techniques
a. Quick
b. Merge
*/


public class Prblm2 {

	public static void main(String[] args) {
		int []a= {53,44,35,26,17,9};
		System.out.println("Quick Sort");
		QuickSort obj=new QuickSort();
		obj.quick(a, 0, a.length-1);
		obj.disp(a);
		
		System.out.println("Merge Sort");
		MargeSort ob2=new MargeSort();
		ob2.sort(a, 0, a.length-1);
		ob2.disp(a);
	}

}
