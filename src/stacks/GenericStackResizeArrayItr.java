package stacks;

import java.util.Iterator;

public class GenericStackResizeArrayItr<Item> implements Iterable<Item>{
	Item[] stack;
	int index=0;
	
	public GenericStackResizeArrayItr(int cap) {
		stack = (Item[])new Object[cap];
	}

	public class ArrayIterator implements Iterator<Item>{
		private int i=index;
		@Override
		public boolean hasNext() {
			return (i>0);
		}

		@Override
		public Item next() {
			return stack[--i];
		}
		
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ArrayIterator();
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
		GenericStackResizeArrayItr<String> stack = new GenericStackResizeArrayItr<String>(5);
		stack.push("to");
		stack.push("be");
		stack.push("or");
		stack.push("not");
		stack.push("to");
		System.out.println("stack util is "+stack.size()+" out of "+stack.length());
		stack.push("be");
		System.out.println("stack util is "+stack.size()+" out of "+stack.length());
		//stack.print();
		System.out.println("-------------Iterator-----------");
		for(String s: stack) {
			System.out.println(s);
		}
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

		GenericStackResizeArrayItr<Integer> stack1 = new GenericStackResizeArrayItr<Integer>(5);
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		stack1.push(5);
		System.out.println("stack util is "+stack1.size()+" out of "+stack1.length());
		stack1.push(6);
		System.out.println("stack util is "+stack1.size()+" out of "+stack1.length());
		//stack1.print();
		System.out.println("-------------Iterator-----------");
		for(Integer s: stack1) {
			System.out.println(s);
		}
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
