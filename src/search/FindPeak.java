package search;

public class FindPeak {
	
	public static int findPeak(int a[], int l, int h){
		int n = a.length;
	    int m = l + (h - l)/2;	  
	    if ((m == 0 || a[m-1] <= a[m]) && (m == n-1 || a[m+1] <= a[m]))
	        return a[m];
	    else if (m > 0 && a[m-1] > a[m])
	        return findPeak(a, l, (m -1));
	    else
	        return findPeak(a, (m + 1), h);
	} 

	public static void main(String[] args) {
		int[] a = {0, 3, 4, 5, 14, 30, 9};
		int[] b = {1, 5, 3, 2, 14, 4, 9};
		System.out.println(findPeak(a,0,a.length));
		System.out.println(findPeak(b,0,b.length));

	}

}
