package ArraysProblems;
import java.util.Arrays;

/*
 * Write a program to find whether a matrix is orthogonal or not. Also find the 1-norm of the
matrix.
 */
class MatrixNorm{
	int one_norm(int matrix[][]) {
		int row=matrix.length;
		int col=matrix[0].length;
		int sum[]=new int[col];
		for(int i=0;i<col;i++) {
			int temp=0;
			for(int j=0;j<row;j++) {
				temp+=matrix[j][i];
			}
			sum[i]=temp;
		}
		Arrays.sort(sum);
		return sum[sum.length-1];
	}
}
class CheckOrtho{
	
	int [][] transpose(int matrix[][]){
		int row=matrix.length;
		int col=matrix[0].length;
		int res[][]=new int[col][row];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				res[j][i]=matrix[i][j];
			}
		}
		return res;
		
	}
	boolean isIdentity(int a[][]) {
		int row=a.length;
		int col=a[0].length;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if( (i==j && a[i][j]!=1)||(i<j && a[i][j]!=0)||(i>j && a[i][j]!=0))
					return false;
			}
		}
		return true;
	}
	
	boolean orthogonal(int matrix[][]) {
		int row=matrix.length;
		int col=matrix[0].length;
		int n=row;
		if(row!=col)
			return false;
		int trans[][]=transpose(matrix);
		int product[][]=new int[row][col];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int sum=0;
				for(int k=0;k<n;k++) {
					sum=sum+matrix[i][k]*trans[j][k];
					
				}
				product[i][j]=sum;
			}
		}
		if(isIdentity(product))
			return true;
		return false;
	}
}

public class Prblm6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]a = {{1, 0, 0},
                	{0, 1, 0},
                	{0, 0, 1}};
	
		CheckOrtho obj=new CheckOrtho();
		
		System.out.println(obj.orthogonal(a));
		
		MatrixNorm ob=new MatrixNorm();
		int[][] mat2 = {{ 1, 24,8, 1 },
        				{ 8, 3, 7, 7 },
        				{ 7, 4, 9 ,55 },
        				{ 7, 5, 3, 8 } };
		System.out.println(ob.one_norm(mat2));
	}

}

/*
 * true
71

 */
