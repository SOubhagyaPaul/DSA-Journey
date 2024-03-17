package stackProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * Write a method in a separate class to check an expression is valid or not.
 */
class Check_expression{
	
	boolean check(String exp) throws StackOverflowException, StackUnderflowException {
		int size=exp.length();
		
		Stack <String>s= new Stack <String>(size);
		String mydel=" ";
		StringTokenizer str = new StringTokenizer(exp, mydel);
		
		Map<String,String> mapping=new HashMap<String,String>();
		mapping.put(")", "(");
		mapping.put("}", "{");
		mapping.put("]", "[");
		
		while(str.hasMoreTokens()) {
			String temp=str.nextToken();
			if(temp.equals("(") || temp.equals("{") || temp.equals("[")) {
				s.push(temp);
			}
			else if(temp.equals(")") || temp.equals("}") || temp.equals("]")) {
				if(s.isEmpty()) {
					return false;}
				else {
					String poped=s.peak();
					if(poped.equals(mapping.get(temp))) {
						s.pop();
					}
					else
						return false;
				}
			}
		}
		return (s.isEmpty());
	}

}
public class Prblm2 {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		// TODO Auto-generated method stub
		Check_expression ob=new Check_expression();
		String exp1="[ { ( 2 + 5 ) - 8 } * 9 ]";
		String exp2="[ { ( 2 + 5 ) - 8 } * 9 ] { )";
		String exp3="[ ( 2 + 5 ) ] - 8 ]";
		System.out.println("[ { ( 2 + 5 ) - 8 } * 9 ] ->"+ob.check(exp1));
		System.out.println("[ { ( 2 + 5 ) - 8 } * 9 ] { ) ->"+ob.check(exp2));
		System.out.println("[ ( 2 + 5 ) ] - 8 ] ->"+ob.check(exp3));
	}

}
/*

[ { ( 2 + 5 ) - 8 } * 9 ] ->true
[ { ( 2 + 5 ) - 8 } * 9 ] { ) ->false
[ ( 2 + 5 ) ] - 8 ] ->false

*/