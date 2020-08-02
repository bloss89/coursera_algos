package hashTables.problems;

import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class RelativeSorting {

	public static void sortA1ByA2(int a1[], int a2[]) {
		int n1 = a1.length, n2 = a2.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n1; i++) {
			map.put(a1[i], map.getOrDefault(a1[i], 0) + 1);
		}
		int c = 0;
		for (int i = 0; i < n2; i++) {
			if (map.containsKey(a2[i])) {
				int tmp = map.get(a2[i]);
				map.remove(a2[i]);
				for (int j = 0; j < tmp; j++) {
					a1[c] = a2[i];
					c++;
				}
			}
		}
		SortedSet<Integer> keySet = new TreeSet<>(map.keySet());
		for (int i : keySet) {
			int tmp = map.get(i);
			for (int j = 0; j < tmp; j++) {
				a1[c] = i;
				c++;
			}
		}
	}
	public static void printArray(int[] b1) {
        for(int i: b1) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		int[] d1= {45,15,23,8,5,12,26,444,888,151,12,23,45,15,56};
    	int[] d2= {15,888,444,5,8,12,23};
        sortA1ByA2(d1,d2);
        printArray(d1);

	}

}
