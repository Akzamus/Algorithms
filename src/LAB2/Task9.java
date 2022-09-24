package LAB2;

public class Task9 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode additionalNode = new ListNode(0, head);
        ListNode temp = additionalNode;

        while(temp.next != null){
            if(temp.next.val == val) temp.next = temp.next.next;
            else                     temp = temp.next;
        }

        return additionalNode.next;
    }
}
