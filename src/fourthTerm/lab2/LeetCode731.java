package fourthTerm.lab2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode731 {

    public static void main(String[] args) {
        MyCalendarTwo calendarTwo = new MyCalendarTwo();
        List<int[]> bookings = new LinkedList<>();
        Collections.addAll(bookings,
                new int[]{10, 20}, new int[]{50, 60},
                new int[]{10, 40}, new int[]{5, 15},
                new int[]{5, 10}, new int[]{25, 55}
        );
        bookings.stream().map(booking -> calendarTwo.book(booking[0], booking[1])).forEach(System.out::println);
    }
}

class MyCalendarTwo {

    private List<int[]> bookings = new ArrayList();
    private List<int[]> overlaps = new ArrayList();

    public boolean book(int start, int end) {
        for (int[] overlap : overlaps)
            if (overlap[0] < end && start < overlap[1]) return false;

        for (int[] booking: bookings)
            if (booking[0] < end && start < booking[1])
                overlaps.add(new int[]{Math.max(start, booking[0]), Math.min(end, booking[1])});

        bookings.add(new int[]{start, end});
        return true;
    }
}
