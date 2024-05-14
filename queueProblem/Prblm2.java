package queueProblem;

import java.util.ArrayList;

/*
 * Write a menu driven program to implement a circular queue (use an array to store 
the elements of the queue). You can follow any one of the schemes A circular list with front and rear indices and 
one position left vacant. Or, A circular list with front and rear indices and an integer 
variable counting entries 
 */

class Circular_Queue<T>{
	 
	int size, front, rear;
	T arr[]; 
	@SuppressWarnings("unchecked")
	Circular_Queue(int size)
	{
	    this.size = size;
	    this.front = this.rear = 0;
	    arr=(T[])new Object[size];
	}
	public void enQueue(T val) throws QueueOverflowException
	{
		if((this.rear+1)%this.size==this.front)
			throw new QueueOverflowException("The queue is in overflow condition");
		this.rear=(this.rear+1)%this.size;
		this.arr[this.rear]=val;
	}
	public T deQueue() throws QueueUnderflowException
	{
	    if(this.front==this.rear)
	    {
	    	throw new QueueUnderflowException("The queue is in underflow condition");
	    }
	    front=(front +1)%size;
	    return this.arr[this.front];
	    
	}
	 

	public void displayQueue() throws QueueUnderflowException
	{

	    if(this.front==this.rear)
	    {
	    	throw new QueueUnderflowException("The queue is in underflow condition");
	    }

	    System.out.print("Elements in the circular queue are: ");
	    int i=this.front+1;
	    do {
	    	System.out.print(this.arr[i]+" ");
	    	if(i<this.rear) {
	    		System.out.print(" ");
	    	}
	    	i=(i+1)%this.size;
	    }while(i!=(this.rear+1)%this.size);
	System.out.println();
	}
}

public class Prblm2 {

	public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException {
		// TODO Auto-generated method stub
		Circular_Queue <Integer>cir_q=new Circular_Queue <Integer>(5);
		cir_q.enQueue(12);
		cir_q.enQueue(1);
		cir_q.enQueue(17);
		cir_q.enQueue(14);
//		cir_q.enQueue(19);
		cir_q.displayQueue();
//		cir_q.enQueue(129);
		cir_q.deQueue();
		cir_q.displayQueue();
		cir_q.deQueue();
		cir_q.displayQueue();
		cir_q.deQueue();
		cir_q.displayQueue();
		cir_q.enQueue(5);
		cir_q.enQueue(45);

		cir_q.displayQueue();
		

	}

}
