package LAB4;

import java.util.Arrays;

public class Task9 {

    public static void main(String[] args) {
        selectionSort(new int[] {2, 7, 4, 1, 8, 1});
    }

    public static void selectionSort(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {
            int indexMin = i;

            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[indexMin])
                    indexMin = j;

            int temp = arr[indexMin];
            arr[indexMin] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
