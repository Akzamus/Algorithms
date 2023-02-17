package yandexTraining3;

import java.util.Arrays;
import java.util.Scanner;

public class Sntp {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] sent = scanInput();
        int[] processed = scanInput();
        int[] accepted = scanInput();

        int sentTimeInSec = sent[0] * 3600 + sent[1] * 60 + sent[2];
        int processedTimeInSec = processed[0] * 3600 + processed[1] * 60 + processed[2];
        int accTimeInSec =  accepted[0] * 3600 + accepted[1] * 60 + accepted[2];
        int diff;

        if(sentTimeInSec > accTimeInSec) {
            diff = 24 * 3600 - (sentTimeInSec - accTimeInSec);
        } else {
            diff = accTimeInSec - sentTimeInSec;
        }

        double resultTimeInSec = processedTimeInSec + (diff / 2.0);
        if(resultTimeInSec >= 24 * 3600) {
            resultTimeInSec -= 24 * 3600;
        }

        int resultH = (int)(resultTimeInSec / 3600);
        resultTimeInSec -= resultH * 3600;
        int resultM = (int)(resultTimeInSec / 60);
        resultTimeInSec -= resultM * 60;
        int resultS = (int)Math.round(resultTimeInSec);

        if(resultS == 60) {
            resultM++;
            resultS = 0;
        }

        String result = "";

        if (resultH < 10) result += "0";
        result += resultH + ":";
        if (resultM < 10) result += "0";
        result += resultM + ":";
        if(resultS < 10) result += "0";
        result += resultS;
        System.out.println(result);
    }

    private static int[] scanInput() {
        return Arrays.stream(scanner.nextLine().split(":"))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }
}
