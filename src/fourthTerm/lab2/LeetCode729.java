package fourthTerm.lab2;

import java.util.*;

public class LeetCode729 {

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        List<int[]> bookings = new LinkedList<>();
        Collections.addAll(bookings,
                new int[]{10, 20}, new int[]{50, 60},
                new int[]{10, 40}, new int[]{5, 15},
                new int[]{5, 10}, new int[]{25, 55}
        );
        bookings.stream().map(booking -> calendar.book(booking[0], booking[1])).forEach(System.out::println);
    }
}

class MyCalendar {

    private List<int[]> bookings = new LinkedList<>();

    public boolean book(int start, int end) {
        for (int[] booking : bookings) {
            if(
                booking[0] <= start && start < booking[1]
                || booking[0] < end && end <= booking[1]
                || start < booking[0] && booking[1] <= end
            ) return false;
        }
        bookings.add(new int[]{start, end});
        return true;
    }
}
