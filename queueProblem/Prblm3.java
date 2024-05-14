package queueProblem;

import java.util.Scanner;

/*
 * Write a menu driven program to implement a deque using list. 
Call the two ends of the deque left and right and write four C functions, remvLeft, 
remvRight, insrtLeft, insrtRight to remove and insert elements at the left and right 
ends of the deque. Make sure that the routines work properly for empty deque and 
that they detect overflow and underflow 
 */
class Doubly_queue<T>{
	int size, front, rear;
	T arr[]; 
	 
	
	@SuppressWarnings("unchecked")
	Doubly_queue(int size)
	{
	    this.size = size;
	    this.front = this.rear = -1;
	    arr=(T[])new Object[size];
	}
	boolean isEmpty() {
		return this.front==this.rear;
	}
	boolean isFull() {
		return this.rear==this.size-1;
	}
	
	void r_insert(T n) throws QueueOverflowException {
		if(isFull()) {
			throw new QueueOverflowException("The queue is in overflow condition");
		}
		else if(isEmpty()) {
			front=0;
			rear=0;
			arr[rear]=n;
		}
		rear++;
		arr[rear]=n;
	}
	void l_insert(T num) throws QueueOverflowException {
		if(this.front==-1)
			throw new QueueOverflowException("The queue is in Overflow condition");
		
		this.arr[this.front]=num;
		this.front--;
	}
	
	T l_serve() throws QueueUnderflowException {
		T element;
	    if (isEmpty()) {
	    	throw new QueueUnderflowException("The queue is in underflow condition");
	    } else {
	      element = arr[front];
	      if (front >= rear) {
	        front = -1;
	        rear = -1;
	      } // Q has one element, so we reset the queue after deleting.
	      else {
	        front++;
	      }
	      return (element);
	    }
	}
	T r_serve() throws QueueUnderflowException {
		if(this.rear==-1)
			throw new QueueUnderflowException("The queue is in underflow condition");
		T x= this.arr[this.rear];
		this.rear--;
		return x;
	}
	void queue_display() {
		for(int i=this.front+1;i<=this.rear;i++) {
			System.out.print(this.arr[i]);
			if(i<this.rear)
				System.out.print("<-");
		}
		System.out.println();
	}
	
}


public class Prblm3 {

	public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.println("MENU");
			System.out.println("Enter 1 for insert restriction.");
			System.out.println("Enter 2 for delete restriction.");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				Doubly_queue<Integer> dq=new Doubly_queue<Integer>(5);
				dq.r_insert(30);
				dq.r_insert(80);
				dq.r_insert(60);
				dq.r_insert(50);
				dq.queue_display();
				//dq.l_serve();
				//dq.l_serve();
				dq.r_serve();
				dq.l_serve();
				dq.queue_display();
				break;
			case 2 :
				Doubly_queue<Integer> dq1=new Doubly_queue<Integer>(5);
				dq1.r_insert(30);
				dq1.r_insert(80);
				dq1.l_serve(); 
				dq1.l_insert(50);
				dq1.r_insert(20);
				
				//dq1.l_serve();
				dq1.queue_display();
				
			}
			
		}

	}

}
