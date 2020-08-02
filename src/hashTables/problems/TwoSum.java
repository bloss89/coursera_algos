package hashTables.problems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static int[] twoSum(int[] a, int x) {
		int n = a.length;
		Map<Integer,Integer> m = new HashMap();
		for(int i=0;i<n;i++) {
			int k = a[i];
			int other = x-k;
			if(m.containsKey(other)) {
				return new int[] {other,k};
			}else {
				m.put(k, i);
			}
		}
		return new int[] {};
	}
	public static void main(String[] args) {
		int[] a = {1, 35, 4, 6, 10, 11};
		int x = 16;
		int[] y = twoSum(a, x);
		for(int i:y) {
			System.out.println(i);
		}

	}

}
