package edu.princeton.cs.algs4;

public class BinaryTreeNode {

	private int value;
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	
	public static BinaryTreeNode constructor(int[] preorder, int[] inorder, int length) {
		
		if (preorder == null || inorder == null || length <= 0) {
			return null;
		}
		
		return constructcore(preorder, length - 1, 0, length - 1);
	}
	
	public static BinaryTreeNode constructcore(int[] startPreorder, int endPreorder, int startInorder, int endInorder) {
		
		return null;
	}
	
	
	public static void main(String[] args) {
		
	}
}
