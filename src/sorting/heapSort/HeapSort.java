package sorting.heapSort;

public class HeapSort<Key extends Comparable<Key>> {
		public void sort(Comparable[] a) {
			int indx = a.length-1;
			for(int k=indx/2;k>=1;k--) {
				sink(a,k,indx);
			}
			print(a); //max heap
			while(indx>1) {
				exchange(a,1,indx);
				sink(a,1,--indx);
			}
		}
		public boolean less(Comparable[] a,int aa, int bb) {
			return a[aa].compareTo(a[bb])<0;
		}

		public void exchange(Comparable[] a,int i, int j) {
			Comparable tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
		public void print(Comparable[] a) {
			System.out.println();
			int indx = a.length-1;
			for(int i=1;i<=indx;i++) {
				System.out.print(a[i]+"--");
			}		
		}	
		private void sink(Comparable[] a,int k, int indx) {
			while(2*k <= indx) {
				int j = 2*k;
				if(j<indx && less(a,j,j+1)) j++;
				if(!less(a,k,j)) break;
				exchange(a,k, j);
				k=j;
			}
		}

		public static void main(String[] args) {
			HeapSort<String> pq = new HeapSort<String>();
			Integer[] a = {-1,5,2,4,6,1,3};
		//	String[] a = {"*","S","O","R","T","E","X","A","M","P","L","E"};
			pq.print(a);
			pq.sort(a);
			pq.print(a);
		}

}
