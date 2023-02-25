package fourthTerm.lab3;

import java.util.*;

public class LeetCode128 {

    public static void main(String[] args) {
        int[] nums = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        System.out.println(longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> set = new TreeSet<>();
        Arrays.stream(nums).forEach(set::add);
        List<Integer> list = new ArrayList<>(set);
        System.out.println(list);

        int maxLen = 1;
        int len = 1;

        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) == list.get(i - 1) + 1) {
                len++;
            } else {
                maxLen = Math.max(maxLen, len);
                len = 1;
            }
        }

        return Math.max(len, maxLen);
    }
}
