package yandex.training3.dynamicProgramming.withTwoParameters;

import java.util.*;
import java.util.stream.Collectors;

public class NopWithResponseRecovery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        scanner.nextLine();
        List<Integer> seq1 = Arrays.stream(scanner.nextLine().split(" "))
                                   .map(Integer::parseInt)
                                   .collect(Collectors.toList());


        scanner.nextLine();
        List<Integer> seq2 = Arrays.stream(scanner.nextLine().split(" "))
                                   .map(Integer::parseInt)
                                   .collect(Collectors.toList());

        scanner.close();

        getLargestCommonSubsequence(seq1, seq2).forEach(e -> System.out.print(e + " "));
    }

    public static List<Integer> getLargestCommonSubsequence(List<Integer> seq1, List<Integer> seq2) {
        int width = seq1.size() + 1;
        int height = seq2.size() + 1;
        List<Integer> dp = new ArrayList<>(Collections.nCopies(width * height, 0));
        for (int i = 1; i < width; ++i) {
            for (int j = 1; j < height; ++j) {
                if (seq1.get(i - 1).equals(seq2.get(j - 1))) {
                    dp.set(i * height + j, dp.get((i - 1) * height + j - 1) + 1);
                } else {
                    dp.set(i * height + j, Math.max(dp.get((i - 1) * height + j), dp.get(i * height + j - 1)));
                }
            }
        }

        List<Integer> ret = new ArrayList<>();
        int i = seq1.size();
        int j = seq2.size();

        while (i != 0 && j != 0) {
            if (seq1.get(i - 1).equals(seq2.get(j - 1))) {
                ret.add(seq1.get(i - 1));
                --i;
                --j;
            } else if (dp.get(i * (seq2.size() + 1) + j - 1) > dp.get((i - 1) * (seq2.size() + 1) + j)) {
                --j;
            } else {
                --i;
            }
        }
        Collections.reverse(ret);
        return ret;
    }

}
