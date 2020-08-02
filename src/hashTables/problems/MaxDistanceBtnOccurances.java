package hashTables.problems;

import java.util.HashMap;
import java.util.Map;

public class MaxDistanceBtnOccurances {	

	public static int maxDistance(int arr[], int n)	{
		Map<Integer,Integer> hm = new HashMap<>();
		int max =0,prevMax=0;
		for(int i=0;i<n;i++) {
			if(hm.containsKey(arr[i])) {
				prevMax = i-hm.get(arr[i]);
				if(prevMax>max)
					max=prevMax;
			}else
				hm.put(arr[i],i);
		}
		return max;
	}
	

	public static void main(String[] args) {
		int a4[]= {3,2,1,2,1,4,5,8,6,7,4,2};
		System.out.println(maxDistance(a4, 12));

	}

}
