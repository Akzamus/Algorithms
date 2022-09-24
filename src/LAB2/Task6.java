package LAB2;

public class Task6 {

    public static boolean hasCycle(ListNode head) {
        ListNode latePoint = head, hurryingPoint = head;
        while (
                latePoint != null &&
                hurryingPoint != null &&
                hurryingPoint.next != null
              ) {
                latePoint = latePoint.next;
                hurryingPoint = hurryingPoint.next.next;
                if (latePoint == hurryingPoint) return true;
              }
        return false;
    }
}
