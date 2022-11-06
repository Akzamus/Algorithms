package LAB5;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0 ; i< s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (map.containsKey(a)) {
                if (!map.get(a).equals(b)) return false;
            } else {
                if (!map.containsValue(b)) map.put(a, b);
                else                       return false;
            }
        }
        return true;
    }
}
