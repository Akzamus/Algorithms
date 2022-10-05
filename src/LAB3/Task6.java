package LAB3;

import java.util.ArrayList;

public class Task6 {


    public int firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        boolean flag = true;

        for (int i = 0; i < arr.length; i++, flag = true) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j] && i != j) {
                    flag = false;
                    break;
                }
            }

            if(flag) return i;
        }
        return -1;
    }
}
