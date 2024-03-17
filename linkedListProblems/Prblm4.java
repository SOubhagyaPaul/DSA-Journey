package linkedListProblems;
/*
 * Write a program to implement a stack using linked list, such that the operations ‘push’
and ‘pop’ are performed in constant time.
 */
class Stack_list<T>{
	
	Node<T>list=new Node<T>();
	
	public boolean underflow() {
		if(list.head==null) {
			return true;
		}
		return false;
	}
	public void push(T n) {
		if(list.head==null) {
			list.create(n);
			return;
		}
		list.insert_at_beg(n);		
	}
	public T pop() {
		if(list.head==null) {
			System.out.println("Stack has no element");
			return null;
		}
		return list.del_from_beg();
	}
	public T peek() {
		if(list.head==null) {
			System.out.println("Stack has no element");
			return null;
		}
		return list.head.data;
	}
}


public class Prblm4 {

	public static void main(String[] args) {
		Stack_list<Integer> s=new Stack_list<Integer>();
		s.push(5);
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		System.out.println(s.peek());
		System.out.println(s.pop()+"poped");
		System.out.println(s.pop()+"poped");
		System.out.println(s.peek());
		

	}

}
