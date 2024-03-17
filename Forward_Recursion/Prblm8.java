package Forward_Recursion;
/*
 * Write a Program to calculate the length of the string using a recursive function.
 */
public class Prblm8 {
	 static int recLen(String str) 
	    {
	        if (str.equals(""))
	            return 0;
	        else
	            return recLen(str.substring(1)) + 1;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(recLen("soubhagya"));

	}

}
