package fourthTerm.lab8;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode139 {
    public static void main(String[] args) {
        System.out.println(
                wordBreak("applepenapple", List.of("apple", "pen"))
        );
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
