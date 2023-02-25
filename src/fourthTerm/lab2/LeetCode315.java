package fourthTerm.lab2;

import java.util.*;

public class LeetCode315 {

    public static void main(String[] args) {
        System.out.println(countSmaller(new int[]{5, 2, 6, 1, 7, 3, 2, 8, 5}));
    }

    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if(sorted.isEmpty()){
                sorted.add(nums[i]);
                result.add(0);
            }else if(nums[i] > sorted.get(sorted.size() - 1)) {
                sorted.add(sorted.size(), nums[i]);
                result.add(sorted.size() - 1);
            }else{
                int l = 0;
                int r = sorted.size() - 1;

                while(l < r){
                    int m = l + (r - l) / 2;
                    if (nums[i] > sorted.get(m)) l = m + 1;
                    else                         r = m;
                }

                sorted.add(r, nums[i]);
                result.add(r);
            }
        }

        Collections.reverse(result);
        return result;
    }
}
