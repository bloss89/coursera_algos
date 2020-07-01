package queues;

import java.util.Iterator;

public class GenericQueueLLItr<Item> implements Iterable<Item> {
	
	Node first;
	Node last;
	static int size;
	
	public class Node{
		Item value;
		Node next;
		
		public Node(Item s) {
			this.value = s;
		}
	}
	public class ListIterator implements Iterator<Item>{
		private Node current = first;

		@Override
		public boolean hasNext() {
			return (current!=null);
		}

		@Override
		public Item next() {
			Item val = current.value;
			current = current.next;
			return val;
		}
		
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	public void enqueue(Item s) {
		Node prevLast = last;
		last = new Node(s);
		if(!isEmpty())
			prevLast.next = last;
		else {
			first = last;
		}
		size++;
	}
	
	public Item dequeue() {
		if(isEmpty()) {
			System.out.println("queue empty");
			return null;
		}
		Item s = first.value;
		first = first.next;
		size--;
		return s;
	}
	
	public boolean isEmpty() {
		return (first==null);
	}
	
	public int size() {
		return size;
	}
	
	public void print() {
		System.out.println("==========================");
		Node n = first;
		while(n!=null) {
			System.out.println(n.value);
			n = n.next;
		}
	}

	public static void main(String[] args) {
		//===========String===============
		GenericQueueLLItr<String> queue = new GenericQueueLLItr<String>();
		queue.enqueue("to");
		queue.enqueue("be");
		queue.enqueue("or");
		queue.enqueue("not");
		queue.enqueue("to");
		queue.enqueue("be");
		//queue.print();
		System.out.println("-------------Iterator-----------");
		for(String s: queue) {
			System.out.println(s);
		}
		System.out.println("DQd "+queue.dequeue());
		System.out.println("DQd "+queue.dequeue());
		System.out.println("DQd "+queue.dequeue());
		System.out.println("DQd "+queue.dequeue());
		System.out.println("DQd "+queue.dequeue());
		System.out.println("DQd "+queue.dequeue());
		System.out.println("DQd "+queue.dequeue());
		queue.print();
		//===========Integer===============

		GenericQueueLLItr<Integer> queueInt = new GenericQueueLLItr<>();
		queueInt.enqueue(1);
		queueInt.enqueue(2);
		queueInt.enqueue(3);
		queueInt.enqueue(4);
		queueInt.enqueue(5);
		queueInt.enqueue(6);
		//queueInt.print();
		System.out.println("-------------Iterator-----------");
		for(Integer i: queueInt) {
			System.out.println(i);
		}
		System.out.println("DQd "+queueInt.dequeue());
		System.out.println("DQd "+queueInt.dequeue());
		System.out.println("DQd "+queueInt.dequeue());
		System.out.println("DQd "+queueInt.dequeue());
		System.out.println("DQd "+queueInt.dequeue());
		System.out.println("DQd "+queueInt.dequeue());
		System.out.println("DQd "+queueInt.dequeue());
		queueInt.print();
		
	}

}
