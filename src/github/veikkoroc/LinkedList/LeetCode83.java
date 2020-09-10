package github.veikkoroc.LinkedList;

import github.veikkoroc.z_util.linkedlist.LinkedListFactory;
import github.veikkoroc.z_util.linkedlist.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/10 10:43
 */
public class LeetCode83 {
    public static void main(String[] args) {
        ListNode singleLinkedList = LinkedListFactory.getSingleLinkedList();
        System.out.println(singleLinkedList);
        ListNode listNode = deleteDuplicates(singleLinkedList);
        System.out.println(listNode);
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null||head.next==null){//一个节点或者为空，直接返回
            return head;
        }
        //定义两个辅助指针
        ListNode cur = head;
        ListNode temp = cur.next;
        //循环
        while (temp!=null){
            if (cur.val == temp.val){//节点相等
                cur.next = temp.next;//删除节点
                temp = temp.next;
            }else {
                cur = cur.next;
                temp = temp.next;
            }
        }

        return head;
    }
}
