package greedy_and_dynamic_programming;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Write programs to traverse a given graph using
i) Depth First Search (DFS)
ii) Breadth First Search (BFS)
 */

class BFS{
	int g[][];
	int visited[];
	Queue <Integer> q;
	int start;
	BFS(int g[][],int start){
		this.g=g;
		visited=new int[g.length];
		this.start=start;
		q= new LinkedList<Integer>();
	}
	void traves() {
		q.add(start);
		visited[start]=1;
		System.out.println(start+" ");
		while(!q.isEmpty()) {
			int v=q.remove();
			for(int i=0;i<g.length;i++) {
				if(g[i][v]==1 && visited[i]==0) {
					visited[i]=1;
					q.add(i);
					System.out.println(i+" ");
				}
					
			}
		}
		
	}	
}


class DFS{
	Stack<Integer>s;
	int visited[];
	int matrix[][];
	int start;
	DFS(int matrix[][],int start){
		this.matrix=matrix;
		this.start=start;
		visited=new int[matrix.length];
		s=new Stack<>();
	}
	void traverse() {
		dfs(matrix,visited,matrix.length,start);
	}
	private void dfs(int matrix[][],int visited[],int n,int r){
		 visited[r]=1;
		 System.out.println(" "+r);
		 for(int i=0;i<n;i++)
			 if(matrix[r][i]==1 && visited[i]==0)
				 dfs(matrix,visited,n,i);
				 
	}
}

public class Prblm1 {
	public static void main(String[] args) {
		int matrix[][]= {{0,1,0,1,0,0,0},
						{1,0,0,1,0,1,1},
						{0,1,0,1,1,1,0},
						{1,1,1,0,1,0,0},
						{0,0,0,1,1,0,0},
						{0,1,1,0,0,0,0},
						{0,1,0,0,0,0,0}
				};
		BFS obj=new BFS(matrix,0);
		System.out.println("BFS traversal.");
		obj.traves();
		DFS obj1=new DFS(matrix,0);
		System.out.println("DFS traversal.");
		obj1.traverse();
	}
}
