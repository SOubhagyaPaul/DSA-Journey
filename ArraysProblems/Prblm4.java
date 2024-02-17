package ArraysProblems;
/*
 * Write class SparseMatrix to give a compressed storage representation of a sparse matrix and 
also find the transpose of the sparse matrix (from the compressed representation).
 */
//class Element{
//	int r=0;
//	int c=0;
//	int val=0;
//}
class Represent_sparce{
	int row;
	int col;
	int non_zero;
	int sparce[][];
	Represent_sparce(int row, int col, int non_zero){
		this.row=row;
		this.col=col;
		this.non_zero=non_zero;
		sparce=new int[3][non_zero];
	}
	int[][] read(int matrix[][]) {
		int k=0;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(matrix[i][j]!=0) {
					sparce[0][k]=i+1;
					sparce[1][k]=j+1;
					sparce[2][k]=matrix[i][j];
					k++;
				}
			}
		}
		return sparce;
	}
	void trans(int sparse[][]) {
		int row=sparse.length;
		int col=sparse[0].length;
		int k=0;
		int transp[][]=new int[row][col];
		for(int i=0;i<col;i++) {
			transp[0][k]=sparse[1][i];
			transp[1][k]=sparse[0][i];
			transp[2][k]=sparse[2][i];
			k++;
		}
		System.out.println("Row\tcolum\tvalue");
		System.out.println(this.row+"\t"+this.col+"\t"+this.non_zero);
		for(int i=0;i< this.non_zero;i++) {
			System.out.println(transp[0][i]+"\t"+transp[1][i]+"\t"+transp[2][i]);
		}
	}
	
	
	void disp_compact() {
		System.out.println("Row\tcolum\tvalue");
		System.out.println(this.row+"\t"+this.col+"\t"+this.non_zero);
		for(int i=0;i< this.non_zero;i++) {
			System.out.println(sparce[0][i]+"\t"+sparce[1][i]+"\t"+sparce[2][i]);
		}
	}
	
}
public class Prblm4 {

	public static void main(String[] args)
	{
	    //create the grid
	    int row = 4;
	    int col = 5;
	    int matrix[][] =  {  
	            {0 , 0 , 6 , 0 , 9 },  
	            {0 , 0 , 4 , 6 , 0 },  
	            {0 , 0 , 0 , 0 , 0 },  
	            {0 , 1 , 2 , 0 , 0 }};  
	    int sparse[][];
	    Represent_sparce obj=new Represent_sparce(row,col,6);
	    sparse=obj.read(matrix);
	    obj.disp_compact();
	    obj.trans(sparse);
	}

}


/*
 * Row	colum	value
4	5	6
1	3	6
1	5	9
2	3	4
2	4	6
4	2	1
4	3	2
Row	colum	value
4	5	6
3	1	6
5	1	9
3	2	4
4	2	6
2	4	1
3	4	2
 * 
 */
