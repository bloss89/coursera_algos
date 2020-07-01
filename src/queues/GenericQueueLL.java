package queues;

public class GenericQueueLL<Item> {
	
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
		GenericQueueLL<String> queue = new GenericQueueLL<String>();
		queue.enqueue("to");
		queue.enqueue("be");
		queue.enqueue("or");
		queue.enqueue("not");
		queue.enqueue("to");
		queue.enqueue("be");
		queue.print();
		System.out.println("DQd "+queue.dequeue());
		System.out.println("DQd "+queue.dequeue());
		System.out.println("DQd "+queue.dequeue());
		System.out.println("DQd "+queue.dequeue());
		System.out.println("DQd "+queue.dequeue());
		System.out.println("DQd "+queue.dequeue());
		System.out.println("DQd "+queue.dequeue());
		queue.print();
		//===========Integer===============

		GenericQueueLL<Integer> queueInt = new GenericQueueLL<>();
		queueInt.enqueue(1);
		queueInt.enqueue(2);
		queueInt.enqueue(3);
		queueInt.enqueue(4);
		queueInt.enqueue(5);
		queueInt.enqueue(6);
		queueInt.print();
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
