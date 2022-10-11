package LAB4;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Task3 {

    public <K, V extends Comparable<V>> int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 0) {
                    map.put(i, j);
                    break;
                } else if(j + 1 == mat[i].length) {
                    map.put(i, j + 1);
                }
            }
        }

        return sortByValues(map).keySet()
                                .stream()
                                .limit(k)
                                .mapToInt(Integer::intValue)
                                .toArray();
    }

    public <K, V extends Comparable<V>> Map<K, V> sortByValues (final Map<K, V> map) {
        Comparator<K> valueComparator = (k1, k2) -> {
            int comp = map.get(k1).compareTo(map.get(k2));
            if(comp == 0) return 1;
            else return comp;
        };
        Map<K, V> sorted = new TreeMap<>(valueComparator);
        sorted.putAll(map);
        return sorted;
    }
}
