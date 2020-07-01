package queues;

import java.util.Iterator;

import queues.GenericQueueLLItr.Node;

public class Dequeue<Item> implements Iterable<Item>{
	Node first, last;
	static int size=0;
	
	
	
	public class Node{
		Item value;
		Node next;
		public Node(Item s) {
			this.value = s;
		}
		
	}
	
	public Dequeue() {
	}

    // is the deque empty?
    public boolean isEmpty() {
    	return (first==null);
    }

    // return the number of items on the deque
    public int size() {
    	return size;
    	
    }

    // add the item to the front
    public void addFirst(Item item) {
    	if(item==null)
    		throw new IllegalArgumentException();
    	if(isEmpty()) {
    		first = new Node(item);
    		last = first;
    	}else {
    		Node prevFirst = first;
    		first = new Node(item);
    		first.next = prevFirst;
    	}
    	size++;
    }

    // add the item to the back
    public void addLast(Item item) {
    	if(item==null)
    		throw new IllegalArgumentException();
    	if(isEmpty()) {
    		first = new Node(item);
    		last = first;
    	}else {
    		Node prevLast = last;
    		last = new Node(item);
    		prevLast.next = last;  
    	}
    	size++;    	
    }

    // remove and return the item from the front
    public Item removeFirst() {
    	Item val;
    	if(isEmpty()) {
    		throw new java.util.NoSuchElementException();
    	}else {
    		val = first.value;
    		first= first.next;
    	}
    	size--;
    	return val;
    }

    // remove and return the item from the back
    public Item removeLast() {
    	Item val;
    	if(isEmpty()) {
    		throw new java.util.NoSuchElementException();
    	}else {
    		Node prevLast = last;
    		val = prevLast.value;
    		Node n = first;
    		while(n!=null) {
    			Node tmp = n.next;
    			if(tmp==prevLast) {
    				break;
    			}
    			n = tmp;
    		}
    		
    		last = n;
    		n.next = null;
    		
    		prevLast = null;
    	}
    	size--;
    	return val;
    	
    }
	
	public class ListIterator implements Iterator<Item>{
		
		Node current = first;

		@Override
		public boolean hasNext() {
			return (current!=null);
		}

		@Override
		public Item next() {
			if(current==null)
				throw new java.util.NoSuchElementException();
			Item val = current.value;
			current = current.next;
			return val;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
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
		Dequeue dq = new Dequeue<Integer>();
		dq.addFirst(1);
		dq.addLast(2);
		dq.addFirst(0);
		dq.addLast(3);
		dq.addLast(4);
		dq.print();
		Iterator<Integer> itr = dq.iterator();
		System.out.println("--------itr-------");
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		//itr.next(); nosuchele
		//itr.remove();//unsupp
		System.out.println("removed at first "+dq.removeFirst());
		dq.print();
		System.out.println("removed at last "+dq.removeLast());
		dq.print();
		

	}

}
