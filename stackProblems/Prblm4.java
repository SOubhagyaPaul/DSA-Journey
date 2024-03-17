package stackProblems;
/*
 * Write a method in a separate class to evaluate a prefix expression. (Consider more than single
digit number as a input)
 */

import java.util.StringTokenizer;

class PretfixEvaluate<T extends Number>{
	 boolean isNumeric(String str) { 
		  try {  
		    Float.parseFloat(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	 Float operation(String op, Float x, Float y){
		    if (op.equals("+")){
		        return x + y;
		    } else if (op.equals("-")){
		        return x - y;
		    } else if (op.equals("*")){
		        return x * y;
		    } else if (op.equals("/")){
		        return x / y;
		    }
			return null;
		}
	@SuppressWarnings("unchecked")
	T evaluate(String exp) throws StackOverflowException, StackUnderflowException {
		int size=exp.length();
		
		Stack <Float>s1= new Stack <Float>(size);
		String mydel=" ";
		StringTokenizer str = new StringTokenizer(exp, mydel);
		String strReversedLine = "";
		 
		 while(str.hasMoreTokens())
		 {
		 strReversedLine = str.nextToken() + " " + strReversedLine;
		 }
		 StringTokenizer str_rev = new StringTokenizer(strReversedLine, mydel);
		 
		while(str_rev.hasMoreTokens()) {
			String cur=str_rev.nextToken();
			if(isNumeric(cur)) {
				Float operand=Float.parseFloat(cur);
				s1.push(operand);
			}
			else {
				Float y=s1.pop();
				Float x=s1.pop();
				Float res=operation(cur,x,y);
				s1.push(res);
			}

		}
		return (T) s1.pop();
		
	}
	
}

public class Prblm4 {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		// TODO Auto-generated method stub
		PretfixEvaluate<Integer> ob=new PretfixEvaluate<Integer>();
		String e="+ - 2 7 * 8 / 4 12";
		System.out.println(ob.evaluate(e));
		

	}

}

/*29.0
*/
