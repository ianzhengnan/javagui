package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicateNumbers {

    /**
     * time complexity: o(n log n) but it will change the array by sorting it
     * @param nums
     * @return
     */
    public boolean getDuplicateNums (int[] nums){
        if (nums == null || nums.length == 0)
            return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    /**
     * time complexity: o(n)
     * space complexity: o(n)
     * @param nums
     * @return
     */
    public boolean getDuplicateNumsHash(int[] nums){
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (sets.contains(nums[i]))
                return true;
            sets.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,14,18,22,22};
        DuplicateNumbers duplicateNumbers = new DuplicateNumbers();
//        boolean result = duplicateNumbers.getDuplicateNums(nums);
        boolean result = duplicateNumbers.getDuplicateNumsHash(nums);

        System.out.println("The result is " + result);
    }
}
