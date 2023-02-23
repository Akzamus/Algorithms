package yandex.training3.warmup.histogram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Histogram {

    private static final String inputPath = "src/yandexTraining3/Histogram/input.txt";
    private static final String outputPath = "src/yandexTraining3/Histogram/output.txt";

    public static void main(String[] args) {
        try {
            String input = readFile(inputPath).replaceAll(" ", "");
            printHistogram(input);
        } catch (IOException e) {
            System.out.println("ERROR: Input file not found!");
        }
    }

    private static void printHistogram(String input) {
        Map<Character, Integer> map = new TreeMap<>();
        int maxCount = 0;

        for(char chI : input.toCharArray()) {
            if(!map.containsKey(chI)) {
                int count = (int)input.chars()
                                      .filter(chJ -> chI == chJ)
                                      .count();
                if(count > maxCount) maxCount = count;
                map.put(chI, count);
            }
        }
        int len = maxCount  + 1;
        String[] lines = new String[len];
        Arrays.fill(lines, "");

        for(Map.Entry<Character, Integer> item : map.entrySet()) {
            lines[len - 1] = lines[len - 1].concat(String.valueOf(item.getKey()));
            int value = maxCount - item.getValue();
            for (int i = len - 2; i >= 0; i--) {
                if(value <= i) lines[i] = lines[i].concat("#");
                else           lines[i] = lines[i].concat(" ");
            }
        }

        String output = Arrays.stream(lines).collect(Collectors.joining("\n"));

        try(FileWriter fWriter = new FileWriter(outputPath)) {
            fWriter.write(output);
        } catch (IOException e) {
            System.out.println("ERROR: Output file not found!");
        }
    }

    private static String readFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        return reader.lines().collect(Collectors.joining(""));
    }

}
