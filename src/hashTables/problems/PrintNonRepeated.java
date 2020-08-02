package hashTables.problems;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintNonRepeated {
	
	static ArrayList<Integer> printNonRepeated(int arr[]){
		int n = arr.length;
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			int val = arr[i];
			if(!hM.containsKey(val)) {
				hM.put(val,i);
				list.add(val);
			}else {
				list.remove((Integer)val);
			}
		}
        return list;
    }
	public static void main(String[] args) {
		int arr[]= {1,1,2,2,3,3,4,5,6,7};
		ArrayList<Integer> list = printNonRepeated(arr);
		for(int i:list) {
			System.out.println(i);
		}

	}

}
