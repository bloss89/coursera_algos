package tree;

import queues.GenericQueueLL;
import queues.GenericQueueLLItr;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	
	private Node root;
	
	public class Node{
		private Key key;
		private Value val;
		private Node left, right;
		private int count;
		public Node(Key key, Value val) {
			this.key = key;
			this.val = val;
			
		}
	}
	public int size() {
		return size(root);
	}
	public int size(Node x) {
		if(x==null) return 0;
		else return x.count;
	}
	
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}
	public Node put(Node x, Key key, Value val) {
		 if(x==null) return new Node(key,val);
		 int cmp = key.compareTo(x.key);
		 if(cmp<0)
			 x.left = put(x.left,key, val);
		 else if(cmp>0)
			 x.right = put(x.right,key, val);
		 else if(cmp==0)
			 x.val = val;
		 x.count = 1+size(x.left)+size(x.right);
		 return x;
	}
	
	public int rank(Key key) {
		return rank(root,key);
	}
	public int rank(Node x,Key key) {
		if(x==null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp<0) return rank(x.left,key);
		else if(cmp>0) return 1+size(x.left)+rank(x.right,key);
		else if(cmp==0) return size(x.left);
		return 0;
	}
	
	public Iterable<Key> keys(){
		GenericQueueLLItr<Key> q = new GenericQueueLLItr<Key>();
		inorder(root,q);
		return q;
	}
	private void inorder(Node x, GenericQueueLLItr<Key> q ) {
		if(x==null) return;
		inorder(x.left,q);
		q.enqueue(x.key);
		inorder(x.right,q);		
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	public Node deleteMin(Node x) {
		if(x.left==null) return x.right;
		x.left = deleteMin(x.left);
		x.count = 1+ size(x.left) + size(x.right);
		return x;
	}
	
	public Value get(Key key) {
		Node x = root;
		while(x!=null) {
			int cmp = x.key.compareTo(key);
			if(cmp<0) x = x.left;
			else if(cmp>0) x = x.right;
			else if(cmp==0) return x.val;
			
		}
		return null;
	}
	public Key floor(Key key) {
		Node x = floor(root,key);
		if(x==null) return null;
		return x.key;		
	}
	public Node floor(Node x,Key key) {
		if(x==null)
			return null;
		int cmp = key.compareTo(x.key);
		if(cmp==0) return x;
		if(cmp<0) return floor(x.left,key);
		Node t = floor(x.right,key);
		if(t!=null) return t;
		else return x;
		
	}
	
	public void delete(Key key) {
		root = delete(root,key);
	}
	public Node delete(Node x, Key key) {
		if(x==null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp<0) x.left = delete(x.left, key);
		else if(cmp>0) x.right = delete(x.right, key);
		else {
			if(x.right==null) return x.left;
			if(x.left==null) return x.right;
			
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.count = size(x.left)+size(x.right)+1;
		return x;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
