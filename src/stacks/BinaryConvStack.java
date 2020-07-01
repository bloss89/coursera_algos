package stacks;

import java.util.Iterator;

public class BinaryConvStack {
	
	public String convert(int n) {
		GenericStackResizeArrayItr<Integer> bitStack = new GenericStackResizeArrayItr<Integer>(5);
		StringBuffer sb = new StringBuffer();
		while(n>0) {
			bitStack.push(n%2);
			n=n/2;
		}
		Iterator<Integer> itr = bitStack.iterator();
		while(itr.hasNext()) {
			Integer i = bitStack.pop();
			if(i==null)
				break;
			sb.append(i);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		BinaryConvStack stack = new BinaryConvStack();
		int i = 50;
		System.out.println(i+" in binary is "+ stack.convert(i));
		i=12345678;
		System.out.println(i+" in binary is "+ stack.convert(i));
	}

}
