package github.veikkoroc.DataStructure.LinkedList;

import github.veikkoroc.z_util.linkedlist.LinkedListFactory;
import github.veikkoroc.z_util.linkedlist.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/6 13:56
 */
public class LeetCode21 {
    public static void main(String[] args) {

        ListNode head1 = LinkedListFactory.getSingleLinkedList();
        ListNode head2 = LinkedListFactory.getSingleLinkedList();

        System.out.println(mergeTwoLists(head1,head2));

    }

    /**
     * 递归解法
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if (l1.val < l2.val){
            l1.next  = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }
}
