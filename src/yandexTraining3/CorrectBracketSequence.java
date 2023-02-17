package yandexTraining3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class CorrectBracketSequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(
                isCorrectBracketSequence(in.nextLine()) ? "yes" : "no"
        );
    }

    private static boolean isCorrectBracketSequence(String str) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for(char ch : str.toCharArray()) {
            if(map.containsValue(ch)) stack.add(ch);
            else if(
                    stack.size() == 0 ||
                    map.get(ch) != stack.pop()
                   ) return false;
        }
        return stack.size() == 0;
    }
}
