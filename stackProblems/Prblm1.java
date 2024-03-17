package stackProblems;

import java.util.Scanner;

/*
Write a program to implement a Stack class (use a Array to store the elements of the stack).
[Implement Stack Overflow and Underflow by user defined Exception]. Write a method to
check two stack are carrying similar elements or not.(Repetition of the elements are not
consider)*/
class StackOverflowException extends Exception{
	StackOverflowException(String e){
		super(e);
	}
}
class StackUnderflowException extends Exception{
	StackUnderflowException(String e){
		super(e);
	}
}

class Stack<T>{
	int size;
	int top;
	T arr[];
	@SuppressWarnings("unchecked")
	Stack(int size){
		top=-1;
		this.size=size;
		arr= (T[]) new Object[size];
	}
	boolean isFull() {
		return top==size-1;	
	}
	boolean isEmpty() {
		return top==-1;
	}
	void push(T n) throws StackOverflowException {
		if(isFull()) {
			throw new StackOverflowException("The stack is in overflow condition");
		}
		else
			arr[++top]=n;
	}
	public T pop()throws StackUnderflowException{
		if(isEmpty()){
			throw new StackUnderflowException("The stack is in underflow condition");
		}
		else
			return arr[top--];
	}
	public T peak() throws StackUnderflowException{
		if(isEmpty()){
			throw new StackUnderflowException("The stack is in underflow condition");
		}
		else
			return arr[top];
	}
	public void equalStack(Stack<?> s2 ){
		if(this.top==s2.top){
			this.display1();
			s2.display1();
		}
	}
	public void display1(){
		System.out.println("The stack view in LIFO manner: ");
		for(int i=this.top;i>=0;i--){
			System.out.print(arr[i]+"\t");
		}
	}
}





public class Prblm1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the size of 1st stack : ");
		int n=sc.nextInt();
		Stack<Integer> s1=new Stack<Integer>(n);
		System.out.println("Enter the size of 2nd stack : ");
		int n1=sc.nextInt();
		Stack<Integer> s2=new Stack<Integer>(n1);
		int x=0;
		while(true)
		{
			if(x==1)
				break;
			System.out.println("Enter 1 for push or pop into stack 1  ");
			System.out.println("Enter 2 for push or pop into stack 2  ");
			System.out.println("Enter 3 to display   ");
			System.out.println("Enter 4 to stop   ");
			
			if((s1.top!=-1) && (s2.top!=-1) && (s1.top==s2.top)) {
				s1.display1();
				s2.display1();
			}
			int ch= sc.nextInt();
			switch(ch){
			case 1: {
				System.out.println("Enter 1 for push  into stack 1  ");
				System.out.println("Enter 2 for pop into stack 1  ");
				int p=sc.nextInt();
				switch(p){
				case 1: {
					System.out.println("Enter the value for push ");
					Integer val=sc.nextInt();
					try {
						s1.push(val);
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 2: 
					try {
						s1.pop();
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			}
				
			case 2:{
				System.out.println("Enter 1 for push  into stack 2 : ");
				System.out.println("Enter 2 for pop into stack 2 : ");
				int p=sc.nextInt();
				switch(p){
				case 1: {
					System.out.println("Enter the value for push: ");
					int val=sc.nextInt();
					try {
						s2.push(val);
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 2: 
					try {
						s2.pop();
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			}
			case 3:{
				s1.display1();
				s2.display1();
				break;
			}
			case 4:
				x=1;
				break;

			}
		}
		sc.close();
	}

}


/*
 * Enter the size of 1st stack : 
3
Enter the size of 2nd stack : 
3
Enter 1 for push or pop into stack 1  
Enter 2 for push or pop into stack 2  
Enter 3 to display   
Enter 4 to stop   
1
Enter 1 for push  into stack 1  
Enter 2 for pop into stack 1  
1
Enter the value for push 
88
Enter 1 for push or pop into stack 1  
Enter 2 for push or pop into stack 2  
Enter 3 to display   
Enter 4 to stop   
1
Enter 1 for push  into stack 1  
Enter 2 for pop into stack 1  
1
Enter the value for push 
99
Enter 1 for push or pop into stack 1  
Enter 2 for push or pop into stack 2  
Enter 3 to display   
Enter 4 to stop   
2
Enter 1 for push  into stack 2 : 
Enter 2 for pop into stack 2 : 
1
Enter the value for push: 
98
Enter 1 for push or pop into stack 1  
Enter 2 for push or pop into stack 2  
Enter 3 to display   
Enter 4 to stop   
2
Enter 1 for push  into stack 2 : 
Enter 2 for pop into stack 2 : 
1
Enter the value for push: 
87
Enter 1 for push or pop into stack 1  
Enter 2 for push or pop into stack 2  
Enter 3 to display   
Enter 4 to stop   
The stack view in LIFO manner: 
99	88	The stack view in LIFO manner: 
87	98	
 */
