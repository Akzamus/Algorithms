package yandex.training3.dynamicProgramming.withOneParameter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int N = in.nextInt();
        in.close();

        int[] minNumOp = new int[N + 1];
        int n = N;
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            int minimal = minNumOp[i - 1] + 1;

            if(i % 2 == 0) {
                minimal = Math.min(minimal, minNumOp[i / 2] + 1);
            }

            if(i % 3 == 0) {
                minimal = Math.min(minimal, minNumOp[i / 3] + 1);
            }

            minNumOp[i] = minimal;
        }

        result.add(n);

        while (n > 1) {
            if      (minNumOp[n] == minNumOp[n - 1] + 1)               n -= 1;
            else if (n % 2 == 0 && minNumOp[n] == minNumOp[n / 2] + 1) n /= 2;
            else                                                       n /= 3;
            result.add(n);
        }

        Collections.reverse(result);
        System.out.println(minNumOp[N]);
        result.forEach(num -> System.out.print(num + " "));
    }
}
