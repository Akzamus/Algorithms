package LAB4;

import java.util.Arrays;

public class Task10 {

    public static void main(String[] args) {
        insertionSort(new int[] {2, 7, 4, 1, 8, 1});
    }

    public static void insertionSort(int arr[]) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }
}
