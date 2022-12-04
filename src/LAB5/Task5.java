package LAB5;

import java.util.Arrays;

public class Task5 {

    public static void main(String[] args) {
        int[] arr = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };
        int low = 0;
        int high = arr.length - 1;

        System.out.println("Given Array: " + Arrays.toString(arr));
        quickSort(arr, low, high);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void quickSort(int[] array, int left, int right) {
        if (array.length == 0 || left >= right) return;

        int middle = left + (right - left) / 2;
        int support = array[middle];
        int i = left, j = right;

        while (i <= j) {
            while (array[i] < support) {
                i++;
            }

            while (array[j] > support) {
                j--;
            }

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (left < j)
            quickSort(array, left, j);

        if (right > i)
            quickSort(array, i, right);
    }
}
