package stacks;

import java.util.Iterator;

public class GenericStackLLIterator<Item> implements Iterable<Item> {
	
	private Node first = null;
	static int size = 0;
	
	public class Node{
		Item value;
		Node next;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	public class ListIterator implements Iterator<Item>{
		
		private Node current = first;

		@Override
		public boolean hasNext() {
			return (current!=null);
		}

		@Override
		public Item next() {
			Item val= current.value;
			current = current.next;
			return val;
		}
		
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
		GenericStackLLIterator<Integer> stack = new GenericStackLLIterator<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		//stack.print();
		System.out.println("-------------Iterator-----------");
		for(Integer i: stack) {
			System.out.println(i);
		}
		stack.pop();
		stack.pop();
		stack.print();
		System.out.println("size is "+stack.size());
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		
		//String

		GenericStackLLIterator<String> stack1 = new GenericStackLLIterator<String>();
		stack1.push("to");
		stack1.push("be");
		stack1.push("or");
		stack1.push("not");
		stack1.push("to");
		stack1.push("be");
		//stack1.print();
		System.out.println("-------------Iterator-----------");
		for(String s: stack1) {
			System.out.println(s);
		}
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
