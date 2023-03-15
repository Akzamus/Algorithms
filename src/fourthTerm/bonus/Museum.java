package fourthTerm.bonus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Museum {
    private static final String inputPath = "src/fourthTerm/bonus/input.txt";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            int[] numVisitors = new int[1440];

            reader.lines()
                  .skip(1)
                  .map(s -> {
                      String[] times = s.split(" ");
                      return new int[]{
                              getTimeInMinutes(times[0]),
                              getTimeInMinutes(times[1])
                      };
                  })
                  .forEach(minutes -> Arrays.fill(
                          numVisitors,
                          minutes[0],
                          minutes[1],
                          numVisitors[minutes[0]] + 1
                  ));

            System.out.println(
                    Arrays.stream(numVisitors).max().getAsInt()
            );
        }
    }

    public static int getTimeInMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
