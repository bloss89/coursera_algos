package priorityQueue;

public class BinaryHeap<Key extends Comparable<Key>> {

	private Key[] pq;
	private int indx;
	
	public BinaryHeap(int cap) {
		pq = (Key[]) new Comparable[cap+1];
	}
	public boolean less(int a, int b) {
		return pq[a].compareTo(pq[b])<0;
	}

	public void exchange(int i, int j) {
		Key tmp = pq[i];
		pq[i] = pq[j];
		pq[j] = tmp;
	}
	
	public boolean isEmpty() {
		return (indx==0);
	}
	public void resize(int cap) {
		Key[] copy = (Key[])new Comparable[cap];
		for(int i=1;i<indx;i++) {
			copy[i]=pq[i];
		}
		pq = copy; 
	}
	public void insert(Key k) {
		int l = pq.length;
		if(++indx==l) {
			resize(2*l);
		}
		pq[indx]=k;
		swim(indx);
	}
	public Key delMax() {
		Key max=pq[1];
		exchange(1, indx--);
		sink(1);
		pq[indx+1] = null;
		return max;
	}
	public void print() {
		System.out.println();
		for(int i=1;i<indx+1;i++) {
			System.out.print(pq[i]+"--");
		}		
	}
	
	private void swim(int k) {
		while(k>1 && less(k/2,k)) {
			exchange(k,k/2);
			k=k/2;
		}
	}
	private void sink(int k) {
		while(2*k <= indx) {
			int j = 2*k;
			if(j<indx && less(j,j+1)) j++;
			if(!less(k,j)) break;
			exchange(k, j);
			k=j;
		}
	}

	public static void main(String[] args) {
		BinaryHeap<Integer> pqi = new BinaryHeap<Integer>(5);
		pqi.insert(5);
		pqi.insert(2);
		pqi.insert(4);
		pqi.insert(6);
		pqi.insert(1);
		pqi.insert(3);
		pqi.insert(7);
		pqi.print();
		System.out.println("delMax "+pqi.delMax());
		pqi.print();
		
		BinaryHeap<String> pq = new BinaryHeap<String>(5);
		pq.insert("P");
		pq.insert("Q");
		pq.insert("E");
		pq.print();
		System.out.println("delMax "+pq.delMax());
		pq.print();

		pq.insert("X");
		pq.insert("A");
		pq.insert("M");
		pq.print();
		System.out.println("delMax "+pq.delMax());
		pq.print();
	}



}
