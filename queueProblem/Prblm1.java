package queueProblem;
/*
 *  Write a program to implement a Queue class (use a list to store the elements of the 
Queue). [Implement Queue Overflow and Underflow by Exception]. Write a 
method to check two Queue are carrying similar elements or not. (Repetition of the 
elements are not consider)
 */


class QueueOverflowException extends Exception{
	QueueOverflowException(String e){
		super(e);
	}
}
class QueueUnderflowException extends Exception{
	QueueUnderflowException(String e){
		super(e);
	}
}

class Queue<T>{ 
	int front,rear,size;
	T arr[];
	@SuppressWarnings("unchecked")
	Queue(int size){
		this.size=size;
		front=-1;
		rear=-1;
		arr=(T[])new Object[size];
	}
	boolean LinearSearch(T a[], T find){
		for(int i=0;i<this.rear;i++) {
			if(a[i].equals(find)) {
				return true;
			}
		}
		return false;
	}
	boolean isEmpty()
	{
		return front == -1;
	}

	boolean isFull()
	{
		return (front == 0 && rear == size-1);
	}	
	void Enqueue(T n) throws QueueOverflowException {
		if(isFull()) {
			throw new QueueOverflowException("The queue is in overflow condition");
		}
		else if(isEmpty()) {
			front=0;
			rear=0;
			arr[rear]=n;
		}
		else {
			
			if(!LinearSearch(arr,n)) {
				rear++;
				arr[rear]=n;
			}
			else {
				System.out.println("Similar elements.");
			}
		}
	}
	T deQueue() throws QueueUnderflowException {
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
	
	void display() {
		 if (isEmpty()) {
		      System.out.println("Queue is in underflow condition");
		    } 
		 else {
		      System.out.println("\nThe Queue view in FIFO order: ");
		      for (int i = front; i <= rear; i++)
		        System.out.print(arr[i] + "  ");
		    }
	}
	
	
	
}


public class Prblm1 {

	public static void main(String[] args) throws QueueOverflowException {
		
		Queue<Integer> q=new Queue<Integer>(5);
		q.Enqueue(10);
		q.Enqueue(20);
		q.display();
		System.out.println();
		q.Enqueue(10);
	}

}
