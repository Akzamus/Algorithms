package yandexTraining3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Sntp {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        dateFormat.setLenient(false);

        Date a = dateFormat.parse(scanner.nextLine());
        Date b = dateFormat.parse(scanner.nextLine());
        Date c = dateFormat.parse(scanner.nextLine());

        if(c.before(a)) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(c);
            calendar.add(Calendar.HOUR, 24);
            c = calendar.getTime();
        }

        long diff = Math.round((double)(c.getTime() - a.getTime()) / 2);
        Date exactTime = new Date(b.getTime() + diff);
        System.out.println(dateFormat.format(exactTime));
    }
}
