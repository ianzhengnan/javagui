package offer.chapter2;

import java.util.ArrayDeque;
import java.util.Deque;

public class ListNode {

	private int value;
	private ListNode pNext;
	
	/**
	 * 循环方式，使用栈
	 * @param pHead
	 */
    static void printListReversing_interatively (ListNode pHead) {
		
		Deque<ListNode> nodes = new ArrayDeque<>();
		
		ListNode node = pHead;
		while(node != null) {
			nodes.push(node);
			node = node.pNext;
		}
		
		while(!nodes.isEmpty()) {
			node = nodes.getFirst();
			System.out.println(node.value);
			nodes.pop();
		}
		
	}
    
    /**
     * 递归方式， 能用栈的地方都可以使用递归？
     * @param pHead
     */
    static void printListReversing_recursively(ListNode pHead) {
    	
    	if(pHead != null) {
    		if (pHead.pNext != null) {
				printListReversing_recursively(pHead.pNext);
			}
    		System.out.println(pHead.value);
    	}
    }
	
	public static void main(String[] args) {
		ListNode first = new ListNode();
		ListNode nodes = first;
		int[] array = {12,3,2,5,9,3,2,1};
		for (int i = 0; i < array.length; i++) {
			nodes.value = array[i];
			if(i + 1 < array.length) {
				nodes.pNext = new ListNode();
				nodes = nodes.pNext;
			}
		}
//		ListNode.printListReversing_interatively(first);
		ListNode.printListReversing_recursively(first);
	}
	
	
	
}
