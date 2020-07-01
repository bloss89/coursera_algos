package sorting.quickSort;

public class QuickSelect {
	
	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b)<0;
	}

	public static void exchange(Comparable[] a, int i, int j) {
		Comparable tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	public static void shuffle(Comparable[] a) {
		int n = a.length;
		for(int i=0;i<n;i++) {
			int r = (int)Math.random()*(i+1);
			exchange(a, i, r);
		}
		
	}
	public static int partition(Comparable[] a, int lo, int hi) {
		int i=lo,j=hi+1;
		while(true) {
			while(less(a[++i],a[lo])) {
				if(i==hi) break;
			}
			while(less(a[lo],a[--j])) {
				if(j==lo) break;
			}
			if(i>=j) break;
			exchange(a,i,j);
		}
		exchange(a,lo,j);
		return j;
	}
	
	public static Comparable select(Comparable[] a, int k)	{
		 shuffle(a);
		 int lo = 0, hi = a.length - 1;
		 while (hi > lo)
		 {
			 int j = partition(a, lo, hi);
			 if (j < k) lo = j + 1;
			 else if (j > k) hi = j - 1;
			 else return a[k];
		 }
		 return a[k];
	}

	public static void main(String[] args) {
		Comparable[] a1 = {5,2,4,6,1,3};
		int i = 3;
		System.out.println("element at index "+i+ " is "+ select(a1,i));

	}

}
