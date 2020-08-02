package hashTables.problems;

import java.util.HashMap;

public class LargestSubWithSumZero {
	
	public static int maxLen(int arr[], int n) {
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
		int sum = 0,maxLength = 0; 
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (arr[i] == 0 && maxLength == 0)
				maxLength = 1;
			if (sum == 0)
				maxLength = i + 1;
			Integer prevIndx = hM.get(sum);
			if (prevIndx != null)
				maxLength = Math.max(maxLength, i - prevIndx);
			else 
				hM.put(sum, i);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		int a6[]= {67,-3,3,-10,1,9,13,56};
		System.out.println(maxLen(a6, a6.length));

	}

}
