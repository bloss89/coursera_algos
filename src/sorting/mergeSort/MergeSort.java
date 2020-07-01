package sorting.mergeSort;

import sorting.insertionSort.InsertionSort;

public class MergeSort {
	
	static Comparable[] aux;
	
	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b)<0;
	}

	public static void exchange(Comparable[] a, int i, int j) {
		Comparable tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void merge(Comparable[] a,Comparable[] aux, int lo, int mid, int hi) {
		for(int k=lo;k<=hi;k++) {
			aux[k] = a[k];
		}
		int i=lo,j=mid+1;
		for(int k=lo;k<=hi;k++) {
			if(i>mid) a[k] =aux[j++];
			else if(j>hi) a[k] = aux[i++];
			else if(less(aux[j],aux[i])) a[k] = aux[j++];
			else a[k]=aux[i++];
			
		}
	}
	
	public static void sort(Comparable[] a,Comparable[] aux, int lo, int hi) {
		int cutoff=7;
		if(hi<=lo+ cutoff -1) {
			InsertionSort is = new InsertionSort();
			is.sort(a);
		}
		if(hi<=lo) return;
		int mid = lo + (hi-lo)/2;
		sort(a,aux,0,mid);
		sort(a,aux,mid+1,hi);
		if(!less(a[mid+1],a[mid]))return;
		merge(a,aux,lo,mid,hi);
	}
	
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a,aux,0,a.length-1);
	}
	
	public static void bottomUpMS(Comparable[] a) {
		int n = a.length;
		Comparable[] aux = new Comparable[n];
		for(int sz=1; sz<n;sz=2*sz) {
			for(int lo=0;lo<n-sz;lo+=2*sz) {
				merge(a,aux,lo,lo+sz-1,Math.min(lo+2*sz-1,n-1));
				
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

	public static void main(String[] args) {
		Comparable[] a = {18,8,16,9,12,5,7,2,4,14,6,1,11,3,10,13,15,19,17,20};
		print(a);
		sort(a);
		print(a);
		Comparable[] a1 = {5,2,4,6,1,3};
		print(a1);
		bottomUpMS(a1);
		print(a1);

	}

}
