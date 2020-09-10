package github.veikkoroc.z_util.linkedlist;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/10 10:38
 */
public class LinkedListFactory {
    /**
     * 1->1->2->3->3
     * @return
     */
    public static ListNode getSingleLinkedList(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        return head;
    }
}
