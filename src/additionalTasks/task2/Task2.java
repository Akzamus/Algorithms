package additionalTasks.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File("src/additionalTasks/input.txt"))) {
            List<Building> buildings = new ArrayList<>();
            String[] mainInfo = in.nextLine().split(" ");

            final int N = Integer.parseInt(mainInfo[0]);
            final double K = Double.parseDouble(mainInfo[1]);

            for (int i = 1; i <= N; i++) {
                String[] buildingInfo = in.nextLine().split(" ");
                buildings.add(new Building(
                        i,
                        Double.parseDouble(buildingInfo[0]),
                        Integer.parseInt(buildingInfo[1])
                ));
            }

            showBuildingsOrder(buildings, N, K);
        }
    }

    public static void showBuildingsOrder(List<Building> buildings, final int N, final double K) {
        buildings = buildings.stream().peek(building -> building.profit = K * building.efficiency - building.expenditure)
                             .sorted(Comparator.comparingDouble(building -> -building.profit))
                             .collect(Collectors.toList());

        for (int i = 0; i < N; i++)
            buildings.get(i).order = i + 1;

        buildings.stream().sorted(Comparator.comparingInt(building -> building.id))
                          .forEach(building -> System.out.println(building.order));
    }
}
