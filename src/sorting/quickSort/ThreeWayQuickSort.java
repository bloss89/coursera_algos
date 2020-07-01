package sorting.quickSort;

import sorting.insertionSort.InsertionSort;

public class ThreeWayQuickSort {
	
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
	public static void sort(Comparable[] a, int lo, int hi) {
		int cutoff=7;
		if(hi<=lo+ cutoff -1) {
			InsertionSort is = new InsertionSort();
			is.sort(a);
		}
		if(hi<=lo) return;
		int lt=lo,gt=hi;
		Comparable v=a[lo];
		int i=lo;
		while(i<=gt) {
			int cmp = a[i].compareTo(v);
			if(cmp<0) exchange(a,lt++,i++);
			else if(cmp>0) exchange(a,i,gt--);
			else i++;
		}		
		sort(a,lo,lt-1);
		sort(a,gt+1,hi);
	}
	
	public static void sort(Comparable[] a) {
		shuffle(a);
		sort(a,0,a.length-1);
	}
	
	public static void print(Comparable[] a) {
		int n = a.length;
		System.out.println();
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+"--");
		}		
	}
	public static void main(String[] args) {
		Comparable[] a = {5,2,3,1,1,3,2,4,5,6,7,2,2,8,4,3,2,9,6};
		print(a);
		sort(a);
		print(a);

	}


}
