package LAB1;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Task1 {

    public static void main(String[] args) {
        System.out.println(isValid("({)}"));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put(')', '(');
        bracketsMap.put('}', '{');
        bracketsMap.put(']', '[');

        Deque<Character> deque = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (bracketsMap.containsValue(c)) {
                deque.push(c);
            } else if (bracketsMap.containsKey(c)) {
                if (deque.isEmpty() || deque.pop() != bracketsMap.get(c))
                    return false;
            }
        }
        return deque.isEmpty();
    }
}
