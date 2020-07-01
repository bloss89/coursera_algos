package stacks;

public class StackLL {
	
	private Node first = null;
	static int size = 0;
	
	public class Node{
		int value;
		Node next;
	}
	
	public void push(int val) {//insert at the beginning of the LL
		Node n1 = new Node();
		n1.value = val;
		n1.next = first;
		first = n1;
		size++;
	}
	
	public int pop() {//pop the first ele - LIFO	
		if(isEmpty()) {
			System.out.println("stack empty");
			return Integer.MIN_VALUE;
		}
		int val = first.value;
		first = first.next;
		size--;
		return val;
	}
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (first==null);
	}
	public void print() {
		System.out.println("============================================");
		Node n = first;
		while(n!=null) {
			System.out.println(n.value);
			n = n.next;
		}
	}
	public static void main(String[] args) {
		StackLL stack = new StackLL();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.print();
		stack.pop();
		stack.pop();
		stack.print();
		System.out.println("size is "+stack.size());
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();

	}

}
