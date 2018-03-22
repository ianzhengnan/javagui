/**
 *  获取整数的二进制中1的个数
 *  利用位运算，判断二进制最右边一位是否为1，用和1作与运算即可得出
 *  每次右移一位，知道全部为0
 */

package offer.chapter2;


public class BineryCounter {
	
	static final int num = 42;

	public static void main(String[] args) {
				
		System.out.println(numberOf1(num));
		System.out.println(numOf1(num));
		System.out.println(numbOf1(num));
	}
	
	/**
	 * 负数的时候计算的值不正确
	 * @param n
	 * @return
	 */
	public static int numberOf1(int n) {
		
		int count = 0;
		while(n > 0) {
			if((n & 1) != 0)
				count++;
			n = n >> 1;
		}
		
		return count;
	}
	
	/**
	 * 可以处理正负数
	 * @param n
	 * @return
	 */
	public static int numOf1(int n){
		int count = 0;
		int flag = 1;
		while(flag > 0) {
			if((n & flag) != 0)
				count++;
			flag = flag << 1;
		}
		return count;
	}
	
	/**
	 * 更好的方法
	 * 这个数和自己减一的数按位与运算后可以使最右边的1变成0
	 * 但是不能处理负数
	 */
	public static int numbOf1(int n) {
		int count = 0;
		while(n > 0) {
			++count;
			n = (n - 1) & n;
		}
		return count;
	}
	
}
