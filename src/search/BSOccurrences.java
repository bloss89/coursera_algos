package search;

public class BSOccurrences {
	
	public static int getLeftPos(int[] a, int l, int h, int x) {	
		int m=-1;
		if(h>=l) {
			m=l+(h-l)/2;
			if((m==0 || x>a[m-1]) && a[m]==x) return m;
			else if(x>a[m]) return getLeftPos(a,m+1,h,x);
			else return getLeftPos(a, l, m-1, x);
		}
		return m;
	}
	public static int getRightPos(int[] a,int l, int h, int x) {
		int m=-1, n = a.length;
		if(h>=l) {
			m=l+(h-l)/2;
			if((m==n-1 || x<a[m+1]) && a[m]==x) return m;
			else if(x<a[m]) return getRightPos(a, l, m-1, x);
			else return getRightPos(a,m+1,h,x);
		}
		return m;
	}
	public static int countOccurances(int[] a, int x) {
		int n = a.length;
		int l = getLeftPos(a,0,n-1, x);
		int r = getRightPos(a,0,n-1, x);
		return (a[l]==x && a[r]==x)? (r-l+1):0;
		
	}
	
	/////////iterative
	public static int getLeftPosItr(int[] a, int x) {		
		int l=-1,r=a.length-1,m;
		while(r-l>1) {
			m = l +(r-l)/2;
			if(a[m]>=x)
				r=m;
			else
				l=m;
		}
		return r;
	}
	public static int getRightPosItr(int[] a, int x) {
		int l=0,r=a.length,m;
		while(r-l>1) {
			m = l +(r-l)/2;
			if(a[m]<=x)
				l=m;
			else
				r=m;
		}
		return l;
	}
	public static int countOccurancesItr(int[] a, int x) {
		int l = getLeftPosItr(a, x);
		int r = getRightPosItr(a, x);
		return (a[l]==x && a[r]==x)? (r-l+1):0;
		
	}

	public static void main(String[] args) {
		int[] d = {1,2,2,3,5,5,5};
		System.out.println(countOccurances(d, 5));
		System.out.println(countOccurancesItr(d, 5));

	}

}
