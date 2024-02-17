package ArraysProblems;
/*
 * Write a Generic method that computes the Second minimum and Second maximum elements 
of an array of type T and returns a pair containing the minimum and maximum value. 
 */
class MinMax<T extends Comparable<T>>{

	@SuppressWarnings("unchecked")
	T minmax[] = (T[])new Comparable [2] ;
	T [] sorting(T a[]) {
		
		boolean flag=false;
		do {
			flag=true;
			for(int i=0;i<a.length-1;i++) {
				if(a[i].compareTo(a[i+1])>0) {
					T temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
					flag=false;
				}
			}
		}while(!flag);
		minmax[0]=a[1];
		minmax[1]=a[a.length-2];
		return minmax;
		
	}
}

public class Prblm3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			@SuppressWarnings("rawtypes")
			Comparable a[];
			MinMax <Integer> ob1=new MinMax<Integer>();
			Integer arr[]= {2,5,22,8,1,-5};
			a=ob1.sorting(arr);
			System.out.println("Second minimum: " + a[1]);
	        System.out.println("Second maximum: " + a[a.length-2]);
			
	}

}


/*
Second minimum: 8
Second maximum: 1

*/
