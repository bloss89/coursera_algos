package queues;

import java.util.Iterator;

public class GenericQueueResizeArrayItr<Item> implements Iterable<Item>{
	
	public class ArrayIterator implements Iterator<Item>{
		private int i = fwdIndex;

		@Override
		public boolean hasNext() {
			return (i<bckIndex);
		}

		@Override
		public Item next() {
			return queue[i++];
		}
		
	}

	@Override
	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}
	
	int fwdIndex=0, bckIndex=0;
	Item[] queue;
	
	public GenericQueueResizeArrayItr(int cap) {
		queue = (Item[]) new Object[cap];
	}
	
	public void enqueue(Item s) {
		int l = queue.length;
		if(bckIndex==l) {
			resize(2*l);
		}
		queue[bckIndex++] = s;
		if(isEmpty()) {
			fwdIndex = bckIndex;
		}
		
	}
	
	public Item dequeue() {
		if(isEmpty()) {
			System.out.println("empty Q");
			return null;
		}
		int l = queue.length;
		if(bckIndex==l/2) {
			resize(l/4);
		}
		Item s = queue[fwdIndex];
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
		Item[] copy = (Item[])new Object[cap];
		for(int i=fwdIndex;i<bckIndex;i++) {
			copy[i]=queue[i];
		}
		queue = copy;
	}
	public int length() {
		return queue.length;
	}

	public static void main(String[] args) {
		GenericQueueResizeArrayItr<String> queue = new GenericQueueResizeArrayItr<String>(5);
		queue.enqueue("to");
		queue.enqueue("be");
		queue.enqueue("or");
		queue.enqueue("not");
		queue.enqueue("to");
		queue.print();
		System.out.println("stack util is "+queue.size()+" out of "+queue.length());
		queue.enqueue("be");
		System.out.println("stack util is "+queue.size()+" out of "+queue.length());
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

		GenericQueueResizeArrayItr<Integer> queueInt = new GenericQueueResizeArrayItr<>(5);
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
