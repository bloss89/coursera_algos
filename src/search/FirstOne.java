package search;

public class FirstOne {

	public static int searchForFirstOne(int[] a, int l, int h) {	
		int x =1;
		int m=-1;
		if(h>=l) {
			m=l+(h-l)/2;
			if((m==0 || x>a[m-1]) && a[m]==x) return m;
			else if(x>a[m]) return searchForFirstOne(a,m+1,h);
			else return searchForFirstOne(a, l, m-1);
		}
		return m;
	}
	public static void main(String[] args) {
		int[] a = {0,0,0,1,0,1};
		System.out.println(searchForFirstOne(a,0,a.length));
	}

}
