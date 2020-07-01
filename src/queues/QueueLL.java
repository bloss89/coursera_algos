package queues;

public class QueueLL {
	
	Node first;
	Node last;
	static int size;
	
	public class Node{
		String value;
		Node next;
		
		public Node(String s) {
			this.value = s;
		}
	}
	
	public void enqueue(String s) {
		Node prevLast = last;
		last = new Node(s);
		if(!isEmpty())
			prevLast.next = last;
		else {
			first = last;
		}
		size++;
	}
	
	public String dequeue() {
		if(isEmpty()) {
			System.out.println("queue empty");
			return "";
		}
		String s = first.value;
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
		QueueLL queue = new QueueLL();
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
	}

}
