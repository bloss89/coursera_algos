package sorting.selectionSort;

public class SelectionSort {
	
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
		int min = 0;
		for(int j=0;j<n;j++) {
			min = j;
			for(int i=j+1;i<n;i++) {
				if(less(a[i],a[min])){
					min = i;
				}		
			}
			exchange(a,min,j);
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
		Comparable[] a = {5,2,4,6,1,3};
		print(a);
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.sort(a);
		print(a);
	}

}
