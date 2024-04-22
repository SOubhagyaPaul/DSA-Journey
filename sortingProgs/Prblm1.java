package sortingProgs;

//Write functions for each of the following sorting techniques (show the result after each
//iteration)
//a. Selection
//b. Insertion

class BasicSort<T extends Comparable<T>>{
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
			System.out.println("pass "+(i+1));
			for(int h=0;h<a.length;h++) {
				System.out.println(a[h]);
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
	            System.out.println("pass "+(i+1));
				for(int h=0;h<a.length;h++) {
					System.out.println(a[h]);
				}
	        
	        }
	        System.out.println("Insertion Sort");
	        for(int i=0;i<a.length;i++) {
				System.out.println(a[i]);
			}
	}
}

public class Prblm1 {
	public static void main(String[] args) {
		Integer []arr= {3,4,561,90,35,9};
		BasicSort<Integer> obj= new BasicSort<Integer>();
		obj.SelectionSort(arr);
		obj.InsertionSort(arr);
		
	}

}

/*
 * pass 1
3
4
561
90
35
9
pass 2
3
4
561
90
35
9
pass 3
3
4
9
90
35
561
pass 4
3
4
9
35
90
561
pass 5
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
pass 1
3
4
9
35
90
561
pass 2
3
4
9
35
90
561
pass 3
3
4
9
35
90
561
pass 4
3
4
9
35
90
561
pass 5
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

 * 
 * 
 */
