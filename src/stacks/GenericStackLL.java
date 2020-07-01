package stacks;

public class GenericStackLL<Item> {
	
	private Node first = null;
	static int size = 0;
	
	public class Node{
		Item value;
		Node next;
	}
	
	public void push(Item val) {//insert at the beginning of the LL
		Node n1 = new Node();
		n1.value = val;
		n1.next = first;
		first = n1;
		size++;
	}
	
	public Item pop() {//pop the first ele - LIFO	
		if(isEmpty()) {
			System.out.println("stack empty");
			return null;
		}
		Item val = first.value;
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
		GenericStackLL<Integer> stack = new GenericStackLL<Integer>();
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
		
		//String

		GenericStackLL<String> stack1 = new GenericStackLL<String>();
		stack1.push("to");
		stack1.push("be");
		stack1.push("or");
		stack1.push("not");
		stack1.push("to");
		stack1.push("be");
		stack1.print();
		stack1.pop();
		stack1.pop();
		stack1.print();
		stack1.pop();
		stack1.pop();
		stack1.pop();
		stack1.pop();
		stack1.pop();
		stack1.print();

	}

}
