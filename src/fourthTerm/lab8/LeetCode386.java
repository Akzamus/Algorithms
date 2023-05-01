package fourthTerm.lab8;

import java.util.ArrayList;
import java.util.List;

public class LeetCode386 {
    public static void main(String[] args) {
        System.out.println(
                lexicalOrder(13)
        );
    }

    private static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        int curr = 1;

        for (int i = 1; i <= n; i++) {
            result.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }

        return result;
    }
}
