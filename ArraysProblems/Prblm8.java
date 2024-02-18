package ArraysProblems;
/*
 * Write a class Polynomial to perform the following
   	a. Design a constructer to represent a polynomial (of single variable x).
	b. Create a method to addition of polynomials.
	c. Create a method to subtraction of polynomials.
	d. Create a method to multiply of polynomials.
	e. Create a method to find derivative of the polynomial.
 */
class Polynomial{
	int terms;
	int poly[][];
	int res[][];
	Polynomial(int terms){
		this.terms=terms;
		poly=new int [2][terms];
	}
	void add(int poly1[][],int poly2[][]) {
		int poly1_terms=poly1[0].length;
		int poly2_terms=poly2[0].length;
		res=new int[2][poly1_terms+poly1_terms];
		int i = 0,j=0,k=0;
		while(i<poly1_terms && j<poly2_terms) {
			if(poly1[1][i]< poly2[1][j]) {
				res[0][k]= poly2[0][j];
				res[1][k]= poly2[1][j];
				k++;
				j++;
				
			}
			else if(poly1[1][i]> poly2[1][j]) {
				res[0][k]= poly1[0][i];
				res[1][k]= poly1[1][i];
				k++;
				i++;
			}
			else {
				res[0][k]= poly1[0][i]+ poly2[0][j];
				res[1][k]= poly1[1][i];
				k++;
				i++;
				j++;
			}
		}
		if(i<poly1_terms) {
			while(i<poly1_terms) {
				res[0][k]= poly1[0][i];
				res[1][k]= poly1[1][i];
				i++;
				k++;
			}
		}
		else {
			while(j<poly2_terms) {
				res[0][k]= poly1[0][j];
				res[1][k]= poly1[1][j];
				j++;
				k++;
			}
		}
		view(res);
		
	}
	void minus(int poly1[][],int poly2[][]) {
		int poly1_terms=poly1[0].length;
		int poly2_terms=poly2[0].length;
		res=new int[2][poly1_terms+poly1_terms];
		int i = 0,j=0,k=0;
		while(i<poly1_terms && j<poly2_terms) {
			if(poly1[1][i]< poly2[1][j]) {
				res[0][k]= (-poly2[0][j]);
				res[1][k]= (poly2[1][j]);
				k++;
				j++;
				
			}
			else if(poly1[1][i]> poly2[1][j]) {
				res[0][k]= poly1[0][i];
				res[1][k]= poly1[1][i];
				k++;
				i++;
			}
			else {
				res[0][k]= poly1[0][i]- poly2[0][j];
				res[1][k]= poly1[1][i];
				k++;
				i++;
				j++;
			}
		}
		if(i<poly1_terms) {
			while(i<poly1_terms) {
				res[0][k]= poly1[0][i];
				res[1][k]= poly1[1][i];
				i++;
				k++;
			}
		}
		else {
			while(j<poly2_terms) {
				res[0][k]= poly1[0][j];
				res[1][k]= poly1[1][j];
				j++;
				k++;
			}
		}
		view(res);
		
	}
	
	void view(int arr[][]) {
		int n=arr[0].length;
		for(int i=0;i<n;i++) {
			if(arr[0][i]==0)
				continue;
			System.out.print("("+arr[0][i]+")"+"x^"+arr[1][i]+" ");
			if( arr[1][i]!=0)
	            System.out.print("+");
		}
		System.out.println();
		
	}

}

public class Prblm8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int terms=5;
		int arr[][]= {
				{5,7,9},
				{4,1,0}};
		int arr2[][]= {
				{2,4,6,20},
				{4,2,1,0}};
		
		Polynomial obj=new Polynomial(terms);
		obj.view(arr);
		obj.view(arr2);
		obj.add(arr, arr2);
		obj.minus(arr, arr2);
		
		
	}

}


/*
 * (5)x^4 +(7)x^1 +(9)x^0 
(2)x^4 +(4)x^2 +(6)x^1 +(20)x^0 
(7)x^4 +(4)x^2 +(13)x^1 +(29)x^0 +(0)x^0 +(0)x^0 
(3)x^4 +(-4)x^2 +(1)x^1 +(-11)x^0 +(0)x^0 +(0)x^0 

 */