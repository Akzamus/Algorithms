package fourthTerm.bonus.cup;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Cup {
    private static final String INPUT_PATH = "src/fourthTerm/bonus/cup/input.txt";
    private static List<Integer> result = new ArrayList<>();
    private static int[] min = {1301};

    private static int[][] distanceMatrix;
    private static int[] timeToSpendInEachCity;
    private static int numberOfCitiesToChoose;
    private static int numberOfCities;

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH))) {
            String[] firstLine = reader.readLine().split(" ");
            numberOfCities = Integer.parseInt(firstLine[0]);
            numberOfCitiesToChoose = Integer.parseInt(firstLine[1]);

            distanceMatrix = readDistanceMatrix(reader);
            timeToSpendInEachCity = readTimeToSpendInEachCity(reader);

            findMinimumPath();
            printResults();
        }
    }

    private static void findMinimumPath() {
        List<Integer> path = new ArrayList<>();
        List<Boolean> used = new ArrayList<>(Collections.nCopies(numberOfCities, false));

        for (int first = 0; first < numberOfCities; first++) {
            used.set(first, true);
            path.add(first);
            go(first, timeToSpendInEachCity[first], path, used);
            path.remove(path.size() - 1);
            used.set(first, false);
        }
    }

    private static void go(int city, int sum, List<Integer> path, List<Boolean> used) {
        if (path.size() == numberOfCitiesToChoose) {
            if (sum < min[0]) {
                min[0] = sum;
                result.clear();
                result.addAll(path);
            }
            return;
        }

        for (int i = 0; i < used.size(); i++) {
            if (used.get(i)) continue;
            used.set(i, true);
            path.add(i);
            int newSum = sum + distanceMatrix[city][i] + timeToSpendInEachCity[i];
            go(i, newSum, path, used);
            path.remove(path.size() - 1);
            used.set(i, false);
        }
    }

    private static int[][] readDistanceMatrix(BufferedReader reader) {
        return reader.lines()
                .limit(numberOfCities)
                .map(s -> Arrays.stream(s.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .toArray(int[][]::new);
    }

    private static int[] readTimeToSpendInEachCity(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void printResults() {
        System.out.println(min[0]);
        System.out.println(
                result.stream()
                        .map(x -> String.valueOf(x + 1))
                        .collect(Collectors.joining(" "))
        );
    }
}

