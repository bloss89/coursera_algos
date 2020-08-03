package search;

public class TernarySearch {

	public static int ternarySearch(int l, int r, int key, int ar[]) { 
	    if (r >= l) { 
	        int mid1 = l + (r - l) / 3; 
	        int mid2 = r - (r - l) / 3; 
	        if (ar[mid1] == key)
	            return mid1; 
	        if (ar[mid2] == key) 
	            return mid2; 
	        if (key < ar[mid1])  
	            return ternarySearch(l, mid1 - 1, key, ar); 
	        else if (key > ar[mid2])  
	            return ternarySearch(mid2 + 1, r, key, ar); 
	        else
	            return ternarySearch(mid1 + 1, mid2 - 1, key, ar); 
	    } 
	    return -1; 
	} 

	public static void main(String[] args) {
		int[] a= {15,888,444,5,8,12,23};
		System.out.println(ternarySearch(0, a.length, 12, a));
	}

}
