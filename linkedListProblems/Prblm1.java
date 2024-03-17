package linkedListProblems;
/*
 * Singly Linked List
1. Write a menu driven program to implement a singly linked list with the following
operations
a. Insert an element at any position (front, end or intermediate)
b. Delete an element from any position (front, end or intermediate)
c. Display the list
d. Perform a linear search on the list
e. Insert an element after a specified element
f. Delete a specified element
g. Count the number of nodes
h. Reverse the list, so that the last element becomes the first, and so on
i. Concatenate two lists
 */
class Node<T>{
	public T data;
	private Node<T> next=null;
	public Node<T> head=null;
	int ele_count=0;
	Node(){}
	Node(T n){
		data=n;
		next=null;
	}
	public String toString() {
		Node<T> p;
		String s="";
		p=this.head;
		if(p==null) {
			return "The list is empty";
		}
		else {
			while(p.next!=null) {
				s=s+"--"+p.data;
				p=p.next;
			}
			s=s+"--"+p.data;
			return s;
		}
	}
	public void create(T n) {
		Node<T> newNode=new Node<T>(n);
		if(head==null) {
			head=newNode;
			ele_count++;
			return;
		}
		System.out.println("The list is already created.");
	}
	public void insert_at_end(T n) {
		Node<T>p;
		if(this.head==null) {
			System.out.println("create the list first.");
			return;
		}
		Node<T>newNode=new Node<T>(n);
		for(p=this.head;p.next!=null;p=p.next);
		p.next=newNode;
		ele_count++;
	}
	public void insert_at_beg(T n) {
		Node<T>p;
		p=this.head;
		if(p==null) {
			System.out.println("create the list first.");
			return;
		}
		Node<T>newNode=new Node<T>(n);
		newNode.next=head;
		head=newNode;
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
		else {
			Node<T> p;
			Node<T>newNode=new Node<T>(n);
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
			if(f==1 || ele_count==pos-1) {
				newNode.next=p.next;
				p.next=newNode;
				ele_count++;
			}
			else
				System.out.println("position not found.");
		}
	}
	public T del_from_beg() {
		if(this.head==null) {
			System.out.println("create the list first.");
			return null;
		}
		T r=head.data;
		this.head=this.head.next;
		this.ele_count--;
		return r;
	}
	public T del_from_end() {
		if(this.head==null) {
			System.out.println("create the list first.");
			return null;
		}
		Node<T>p;
		p=head;
		while(p.next.next!=null) {
			p=p.next;
		}
		T r = p.next.data;
		p.next=null;
		ele_count--;
		return r;
		
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
			Node<T> p;
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
				ele_count--;
			}	
		}
	}
	public Node<T> search(T ele) {
		Node<T> p;
		p=this.head;
		if(p==null) {
			return null;
		}
		else {
			while(p.next!=null) {
				if(p.data==ele)
					break;
				p=p.next;
			}
			return p;
		}
	}
	public boolean find(T ele) {
		Node<T> p;
		p=this.head;
		if(p==null) {
			return false;
		}
		else {
			while(p.next!=null) {
				if(p.data==ele) {
					return true;
				}
				p=p.next;
			}
			if(p.data==ele) return true;
			return false;
			
		}
	}
	public void insert_After_a_node(T ele,T n) {
		Node<T> p;
		p=this.head;
		if(p==null) {
			System.out.println("create the list first.");
			return;
		}
		else {
			Node<T>newNode=new Node<T>(n);
			while(p.next!=null) {
				if(p.data==ele) {
					newNode.next=p.next;
					p.next=newNode;
					ele_count++;
					return;
				}
				p=p.next;
			}
			if(p.data==ele) {
				newNode.next=p.next;
				p.next=newNode;
				ele_count++;
				return;
			}
			
		}
	}
	public void del_specified_node(T ele) {
		Node<T> p;
		p=this.head;
		if(p==null) {
			System.out.println("create the list first.");
			return;
		}
		else if(this.head.data==ele) {
			this.del_from_beg();
		}
		else {
			while(p.next!=null) {
				if(p.next.data==ele) {
					p.next=p.next.next;
					ele_count--;
					return;
				}
				p=p.next;
			}
			if(p.data==ele) {
				p.next=p.next.next;
				ele_count--;
				return;
			}
		}
	}
	public void reverse() {
		Node<T> prev=null,cur,next=null;
		cur=this.head;
		if(cur==null) {
			System.out.println("create the list first.");
			return;
		}
		else {
			while (cur != null) {
	            next = cur.next;
	            cur.next = prev;
	            prev = cur;
	            cur = next;
	        }
			this.head = prev;
		}
	}
	public void concat_list(Node<T>l2) {
		if(this.head==null || l2.head==null) {
			System.out.println("List are nor created");
			return;
		}
		else {
			Node<T>p;
			for(p=this.head;p.next!=null;p=p.next);
			p.next=l2.head;
			this.ele_count+=l2.ele_count;
			return;
		}
	}
	
}



public class Prblm1 {
	public static void main(String[] args) {
		Node<Integer>list=new Node<Integer>();
		list.create(3);
		list.insert_at_beg(2);
		list.insert_at_beg(1);
		list.insert_at_end(4);
		list.insert_at_end(5);
		list.insert_any_pos(5, 6);
		list.insert_any_pos(7, 8);
		list.insert_any_pos(8, 10);
		list.insert_any_pos(7, 9);
		list.del_from_beg();
		list.del_from_end();
		list.del_from_end();
		list.del_any_pos(3);
		list.insert_any_pos(6, 10);
		list.del_any_pos(5);
		
		
		list.insert_After_a_node(6, 13);
		list.insert_After_a_node(10, 14);
		list.insert_After_a_node(2, 23);
		list.del_specified_node(10);
		list.del_specified_node(13);
		list.del_specified_node(14);
		list.del_specified_node(2);
		System.out.println(list.ele_count);
		System.out.println(list);
		System.out.println(list.find(11));
		
		list.reverse();
		System.out.println(list);
		Node<Integer>list2=new Node<Integer>();
		list2.create(34);
		list2.insert_at_beg(29);
		list2.insert_at_beg(19);
		list2.insert_at_end(43);
		list2.insert_at_end(55);
		
		System.out.println(list2);
		
		list.concat_list(list2);
		
		System.out.println(list);
		System.out.println(list.ele_count);

		
	}
}
