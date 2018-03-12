package arithmetic;

public class BinarySearch {

	public static int rank(int key, int[] a) {
		return rank(key, a, 0, a.length -1);
	}
	
	public static int rank(int key, int[]a, int lo, int hi) {
		if (lo > hi) {
			return -1;
		}
		int mid = lo + (hi - lo) / 2;
		
		return mid;
	}
	
	public static void main(String[] args) {
		
//		int[] a = {5,4,1,2,3,8,7,6};
		
		int mid = 1 + (7 - 2) / 2;
		System.out.println(mid);
		
	}
}
