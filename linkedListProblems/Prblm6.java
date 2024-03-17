package linkedListProblems;
/*
 * Write a menu driven program to implement a double ended queue using linked list.
 */
class Double_ended_queue<T>{
Node<T>list=new Node<T>();
	
	public boolean underflow() {
		if(list.head==null) {
			return true;
		}
		return false;
	}
	public void enqueue_right(T n) {
		if(list.head==null) {
			list.create(n);
			return;
		}
		list.insert_at_end(n);		
	}
	public void enqueue_left(T n) {
		if(list.head==null) {
			list.create(n);
			return;
		}
		list.insert_at_beg(n);		
	}
	public T dequeue_left() {
		if(list.head==null) {
			System.out.println("Queue has no element");
			return null;
		}
		return list.del_from_beg();
	}
	public T dequeue_right() {
		if(list.head==null) {
			System.out.println("Queue has no element");
			return null;
		}
		return list.del_from_end();
	}
	public T peek() {
		if(list.head==null) {
			System.out.println("Queue has no element");
			return null;
		}
		return list.head.data;
	}
}



public class Prblm6 {

	public static void main(String[] args) {
		Double_ended_queue<Integer>dq=new Double_ended_queue<Integer>();
		dq.enqueue_left(4);
		dq.enqueue_left(8);
		dq.enqueue_left(7);
		System.out.println(dq.peek());
		dq.enqueue_right(9);
		dq.enqueue_right(8);
		dq.enqueue_right(6);
		System.out.println(dq.dequeue_left()+"dequed from left");
		System.out.println(dq.dequeue_left()+"dequed from left");
		System.out.println(dq.dequeue_right()+"dequed from right");
		System.out.println(dq.peek());
		

	}

}
