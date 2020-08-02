package hashTables.problems;

import java.util.HashMap;
import java.util.Map;

public class EqualArrays {
	
	public static boolean check(long arr[],long brr[]){
		int n1= arr.length;
		int n2= brr.length;
		if(n1!=n2)
			return false;
		Map<Long,Integer> hm = new HashMap<>();
		for(int i=0;i<n1;i++) {
			hm.put(arr[i],hm.getOrDefault(arr[i], 0)+1);
		}
		for(int i=0;i<n1;i++) {
			long key = brr[i];
			if(!hm.containsKey(key))
				return false;
			else {
				int count = hm.get(key);
				if(count==0)
					return false;
				hm.put(key, --count);
			}
		}
	    return true;
	}

	public static void main(String[] args) {
		long[] a1= {4,1,4,2,4,2,3,3,3,4};
		long[] a2= {1,2,2,3,3,3,4,4,4,4};
		long[] a3= {1,2,2,3,3,3,4,4,4,3};
		if(check(a1,a2))
			System.out.println("a2 equal arrays");
		if(check(a1,a3))
				System.out.println("a3 equal arrays");

	}

}
