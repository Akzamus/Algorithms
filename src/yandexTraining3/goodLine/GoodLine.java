package yandexTraining3.goodLine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class GoodLine {

    private static final String inputPath = "src/yandexTraining3/goodLine/input.txt";

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(inputPath));
        long[] quantity = reader.lines().skip(1).mapToLong(Long::parseLong).toArray();


        long[] sort = Arrays.stream(quantity).distinct().sorted().toArray();
        long[] sortCopy = sort.clone();

        for (int i = 1; i < sort.length; i++)
            sort[i] -= sortCopy[i - 1];

        long result = 0;
        int count = 0;

        for (long val : sort) {
            for (int j = 0; j < quantity.length; j++) {
                if (quantity[j] != 0) {
                    quantity[j] -= val;
                    count++;
                } else if (count != 0) {
                    result += val * (count - 1);
                    count = 0;
                }
            }

            if (count != 0) {
                result += val * (count - 1);
                count = 0;
            }
        }
        System.out.println(result);
    }
}

