package offer.chapter2;

public class MinNumber {

	private int[] array = {10,14,15,16,4,5,6,7,8,9,10};
	
	public int min(int[] numbers, int length) throws Exception {
		
		if (numbers == null || length <= 0) {
			throw new Exception("Invalid parameters");
		}
		
		int index1 = 0;
		int index2 = length - 1;
		int indexMid = index1;
		while(numbers[index1] >= numbers[index2]) {
			if (index2 - index1 == 1) {
				indexMid = index2;
				break;
			}
			indexMid = (index1 + index2) / 2;
			if (numbers[indexMid] >= numbers[index1])
				index1 = indexMid;
			else if(numbers[indexMid] <= numbers[index2])
				index2 = indexMid;
		}
		return numbers[indexMid];
	}
	
	public static void main(String[] args) throws Exception{
		
		MinNumber minNumber = new MinNumber();
		System.out.println("The min number is " + minNumber.min(minNumber.array, minNumber.array.length));
	}
}
