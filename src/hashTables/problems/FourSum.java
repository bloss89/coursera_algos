package hashTables.problems;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
	
	public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
	       ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	        int n = arr.length;
	        Arrays.sort(arr);
	        int l, r;
	        for(int i=0;i<n-3;i++) {
	            if(i!=0 && arr[i]==arr[i-1])
	                continue;
	        	for(int j=i+1;j<n-2;j++) {
	        	    if(j!=i+1 && arr[j]==arr[j-1])
	                    continue;
	        		l=j+1;
	        		r=n-1;
	        		while(l<r) {
	        			if(arr[i]+arr[j]+arr[l]+arr[r]==k) {
	        				System.out.println(arr[i]+"--"+arr[j]+"--"+arr[l]+"--"+arr[r]);
	        				ArrayList<Integer> tmpList = new ArrayList<Integer>();
	        				tmpList.addAll(Arrays.asList(arr[i],arr[j],arr[l],arr[r]));
	        				list.add(tmpList);
	        				l++;
	        				r--;
	        				while (arr[l] == arr[l - 1] && (l < r)) l ++; // skip duplicates
	                        while (arr[r] == arr[r + 1] && (l < r)) r --; // skip duplicates
	        			}else if(arr[i]+arr[j]+arr[l]+arr[r]<k) {
	        				l++;
	        			}else if(arr[i]+arr[j]+arr[l]+arr[r]>k) {
	        				r--;
	        			}
	        		}
	        	}
	        }
	        return list;
	    }

	public static void main(String[] args) {
		int[] a2= {88,84,3,51,54,99,32,60,76,68,39,12,26,86,94,39,95,70,34,78,67,1,97,2,17,92,52};
		fourSum(a2,179);

	}

}
