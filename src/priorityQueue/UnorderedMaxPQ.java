package priorityQueue;

public class UnorderedMaxPQ<Key extends Comparable<Key>>{
	
	private Key[] pq;
	private int indx;
	
	public UnorderedMaxPQ(int cap) {
		pq = (Key[]) new Comparable[cap];
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
	public void insert(Key k) {
		pq[indx++]=k;
	}
	public Key delMax() {
		int max=0;
		for(int i=1;i<indx;i++)
			if(less(max,i)) max=i;
		exchange(max, indx-1);
		return pq[--indx];
	}
	public void print() {
		System.out.println();
		for(int i=0;i<indx;i++) {
			System.out.print(pq[i]+"--");
		}		
	}

	public static void main(String[] args) {
		UnorderedMaxPQ<String> pq = new UnorderedMaxPQ<String>(5);
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
