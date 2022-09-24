package LAB2;

public class Task10 {

    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            len++;
        }

        ListNode[] listNodes = new ListNode[len];

        for (int i = 0; i < listNodes.length; i++) {
            listNodes[i] = head;
            head = head.next;
        }

        return listNodes[len / 2];
    }
}
