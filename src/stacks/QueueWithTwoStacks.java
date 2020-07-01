package stacks;

import java.util.Iterator;

public class QueueWithTwoStacks<Item> implements Iterable<Item> {
		
		Node stack1First;
		Node stack2First;
		static int size;
		
		public class Node{
			Item value;
			Node next;
			
			public Node(Item s) {
				this.value = s;
			}
		}
		public class ListIterator implements Iterator<Item>{
			private Node current = stack2First;

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
			Node prevLast = stack2First;
			stack2First = new Node(s);
			if(!isEmpty())
				prevLast.next = stack2First;
			else {
				stack1First = stack2First;
			}
			size++;
		}
		
		public Item dequeue() {
			if(isEmpty()) {
				System.out.println("queue empty");
				return null;
			}
			Item s = stack1First.value;
			stack1First = stack1First.next;
			size--;
			return s;
		}
		
		public boolean isEmpty() {
			return (stack1First==null);
		}
		
		public int size() {
			return size;
		}
		
		public void print() {
			System.out.println("==========================");
			Node n = stack1First;
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
