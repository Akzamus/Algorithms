package codewars1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Code2 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
        int[] b = new int[]{1};
        List<Integer> listA = new ArrayList<>() {{ for (int i : a) add(i); }};
        List<Integer> listB = new ArrayList<>() {{ for (int i : b) add(i); }};
        System.out.println(listA);
        System.out.println(listB);
        char x = 'a';
        char y = 'a';
        String s = x + String.valueOf(y);
        System.out.println(s);
        int[] arr = new int[listA.size()];
        int j = 0;
        for(Integer i : listB){
            arr[j] = i;
            j++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
