package offer.chapter2;

public class NumberOfOne {

	/**
	 * 规律： 把一个整数减去1， 再和原整数做与运算，会把该整数最右边的一个1变成0。 
	 * 那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
	 * @param n
	 * @return
	 */
	static int numberOf1(int n) {
		int count = 0;
		while(n > 0) {
			count ++;
			n = (n - 1) & n;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int n = 110;
		System.out.println("There is " + numberOf1(n) + " piece of 1 in " + n);
	}
}
