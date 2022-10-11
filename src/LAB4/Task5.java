package LAB4;

import java.util.Arrays;

public class Task5 {

    public int[] maxSubsequence(int[] nums, int k) {
        int[] result = new int[k];
        int[] temp = nums.clone();

        Arrays.sort(temp);

        final int limit = temp[temp.length - k];
        final int larger = (int) Arrays.stream(nums)
                                       .filter(num -> num > limit)
                                       .count();
        int equal = k - larger;
        int i = 0;

        for (int num : nums)
            if (num > limit) {
                result[i++] = num;
            } else if (num == limit && equal > 0) {
                result[i++] = num;
                equal--;
            }

        return result;
    }
}
