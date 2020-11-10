package github.veikkoroc.DataStructure.LinkedList;

import github.veikkoroc.z_util.linkedlist.LinkedListFactory;
import github.veikkoroc.z_util.linkedlist.ListNode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/5 11:05
 */
public class LeetCode206 {
    public static void main(String[] args) {
        ListNode head = LinkedListFactory.getSingleLinkedList();
        System.out.println(head);
        ListNode listNode = reverseList(head);
        System.out.println(listNode);
    }

    /**
     * 双指针迭代法
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next==null){
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;

        while (cur!=null){
         cur.next = pre;
         pre = cur;
         if (next==null){
                break;
         }
         cur = next;

         next = next.next;

        }
        return cur;
    }
}
