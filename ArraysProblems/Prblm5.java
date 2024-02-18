package ArraysProblems;
/*
 * Write a Class CheckTriangular within that implement methods to check whether a matrix is
i) Lower triangular ii) Upper triangular iii) Diagonal iv) Identity v) Tridiagonal.
 */

class CheckTriangular{
	
	boolean isLowerTriangular(int a[][]) {
		int row=a.length;
		int col=a[0].length;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if( (i>=j && a[i][j]==0)||(i<j && a[i][j]!=0))
					return false;
			}
		}
		return true;
	}
	boolean isUppertriangular(int a[][]) {
		int row=a.length;
		int col=a[0].length;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if( (i>j && a[i][j]!=0)||(i<=j && a[i][j]==0))
					return false;
			}
		}
		return true;
	}
	boolean isDiagonal(int a[][]) {
		int row=a.length;
		int col=a[0].length;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if( (i==j && a[i][j]==0)||(i<j && a[i][j]!=0)||(i>j && a[i][j]!=0))
					return false;
			}
		}
		return true;
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
	boolean isTridiagonal(int a[][]) {
		int row=a.length;
		int col=a[0].length;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if( (Math.abs(i-j)<=1 && a[i][j]==0) ||  (Math.abs(i-j)>1 && a[i][j]!=0))
					return false;
			}
		}
		return true;
	}
	
	
}

public class Prblm5 {

    public static void main(String[] args) {
    	
    	CheckTriangular obj= new CheckTriangular();
    	int[][] mat1 = { { 1, 3, 5, 3 },
                        { 0, 4, 6, 2 },
                        { 0, 0, 2, 5 },
                        { 0, 0, 0, 6 } };
    	System.out.println(obj.isUppertriangular(mat1));
    	
    	int[][] mat2 = {{ 1, 0, 0, 0 },
                		{ 8, 3, 0, 0 },
                		{ 7, 4, 9 ,0 },
                		{ 7, 5, 3, 8 } };
    	System.out.println(obj.isLowerTriangular(mat2));

    	int[][] mat3 = {{ 1, 0, 0, 0 },
                		{ 0, 4, 0, 0 },
                		{ 0, 0, 2, 0 },
                		{ 0, 0, 0, 6 } };
    	System.out.println(obj.isDiagonal(mat3));
    	
    	int[][] mat4 = {{ 1, 0, 0, 0 },
                		{ 0, 1, 0, 0 },
                		{ 0, 0, 1, 0 },
                		{ 0, 0, 0, 1 } };
    	System.out.println(obj.isIdentity(mat4));
    	
    	int[][] mat5 = {{ 1, 3, 0, 0},
                		{ 9, 4, 6, 0 },
                		{ 0, 3, 2, 5 },
                		{ 0, 0, 2, 6 } };
    	System.out.println(obj.isTridiagonal(mat5));

      }
}


/*

true
true
true
true
true

*/