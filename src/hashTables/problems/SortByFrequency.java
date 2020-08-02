package hashTables.problems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortByFrequency {
	
	public static ArrayList<Integer> sortByFrequency(int arr[]) {
		int l1 = arr.length;
		Map<Integer, Integer> countMap = new LinkedHashMap<>();
		for (int i = 0; i < l1; i++) {
			if (countMap.containsKey(arr[i])) {
				countMap.put(arr[i], countMap.get(arr[i]) + 1);
			} else {
				countMap.put(arr[i], 1);
			}
		}
		ArrayList<Integer> result = new ArrayList<Integer>();
		countMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed().thenComparing(Map.Entry.<Integer, Integer>comparingByKey())).forEach(e -> {
			int key = e.getKey();
			int val = e.getValue();
			for (int i = 0; i < val; i++) {
				result.add(key);
			}
		});
		return result;
	}

	public static void main(String[] args) {
		 int arr1[]= {6,6,2,3,1,4,1,5,6,2,8,7,4,2,1,3,4,5,9,6};
		 ArrayList<Integer> result = sortByFrequency(arr1);
		 for(int i: result) {
			 System.out.println(i);
		 }

	}

}
