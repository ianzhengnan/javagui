package offer.chapter2;

import java.util.Stack;

public class MyQueue {

	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();
	
	public void appendTail(Integer node) {
		stack1.push(node);
	}
	
	public Integer deleteHead() {
		
		if (stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
	
	public void printQueue() {
		for (int i = 0; i < stack2.capacity(); i++) {
			System.out.println(stack2.get(i));
		}
		for (int i = 0; i < stack1.capacity(); i++) {
			System.out.println(stack1.get(i));
		}
	}
	
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.appendTail(1);
		queue.appendTail(2);
		queue.appendTail(3);
		System.out.println("queue delete head " + queue.deleteHead());
		queue.appendTail(4);
		System.out.println("queue delete head " + queue.deleteHead());
		System.out.println("queue delete head " + queue.deleteHead());
		
//		queue.printQueue();
	}
}
