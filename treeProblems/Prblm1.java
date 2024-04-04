package treeProblems;

/*

 * Write functions to implement a solution to Towers of Hanoi problem. Check your

program with number of disks = 0, 1, 2 and 3.

 */

class Towers_of_Hanoi{

	public void toh(int n, char source, char auxilary, char destination) {

		if(n==0) {

			System.out.println("No disk to relocate");

			return;

		}

		if(n==1) {

			System.out.println(source+"-->"+destination);

			return;

		}

		toh(n-1,source,destination,auxilary);

		System.out.println(source+"-->"+destination);

		toh(n-1,auxilary,source,destination);

	}

}

public class Prblm1 {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Towers_of_Hanoi obj=new Towers_of_Hanoi();

		obj.toh(3, 'A', 'B', 'C');

	}



}