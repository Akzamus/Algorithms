package additionalTasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File("src/additionalTasks/input.txt"))) {
            List<Building> buildings = new ArrayList<>();
            String[] mainInfo = in.nextLine().split(" ");
            int N = Integer.parseInt(mainInfo[0]);
            double K = Double.parseDouble(mainInfo[1]);

            for (int i = 0; i < N; i++) {
                String[] buildingInfo = in.nextLine().split(" ");
                buildings.add(new Building(
                        Double.parseDouble(buildingInfo[0]),
                        Integer.parseInt(buildingInfo[1])
                ));
            }

            showBuildingsOrder(buildings, N, K);
        }
    }

    public static void showBuildingsOrder(List<Building> buildings, int N, double K) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Building building = buildings.get(j);
                if(!building.isBuilt) {
                    building.X = K * building.efficiency - building.expenditure;
                }
            }

            int index = 0;
            double maxX = 0;

            for (int j = 0; j < N; j++) {
                Building building = buildings.get(j);
                if(!building.isBuilt) {
                    if(maxX < building.X) {
                        maxX = building.X;
                        index = j;
                    }
                }
            }

            K += buildings.get(index).X;
            buildings.get(index).order = i + 1;
            buildings.get(index).isBuilt = true;
        }

        buildings.forEach(building -> System.out.println(building.order));
    }
}
