package offer.chapter2;

public class DoubleArrayFinding {

	/**
	 * 每次都跟二维数组的右上角比较，如果小于右上角数字，则排除这一列，如果大于右上角数字，则排除这一行
	 * @param target
	 * @param array
	 * @return
	 */
	public boolean find(int target, int[][] array) {
		
		boolean found = false;
		
		if (array == null) {
			return found;
		}
		
		int columns = array[0].length;
		int rows = array.length;
		
		if (rows > 0 && columns > 0) {
			int row = 0;
			int column = columns - 1;
			while(row < rows && column >= 0) {
				if (array[row][column] == target) {
					found = true;
					break;
				}else if(array[row][column] > target){
					column --;
				}else {
					row ++;
				}
			}
		}
		
		return found;
	}
	
	
	public static void main(String[] args) {
		
		int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		
		DoubleArrayFinding doubleArrayFinding = new DoubleArrayFinding();
		System.out.println("7 is in the array? " + doubleArrayFinding.find(7, array));
	}
	
	
}
