package sorting.shellSort;

public class ShellSort {
			
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
				int h=1;
				while(h<n/3) {
					h = 3*h + 1;
				}
				while(h>=1) {
					for(int i=h;i<n;i++) {
						for(int j=i;j>=h && less(a[j],a[j-h]);j-=h) {
								exchange(a,j,j-h);
						}
					}
					h = h/3;
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
				//Comparable[] a = {5,7,2,4,6,8,1,3,9};
				Comparable[] a = {5,2,4,6,1,3};
				print(a);
				ShellSort insertionSort = new ShellSort();
				insertionSort.sort(a);
				print(a);
			}

}
