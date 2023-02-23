package yandex.training3.warmup;
import java.util.*;

public class CollectorDiego {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        in.nextLine();
        int[] cards = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .distinct()
                .sorted()
                .toArray();
        in.nextLine();
        int[] requests = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        in.close();

        for (int num : requests)
            System.out.println(binarySearch(cards, num));
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
