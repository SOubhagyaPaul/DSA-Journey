package stackProblems;
import java.util.StringTokenizer;
/*
 * Write a method in a separate class to evaluate a postfix expression (Consider more than single
digit number as a input).
 */

class PostfixEvaluate<T extends Number>{
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
		Stack <Float>s= new Stack <Float>(size);
		String mydel=" ";
		StringTokenizer str = new StringTokenizer(exp, mydel);
		while(str.hasMoreTokens()) {
			String cur=str.nextToken();
			if(isNumeric(cur)) {
				Float operand=Float.parseFloat(cur);
				s.push(operand);
			}
			else {
				Float y=s.pop();
				Float x=s.pop();
				Float res=operation(cur,x,y);
				s.push(res);
			}
		}
		return (T) s.pop();
		
	}
	
}

public class Prblm3 {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		String e="3.8 5.9 * 6.9 2.7 / + 4.2 -";
		String e1="38 59 * 69 27 / + 42 -";
		PostfixEvaluate<Integer> ob=new PostfixEvaluate<Integer>();
		System.out.println(ob.evaluate(e));
		System.out.println(ob.evaluate(e1));
		
	}

}
/*20.775555
2202.5557
*/