package hashTables.problems;

import java.util.HashMap;

public class ZeroSumSubCount {

	public static int findSubarrayCount(int[] nums ,int n) 	{
		int count = 0, sum = 0;
        HashMap <Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum))
                count += map.get(sum);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
	}
	public static void main(String[] args) {
		int arr4[]= {9,-10,-1,5,17,-18,6,19,-12,5,18,14,4,-19,11,8,-19,18,-20,14,8,-14,12,-12,16,-11,0,3,-19,16};
        System.out.println(findSubarrayCount(arr4, arr4.length));

	}

}
