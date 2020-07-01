package sorting.quickSort;

import sorting.insertionSort.InsertionSort;

public class QuickSort {
	
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
	public static void sort(Comparable[] a, int lo, int hi) {
		int cutoff=7;
		if(hi<=lo+ cutoff -1) {
			InsertionSort is = new InsertionSort();
			is.sort(a);
		}
		if(hi<=lo) return;
		//int m = median(a,lo,lo+(hi-lo)/2,hi);
		//exchange(a, lo, m);
		int p = partition(a,lo,hi);
		sort(a,lo,p-1);
		sort(a,p+1,hi);
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
		Comparable[] a = {18,8,16,9,12,5,7,2,4,14,6,1,11,3,10,13,15,19,17,20};
		print(a);
		sort(a);
		print(a);
		Comparable[] a1 = {5,2,4,6,1,3};
		print(a1);
		sort(a1);
		print(a1);

	}

}
