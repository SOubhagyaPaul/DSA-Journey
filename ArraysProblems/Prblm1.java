package ArraysProblems;
/*
 * Create a Class Search within that implement two Generic method LinearSearch(), 
BinarySearch(). Test your program for different data.
 */

class GenSearch<T extends Comparable<T>>{
	
	boolean LinearSearch(T a[], T find){
		for(int i=0;i<a.length;i++) {
			if(a[i].equals(find)) {
				return true;
			}
		}
		return false;
	}
	
	boolean BinarySearch(T a[], T find,int low,int high) {
		
		while(low<=high) {
			int mid=(low+high)/2;
			if(a[mid].compareTo(find)==0)
				return true;
			else if(a[mid].compareTo(find)<0) {
				low=mid+1;
			}
				//BinarySearch(a,find,(mid+1),high);
			else if(a[mid].compareTo(find)>0)
				high=mid-1;
				//BinarySearch(a,find,low,mid-1);

		}
		return false;
	}
}



public class Prblm1 {

	public static void main(String[] args) {
		Integer []arr1= {1,3,4,5,6,8};
		Integer []arr2= {2,3,4,5,6,9,12};
		GenSearch<Integer> obj=new GenSearch<Integer>();
		System.out.println(obj.BinarySearch(arr2,7,0,arr2.length));
		System.out.println(obj.BinarySearch(arr2,12,0,arr2.length));
		System.out.println(obj.LinearSearch(arr1,8));
		System.out.println(obj.LinearSearch(arr1,10));
	
	}
		
}



/*
 * false
true
true
false

 * 
 */






