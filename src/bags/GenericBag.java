package bags;

import java.util.Iterator;

import queues.GenericQueueLLItr.Node;

public class GenericBag<Item> implements Iterable<Item> {
	
	public class Node{
		Item value;		
		public Node(Item s) {
			this.value = s;
		}
	}
	
	public class BagIterator implements Iterator<Item>{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

	@Override
	public Iterator<Item> iterator() {
		return new BagIterator();
	}
	
	public void add(Item v) {
		
	}
	public int size() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
