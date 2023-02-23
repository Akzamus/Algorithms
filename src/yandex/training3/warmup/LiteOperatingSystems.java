package yandex.training3.warmup;

import java.util.*;

public class LiteOperatingSystems {

    private static List<int[]> sectors = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextInt();
        final int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            addWithSectorOverwritingIfIsBusy(in.nextInt(), in.nextInt());
        }
        in.close();
        System.out.println(sectors.size());
    }

    private static void addWithSectorOverwritingIfIsBusy(int start, int end) {
        List<int[]> delete = new ArrayList<>();
        for (int[] sector : sectors) {
            if(
                sector[0] <= start && start <= sector[1]
                || sector[0] <= end && end <= sector[1]
                || start <= sector[0] && sector[1] <= end
            ) {delete.add(sector);}
        }
        delete.forEach(sectors::remove);
        sectors.add(new int[]{start, end});
    }
}
