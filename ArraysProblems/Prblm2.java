package ArraysProblems;

/*
 * Create a Class BasicSort within that implement three Generic methods that can implement the 
BuubleSort(), SelectionSort(), InsertionSort() that can sort of any type of data.
 */

class BasicSort<T extends Comparable<T>>{
	void BuubleSort(T a[]) {
		for(int i=0;i<a.length-1;i++) {
			for(int j=0;j<a.length-1-i;j++) {
				if(a[j].compareTo(a[j+1])>0) {
					T temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		System.out.println("Buble Sort");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
	void SelectionSort(T a[]) {
		for(int i=0;i<a.length-1;i++) {
			int min=i;
			for(int j=i+1;j<a.length;j++) {
				if(a[j].compareTo(a[min])<0)
					min=j;
			}
			if(min!=i) {
				T temp=a[min];
				a[min]=a[i];
				a[i]=temp;
			}
		}
		System.out.println("Selection Sort");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
	void  InsertionSort(T a[]) {
		 int n = a.length;  
	        for (int j = 1; j < n; j++) {  
	            T key = a[j];  
	            int i = j-1;  
	            while ( (i > -1) && ( a[i].compareTo(key) > 0 ) ) {  
	                a[i+1] = a [i];  
	                i--;  
	            }  
	            a[i+1] = key;  
	        }
	        System.out.println("Insertion Sort");
	        for(int i=0;i<a.length;i++) {
				System.out.println(a[i]);
			}
	}
}

public class Prblm2 {
	public static void main(String[] args) {
		Integer []arr= {3,4,561,90,35,9};
		BasicSort<Integer> obj= new BasicSort<Integer>();
		obj.BuubleSort(arr);
		obj.SelectionSort(arr);
		obj.InsertionSort(arr);
		
	}

}

/*
 * Buble Sort
3
4
9
35
90
561
Selection Sort
3
4
9
35
90
561
Insertion Sort
3
4
9
35
90
561

 */
