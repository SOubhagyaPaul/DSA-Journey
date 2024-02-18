package ArraysProblems;

/*
 * Create a program with multi-dimensional List to store customer details (customerId,customerName, customerCity).
This program to search the customer based on the customerName from a given array.
Note: use Binary search and Insertion sort algorithm.
 	  Create a constructor to initialize size of customer details for five customers.
      Create customer method which takes the array of customer elements (sorted as a customerName).
      Create a method to getCustomer(customerId) method which will return the customer details as a List.
      Create a method to sortCustomer() method which will return the array in a sorted order based on customer city.
 
*/

class Customer_details{
	int size;
	String c_arr[][];
	Customer_details(int size){
		this.size=size;
		c_arr=new String[size][3];
	}
	void customer(String arr[][]) {
		int n=arr.length;
		for(int j=1;j<n;j++) {
			String key=arr[j][1];
			String key0=arr[j][0];
			String key2=arr[j][2];

			int i=j-1;
			while( (i>-1)&& (arr[i][1].compareTo(key)>0) ) {
				arr[i+1][0]=arr[i][0];
				arr[i+1][1]=arr[i][1];
				arr[i+1][2]=arr[i][2];
				i--;
			}
			arr[i+1][0]=key0;
			arr[i+1][1]=key;
			arr[i+1][2]=key2;
		}
		c_arr=arr;
		for(int i=0;i<c_arr.length;i++) {
				System.out.println("customer id :"+c_arr[i][0]+" custome name :"+c_arr[i][1]+" customer address :"+c_arr[i][2]);
		}
	}
	
	void sortCustomer(String arr[][]) {
		int n=arr.length;
		for(int j=1;j<n;j++) {
			String key=arr[j][2];
			String key0=arr[j][0];
			String key1=arr[j][1];

			int i=j-1;
			while( (i>-1)&& (arr[i][2].compareTo(key)>0) ) {
				arr[i+1][0]=arr[i][0];
				arr[i+1][1]=arr[i][1];
				arr[i+1][2]=arr[i][2];
				i--;
			}
			arr[i+1][0]=key0;
			arr[i+1][2]=key;
			arr[i+1][1]=key1;
		}
		c_arr=arr;
		for(int i=0;i<c_arr.length;i++) {
				System.out.println("customer id :"+c_arr[i][0]+" custome name :"+c_arr[i][1]+" customer address :"+c_arr[i][2]);
		}		
	}
	String[] getCustomer(String a[][], String find,int low,int high) {
		while(low<=high) {
			int mid=(low+high)/2;
			if(a[mid][0].compareTo(find)==0) {
				String res[]={a[mid][0],a[mid][1],a[mid][2]};
				return res;
			}
			else if(a[mid][0].compareTo(find)<0) {
				low=mid+1;
			}
			else if(a[mid][0].compareTo(find)>0)
				high=mid-1;
		}
		return null;
	}
}
public class Prblm7 {

	public static void main(String[] args) {
	
		Customer_details obj=new Customer_details(5);
		String[][] cus= {
				{"0","ram","khaikhali"},
				{"1","raja","rajarhat"},
				{"2","varun","birati"},
				{"3","sumon","aiirport"},
				{"4","ratan","kolkata"},
		};
		obj.customer(cus);
		String a[];
		a=obj.getCustomer(cus,"4", 0, 4);
		System.out.println(a[0]+" "+a[1]+" "+a[2]);
		
		obj.sortCustomer(cus);
		
	}

}





/*
 * customer id :1 custome name :raja customer address :rajarhat
customer id :0 custome name :ram customer address :khaikhali
customer id :4 custome name :ratan customer address :kolkata
customer id :3 custome name :sumon customer address :aiirport
customer id :2 custome name :varun customer address :birati
4 ratan kolkata
customer id :3 custome name :sumon customer address :aiirport
customer id :2 custome name :varun customer address :birati
customer id :0 custome name :ram customer address :khaikhali
customer id :4 custome name :ratan customer address :kolkata
customer id :1 custome name :raja customer address :rajarhat
 */



