package treeProblems;
/*
Write a program to construct a Binary Search Tree (BST) and perform the following
a. Traverse the tree in preorder, inorder, postorder and levelorder
b. Count the number of nodes
c. Count the number of leaves
d. Find the height of the tree
e. Search for an item in the tree
f. Remove a node from the tree
*/

class Node{
	int data;
	Node left,right;
	static int count=0;
	Node(){}
	Node create_Node(int val) {
		Node newNode=new Node();
		newNode.data=val;
		newNode.left=newNode.right=null;
		count++;
		return newNode; 
	}
/*
	public Node insert(Node root,int val) {
		Node ptr,node_ptr,parent_ptr;
		ptr=create_Node(val);
		if(root==null)
			root=ptr;
		else {
			parent_ptr=null;
			node_ptr=root;
			while(node_ptr!=null) {
				parent_ptr=node_ptr;
				if(val<node_ptr.data)
					node_ptr=node_ptr.left;
				else
					node_ptr=node_ptr.right;
			}
			if(val<parent_ptr.data)
				parent_ptr.left=ptr;
			else
				parent_ptr.right=ptr;
			
		}
		return root;
	}
}
*/
	
Node insert(Node root,int val) {
	if(root==null)
		return create_Node(val);
	else if(val<root.data)
		root.left=insert(root.left,val);
	else if(val>root.data)
		root.right=insert(root.right,val);
	return root;
}

	public static void inorder(Node node) {
		if(node!=null) {
			inorder(node.left);
			System.out.println(" "+node.data );
			inorder(node.right);
		}
	}
	public static void preorder(Node node) {
		if(node!=null) {
			System.out.println(" "+node.data );
			inorder(node.left);
			inorder(node.right);
		}
	}
	public static void postorder(Node node) {
		if(node!=null) {
			
			inorder(node.left);
			inorder(node.right);
			System.out.println(" "+node.data );
		}
	}
	public static int countLeaves(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }
	
	  static int height(Node root) {
	        if (root == null)
	            return 0; 
	        else {
	            int leftHeight = height(root.left);
	            int rightHeight = height(root.right);
	            return Math.max(leftHeight, rightHeight) + 1;
	        }
	  }
	  static boolean searchNode(Node node,int val) {
		
		  if(node==null)
			  return false;
		  if(node.data==val)
			  return true;
		  if(node.data>val)
			  return searchNode(node.left,val);
		  else
			  return searchNode(node.right,val);
		
		
	  }
	
	
	
	
}
public class Prblm3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root=new Node();
		root=root.insert(null, 9);
		root=root.insert(root, 7);
		root=root.insert(root, 8);
		root=root.insert(root, 2);
		root=root.insert(root, 4);
		root=root.insert(root, 5);
		
		System.out.println(Node.count);
		System.out.println("Inorder");
		Node.inorder(root);
		System.out.println("Postorder");
		Node.postorder(root);
		System.out.println("Preorder");
		Node.preorder(root);
		
		System.out.println("No. of leaves : "+Node.countLeaves(root));
        System.out.println("Height of the tree: " + Node.height(root));
        
        System.out.println("The node is found? "+ Node.searchNode(root, 8));
        System.out.println("The node is found? "+ Node.searchNode(root, 91));
        
        
		
		
	}

}
