package stacks;

public class StackResizeArray {
	String[] stack;
	int index=0;
	
	public StackResizeArray(int cap) {
		stack = new String[cap];
	}
	
	public void push(String s) {
		int l = stack.length;
		if(index==l) {//full array-double size
			resize(2*l);
		}
		stack[index++] = s;
	}
	public int size() {
		return index;
	}
	public int length() {
		return stack.length;
	}
	public boolean isEmpty() {
		return (index==0);
	}
	public String pop() {
		if(isEmpty()) {
			System.out.println("stack empty");
			return "";
		}
		int l = stack.length;
		if(index<=l/4) {//25% of array is filled-half the array
			resize(l/2);
		}
		String s = stack[--index];
		stack[index] = null;
		return s;
	}
	public void print() {
		System.out.println("============================");
		for(int i=0;i<index;i++) {
			System.out.println(stack[i]);
		}
	}
	
	public void resize(int cap) {
		String copy[] = new String[cap];
		for(int i=0;i<index;i++) {
			copy[i]=stack[i];
		}
		stack = copy;
	}

	
	public static void main(String[] args) {
		StackResizeArray stack = new StackResizeArray(5);
		stack.push("to");
		stack.push("be");
		stack.push("or");
		stack.push("not");
		stack.push("to");
		System.out.println("stack util is "+stack.size()+" out of "+stack.length());
		stack.push("be");
		System.out.println("stack util is "+stack.size()+" out of "+stack.length());
		stack.print();
		stack.pop();
		stack.pop();
		stack.print();
		System.out.println("stack util is "+stack.size()+" out of "+stack.length());
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.print();
		System.out.println("stack util is "+stack.size()+" out of "+stack.length());



	}

}
