package stacks;

import java.util.Arrays;
import java.util.List;

public class TwoStackDijkstra {
	
	public int arith(int a, int b, String opr) {
		if(opr.equals("+")) {
			return a+b;
		}else if(opr.equals("-")) {
			return b-a;
		}else if(opr.equals("*")) {
			return a*b;
		}else if(opr.equals("/")) {
			return b/a;
		}else if(opr.equals("%")) {
			return b%a;
		}
		return -1;
	}
	public int evaluate(String arith) {
		String[] operators = {"+","-","*","/","%"};
		List oprList = Arrays.asList(operators);
		GenericStackResizeArrayItr<Integer> valStack = new GenericStackResizeArrayItr<Integer>(5);
		GenericStackResizeArrayItr<String> oprStack = new GenericStackResizeArrayItr<String>(5);
		String[] arithExpr = arith.split("");
		for(String item : arithExpr) {
			if(oprList.contains(item)) {				
				oprStack.push(item);
			}else if(item.equals(")")) {
				valStack.push(arith(valStack.pop(), valStack.pop(), oprStack.pop()));
			}else if(item.equals("(")) {
				continue;
			}else {
				valStack.push(Integer.parseInt(item));
			}
		}
		return valStack.pop();
	}

	public static void main(String[] args) {
		TwoStackDijkstra twoStack = new TwoStackDijkstra();
		String s = "((1+2)*(5-3))";
		System.out.println("value of "+ s + " is "+twoStack.evaluate(s));
		s = "(((1+2)*(5-3))/((1+2)*(5-3)))";
		System.out.println("value of "+ s + " is "+twoStack.evaluate(s));
	}

}
