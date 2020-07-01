package stacks;

import stacks.StackLL.Node;

public class StackA {
	
	int[] stack;
	int index=0;
	
	public StackA(int cap) {
		stack = new int[cap];
	}
	
	public void push(int v) {
		stack[index++] = v;
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("stack empty");
			return Integer.MIN_VALUE;
		}
		return stack[--index];
	}
	
	public boolean isEmpty() {
		return (index==0);
	}
	
	public int size() {
		return index;
	}

	public void print() {
		System.out.println("============================================");
		for(int j=index-1;j>=0;j--) {
			System.out.println(stack[j]);
		}
	}
	public static void main(String[] args) {

		StackA stack = new StackA(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.print();
		stack.pop();
		stack.pop();
		stack.print();
		System.out.println("size is "+stack.size());
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();


	}

}
