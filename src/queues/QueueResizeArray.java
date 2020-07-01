package queues;

public class QueueResizeArray {
	
	int fwdIndex=0, bckIndex=0;
	String[] queue;
	
	public QueueResizeArray(int cap) {
		queue = new String[cap];
	}
	
	public void enqueue(String s) {
		int l = queue.length;
		if(bckIndex==l) {
			resize(2*l);
		}
		queue[bckIndex++] = s;
		if(isEmpty()) {
			fwdIndex = bckIndex;
		}
		
	}
	
	public String dequeue() {
		if(isEmpty()) {
			System.out.println("empty Q");
			return "";
		}
		int l = queue.length;
		if(bckIndex==l/2) {
			resize(l/4);
		}
		String s = queue[fwdIndex];
		queue[fwdIndex++] = null;
		return s;
	}
	
	public int size() {
		return (bckIndex-fwdIndex);
	}
	
	public boolean isEmpty() {
		return (size()==0);
	}
	public void print() {
		System.out.println("==========================");
		for(int i=fwdIndex;i<bckIndex;i++) {
			System.out.println(queue[i]);
		}
	}
	public void resize(int cap) {
		String[] copy = new String[cap];
		for(int i=fwdIndex;i<bckIndex;i++) {
			copy[i]=queue[i];
		}
		queue = copy;
	}
	public int length() {
		return queue.length;
	}

	public static void main(String[] args) {
		QueueResizeArray queue = new QueueResizeArray(5);
		queue.enqueue("to");
		queue.enqueue("be");
		queue.enqueue("or");
		queue.enqueue("not");
		queue.enqueue("to");
		queue.print();
		System.out.println("stack util is "+queue.size()+" out of "+queue.length());
		queue.enqueue("be");
		System.out.println("stack util is "+queue.size()+" out of "+queue.length());
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
