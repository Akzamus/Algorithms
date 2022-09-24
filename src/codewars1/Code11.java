package codewars1;

import java.util.*;

public class Code11 {

    public static void main(String[] args) {
        int[] arr = new int[] {10, 30, 30 , 15, 21, 4, 7};
        int target = 25;
        Arrays.sort(arr);
        System.out.println(twoSum(arr, target));
    }

    private static String twoSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1 ; j != 0 && j != i; j--) {
                if(arr[i] + arr[j] == target)
                    return arr[i] + " " + arr[j];
            }
        }
        throw new IllegalArgumentException("Numbers not found");
    }
}
