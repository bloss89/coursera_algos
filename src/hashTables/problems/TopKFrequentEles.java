package hashTables.problems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class TopKFrequentEles {
	static ArrayList<Integer> TopK(int[] arr, int k)  {
		//int[] arr = array.stream().mapToInt(i->i).toArray();
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
		countMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed().thenComparing(Map.Entry.<Integer, Integer>comparingByKey().reversed())).forEach(e -> {
			int key = e.getKey();
			int val = e.getValue();
			for (int i = 0; i < val; i++) {
				if(!result.contains(key) && result.size()<k)
					result.add(key);
				else
					break;
			}
		});
		return result;
	}

	public static void main(String[] args) {
		 int arr2[]= {8,1,1,2,2,3,3,3,4};
	     ArrayList<Integer> result = TopK(arr2,2);
		 for(int i: result) {
			 System.out.println(i);
		 }

	}

}
