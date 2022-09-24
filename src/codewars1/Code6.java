package codewars1;

import java.util.Arrays;
import java.util.Collections;

public class Code6 {
    public static void main(String[] args) {
        int[] a = new int[]{1,1,2};
        int i = Arrays.stream(a).filter(x -> Collections.frequency(Arrays.stream(a).boxed().toList(), x) % 2 != 0).findFirst().getAsInt();
        System.out.println(i);
    }
}
