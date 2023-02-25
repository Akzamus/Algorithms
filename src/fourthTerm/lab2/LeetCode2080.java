package fourthTerm.lab2;

import java.util.*;

public class LeetCode2080 {

    public static void main(String[] args) {
        int[] arr = {12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(arr);
        System.out.println(rangeFreqQuery.query(1, 2, 4));
        System.out.println(rangeFreqQuery.query(0, 11,33));
    }
}

class RangeFreqQuery {

    private Map<Integer, List<Integer>> map = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> indexes = map.get(value);
        if(
            indexes == null ||
            indexes.get(0) > right ||
            indexes.get(indexes.size() - 1) < left
        ) return 0;

        return upper(indexes, right) - lower(indexes, left) + 1;
    }

    public int lower(List<Integer> indexes, int key) {
        int left = 0,
            right = indexes.size() - 1;

        if(key < indexes.get(0)) return 0;

        while(left < right) {
            int mid = (left + right) / 2;

            if (indexes.get(mid) < key) left = mid + 1;
            else                        right = mid;
        }

        return right;
    }

    public int upper(List<Integer> indexes, int key) {
        int left = 0,
            right = indexes.size() - 1;

        if(key > indexes.get(right)) return right;

        while(left < right) {
            int mid = (left + right) / 2 + 1;
            if (indexes.get(mid) > key) right = mid - 1;
            else                        left = mid;
        }

        return left;
    }
}
