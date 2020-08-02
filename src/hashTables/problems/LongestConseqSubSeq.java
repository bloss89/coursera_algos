package hashTables.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConseqSubSeq {

	public static int findLongestConseqSubseq(int a[], int n){
		Map<Integer,Integer> hm = new HashMap<>();
		int max =0,prevMax=0;
		Arrays.sort(a);
		for(int i=0;i<n;i++) {
			if(hm.containsKey(a[i]-1) && !hm.containsKey(a[i])) {
				prevMax++;
				if(prevMax>max) {
					max=prevMax;
				}
			}else if(!hm.containsKey(a[i]-1)  && prevMax!=0) {
					prevMax=0;
			}
			hm.put(a[i],i);
		}
		return max+1;	    
    }
	public static void main(String[] args) {
		int a5[]= {86,77,15,93,35,86,92,49,21,62,27,90,59,63,26,40,26,72,36,11,68,67,29,82,30,62,23,67,35,29,2,22,58,69,67,93,56,11,42,29,73,21,19,84,37,98,24,15,70,13,26,91,80,56,73,62,70,96,81,5,25,84,27,36,5,46,29,13,57,24,95,82,45,14,67,34,64,43,50,87,8,76,78,88};
		System.out.println(findLongestConseqSubseq(a5,a5.length));

	}

}
