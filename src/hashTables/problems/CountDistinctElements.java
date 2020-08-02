package hashTables.problems;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctElements {

	public static ArrayList<Integer> countDistinct(int arr[], int k) {
		int n = arr.length;
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < k; i++)
			hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);
		list.add(hM.size());
		for (int i = k; i < n; i++) {
			if (hM.get(arr[i - k]) == 1) {
				hM.remove(arr[i - k]);
			}else
				hM.put(arr[i - k], hM.get(arr[i - k]) - 1);
			hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);
			list.add(hM.size());
		}
		return list;
	}
	public static void main(String[] args) {
		int arr[] = {1,2,1,3,4,2,3}; 
		int k = 4; 
		ArrayList<Integer> list = countDistinct(arr,k); 
		for(int i : list) {
			System.out.println(i);
		}

	}

}
