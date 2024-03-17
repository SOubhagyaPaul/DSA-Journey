package linkedListProblems;
/*Write a program to implement a queue using linked list, such that the operations
‘enqueue’ and ‘dequeue’ are performed in constant time.*/

class Queue_list<T>{
	
	Node<T>list=new Node<T>();
	
	public boolean underflow() {
		if(list.head==null) {
			return true;
		}
		return false;
	}
	public void enqueue(T n) {
		if(list.head==null) {
			list.create(n);
			return;
		}
		list.insert_at_end(n);		
	}
	public T dequeue() {
		if(list.head==null) {
			System.out.println("Queue has no element");
			return null;
		}
		return list.del_from_beg();
	}
	public T peek() {
		if(list.head==null) {
			System.out.println("Queue has no element");
			return null;
		}
		return list.head.data;
	}
}



public class Prblm5 {

	public static void main(String[] args) {
		Queue_list<Integer>q=new Queue_list<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println(q.peek());
		System.out.println(q.dequeue()+"dequeue");
		System.out.println(q.dequeue()+"dequeue");
		System.out.println(q.peek());
		

	}

}
