package stackProblems;
/*
 * Write a method in a separate class to convert an infix expression to its corresponding postfix
expression.
 */

import java.util.StringTokenizer;

class Intopost<T>{
	boolean assocRtoL(String x) {
		if(x.equals("^"))
			return true;
		return false;
	}
	int pre(String x) {
		if(x.equals("+")||x.equals("-"))
			return 1;
		if(x.equals("*")||x.equals("/"))
			return 2;
		if(x.equals("^"))
			return 3;
		return 0;
	}
	boolean isNumeric(String str) { 
		  try {  
		    Float.parseFloat(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	@SuppressWarnings("unchecked")
	T convert(String exp) throws StackOverflowException, StackUnderflowException {
		Check_expression ob=new Check_expression();
		if(!ob.check(exp))
			return (T) "Invalid exp.";
		
	
		int size=exp.length();
		String postfix="";
		Stack <String>s= new Stack <String>(size);
		String mydel=" ";
		StringTokenizer str = new StringTokenizer(exp, mydel);
		while(str.hasMoreTokens()) {
			String cur=str.nextToken();
			if(isNumeric(cur)) {
				postfix=postfix+" "+cur;
				
			}
			else if(cur.equals("(") || cur.equals(")") || cur.equals("{") ||cur.equals("}") ||cur.equals("[") ||cur.equals("]"))
				continue;
			else if(s.isEmpty()) {
				
				s.push(cur);}
			else {
//				if(pre(cur)>pre(s.peak()))
//					s.push(cur);
//				else
//					postfix=postfix+" "+s.pop();
				if(!assocRtoL(cur)) {
				while (!s.isEmpty() && pre(cur) <= pre(s.peak())) { // Compare precedence
	                postfix = postfix + " " + s.pop();
	            }
				}
	            s.push(cur);
				
			}
			//System.out.println();
			//s.display1();
		}
		while(!s.isEmpty()) {
			//System.out.println(s.pop());
			postfix=postfix+" "+s.pop();}
		return (T) postfix;
	}
}



public class Prblm5 {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		// TODO Auto-generated method stub
		String e="[ { 2 + ( 4 * 6 ) } - ( 9 / 3 ) ]";
		String e2="2 + 4 * 6 - 9 / 3";
		String e3="2 ^ 3 ^ 4";
		String e4="( 1 - 10 / 5 ) * ( 4 / 7 - 5 )";
		Intopost <String> ob=new Intopost<String>();
		System.out.println(ob.convert(e));
		System.out.println(ob.convert(e2));
		System.out.println(ob.convert(e3));
		System.out.println(ob.convert(e4));
		

	}

}
/*
 2 4 6 * + 9 3 / -
 2 4 6 * + 9 3 / -
 2 3 4 ^ ^
 1 10 5 / 4 * 7 / - 5 -


*/