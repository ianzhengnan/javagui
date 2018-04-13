package offer.chapter2;

public class Fibonacci {

	/**
	 * 从下往上计算
	 * @param n
	 * @return
	 */
	public static long getFib(int n) {
		
		int[] result = {0, 1};
		if(n < 2)
			return result[n];
		
		long fibNMinusOne = 1;
		long fibNMinusTwo = 0;
		long fibN = 0;
		
		for (int i = 2; i <= n; i++) {
			fibN = fibNMinusOne + fibNMinusTwo;
			
			fibNMinusTwo = fibNMinusOne;
			fibNMinusOne = fibN;
		}
		
		return fibN;
	}
	
	/**
	 * 递归的方式，性能很差, 因为有很多重复计算（ 可以把它理解为从根节点构建一棵二叉树 ）
	 * 计算100的斐波那契数需要很久。。。。
	 * @param n
	 * @return
	 */
	public static long getFib_recu(int n) {
		
		if(n <= 0) 
			return 0;
		if(n == 1)
			return 1;
		
		return getFib_recu(n - 1) + getFib_recu(n - 2);
	}
	
	public static void main(String[] args) {
		System.out.println(getFib(100));
		System.out.println(getFib_recu(100));
	}
}
