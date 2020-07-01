package sorting.insertionSort;

public class InsertionSort {
		
		public static boolean less(Comparable a, Comparable b) {
			return a.compareTo(b)<0;
		}

		public static void exchange(Comparable[] a, int i, int j) {
			Comparable tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
		}
		private static boolean isSorted(Comparable[] a) {
			int n = a.length;
			for(int i=1;i<n;i++) {
				if(less(a[i],a[i-1]))
					return false;
			}
			return true;
		}
		public void sort(Comparable[] a) {
			int n = a.length;
			for(int i=1;i<n;i++) {
				for(int j=i;j>0;j--) {
					if(less(a[j],a[j-1]))
						exchange(a,j,j-1);
					else
						break;
				}
			}
		}
		public static void print(Comparable[] a) {
			int n = a.length;
			System.out.println();
			for(int i=0;i<n;i++) {
				System.out.print(a[i]+"--");
			}		
		}
		public static void shuffle(Comparable[] a) {
			int n = a.length;
			for(int i=0;i<n;i++) {
				int r = (int)Math.random()*(i+1);
				exchange(a, i, r);
			}
			
		}
		public static void main(String[] args) {
			Comparable[] a = {5,2,4,6,1,3};
			shuffle(a);
			print(a);
			InsertionSort insertionSort = new InsertionSort();
			insertionSort.sort(a);
			print(a);
		}

}
