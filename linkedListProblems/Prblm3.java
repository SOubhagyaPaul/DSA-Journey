package linkedListProblems;
/*
 * Write a menu driven program to implement a doubly circular linked list with the
following operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list
 */


class Node_doubly_circular<T>{
	private T data;
	private Node_doubly_circular<T> next=null;
	private Node_doubly_circular<T> prev=null;
	private Node_doubly_circular<T> head=null;
	int ele_count=0;
	Node_doubly_circular(){}
	Node_doubly_circular(T n){
		data=n;
		next=null;
		prev=null;
	}
	public String toString() {
		Node_doubly_circular<T> p;
		String s="";
		p=this.head;
		if(p==null) {
			return "The list is empty";
		}
		else {
			while(p.next!=head) {
				s=s+"--"+p.data;
				p=p.next;
			}
			s=s+"--"+p.data;
			return s;
		}
	}
	public void create(T n) {
		Node_doubly_circular<T> newNode=new Node_doubly_circular<T>(n);
		if(head==null) {
			head=newNode;
			newNode.next=head;
			newNode.prev=head;
			ele_count++;
			return;
		}
		System.out.println("The list is already created.");
	}
	public void insert_at_end(T n) {
		Node_doubly_circular<T>p;
		if(this.head==null) {
			System.out.println("create the list first.");
			return;
		}
		Node_doubly_circular<T>newNode=new Node_doubly_circular<T>(n);
		for(p=this.head;p.next!=head;p=p.next);
		p.next=newNode;
		newNode.prev=p;
		newNode.next=head;
		ele_count++;
	}
	public void insert_at_beg(T n) {
		Node_doubly_circular<T>p,t;
		p=this.head;
		if(p==null) {
			System.out.println("create the list first.");
			return;
		}
		Node_doubly_circular<T>newNode=new Node_doubly_circular<T>(n);
		for(t=this.head;t.next!=head;t=t.next);
		newNode.prev=t;
		newNode.next=head;
		p.prev=newNode;
		head=newNode;
		t.next=newNode;
		ele_count++;
			
	}
	public void insert_any_pos(int pos, T n) {
		if(this.head==null) {
			System.out.println("create the list first.");
			return;
		}
		else if(pos==1) {
			this.insert_at_beg(n);
			return;
		}
		else if(pos==this.ele_count) {
			this.insert_at_end(n);
		}
		else {
			Node_doubly_circular<T> p;
			Node_doubly_circular<T>newNode=new Node_doubly_circular<T>(n);
			p=head;
			int x=1,f=0;
			while(p.next!=null) {
				if(x==pos-1) {
					f=1;
					break;
				}
				p=p.next;
				x++;
			}
			if(f==1) {
				newNode.next=p.next;
				newNode.prev=p;
				p.next.prev=newNode;
				p.next=newNode;
				ele_count++;
			}
			else
				System.out.println("position not found.");
		}
	}
	public void del_from_beg() {
		if(this.head==null) {
			System.out.println("create the list first.");
			return;
		}
		Node_doubly_circular<T>p,q;
		p=head;
		for(q=this.head;q.next!=head;q=q.next);
		this.head=p.next;
		this.head.prev=q;
		q.next=head;
		this.ele_count--;
	}
	public void del_from_end() {
		if(this.head==null) {
			System.out.println("create the list first.");
			return;
		}
		Node_doubly_circular<T>p;
		p=head;
		while(p.next.next!=head) {
			p=p.next;
		}
		p.next=head;
		head.prev=p;
		ele_count--;
		
	}
	public void del_any_pos(int pos) {
		if(this.head==null) {
			System.out.println("create the list first.");
			return;
		}
		else if(pos==1) {
			this.del_from_beg();
			return;
		}
		else if(pos==this.ele_count) {
			this.del_from_end();
			return;
		}
		else {
			Node_doubly_circular<T> p;
			int x=1,f=0;
			p=head;
			while(p.next!=null) {
				if(x==pos-1) {
					f=1;
					break;
				}
				p=p.next;
				x++;
			}
			if(f==1) {
				p.next=p.next.next;
				p.next.prev=p;
				ele_count--;
			}	
		}
	}

}


public class Prblm3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node_doubly_circular<Integer>list=new Node_doubly_circular<Integer>();
		list.create(3);
		list.insert_at_beg(2);
		list.insert_at_beg(1);
		list.insert_at_end(4);
		list.insert_at_end(5);
		System.out.println(list.ele_count);
		System.out.println(list);
		
		list.insert_at_beg(1);
		list.insert_at_end(43);
		list.insert_at_end(55);
		list.insert_any_pos(5, 6);
	
		System.out.println(list.ele_count);
		System.out.println(list);
		
		list.del_from_beg();
		list.del_from_beg();
		list.del_from_end();
		list.del_from_end();
		list.del_from_end();
		System.out.println(list.ele_count);
		System.out.println(list);
		
		list.insert_at_beg(1);
		list.insert_at_end(43);
		list.insert_at_end(55);
		list.insert_any_pos(5, 16);
	
		System.out.println(list.ele_count);
		System.out.println(list);
		list.del_any_pos(6);
		list.del_any_pos(1);
		list.del_any_pos(3);
		list.del_any_pos(5);
		System.out.println(list.ele_count);
		System.out.println(list);

	}

}
