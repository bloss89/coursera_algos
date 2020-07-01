package stacks;

public class GenericStackResizeArray<Item> {
	Item[] stack;
	int index=0;
	
	public GenericStackResizeArray(int cap) {
		stack = (Item[])new Object[cap];
	}
	
	public void push(Item s) {
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
	public Item pop() {
		if(isEmpty()) {
			System.out.println("stack empty");
			return null;
		}
		int l = stack.length;
		if(index<=l/4) {//25% of array is filled-half the array
			resize(l/2);
		}
		Item s = stack[--index];
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
		Item copy[] = (Item[])new Object[cap];
		for(int i=0;i<index;i++) {
			copy[i]=stack[i];
		}
		stack = copy;
	}

	
	public static void main(String[] args) {
		GenericStackResizeArray<String> stack = new GenericStackResizeArray<String>(5);
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
		
		//Integer

		GenericStackResizeArray<Integer> stack1 = new GenericStackResizeArray<Integer>(5);
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		stack1.push(5);
		System.out.println("stack util is "+stack1.size()+" out of "+stack1.length());
		stack1.push(6);
		System.out.println("stack util is "+stack1.size()+" out of "+stack1.length());
		stack1.print();
		stack1.pop();
		stack1.pop();
		stack1.print();
		System.out.println("stack util is "+stack1.size()+" out of "+stack1.length());
		stack1.pop();
		stack1.pop();
		stack1.pop();
		stack1.pop();
		stack1.pop();
		stack1.print();
		System.out.println("stack util is "+stack1.size()+" out of "+stack1.length());



	}

}
