package LAB2;

public class Task7 {

    public ListNode reverseList(ListNode head) {
        ListNode next, prev = null;
        ListNode current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
