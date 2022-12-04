package LAB5;

import java.util.Arrays;

public class Task4 {
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Given Array: " + Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void merge(int arr[], int l, int m, int r) {
        final int LEN1 = m - l + 1;
        final int LEN2 = r - m;

        int L[] = new int[LEN1];
        int R[] = new int[LEN2];

        for (int i = 0; i < LEN1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < LEN2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;
        while (i < LEN1 && j < LEN2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < LEN1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < LEN2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
}
