package github.veikkoroc.LinkedList;

import github.veikkoroc.z_util.linkedlist.LinkedListFactory;
import github.veikkoroc.z_util.linkedlist.ListNode;

/**
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * 思路：双指针
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/13 16:07
 */
public class LeetCode203 {
    public static void main(String[] args) {
        ListNode head = LinkedListFactory.getSingleLinkedList();
        System.out.println(head);
        ListNode listNode = removeElements(head, 3);
        System.out.println(listNode);
    }
    public static ListNode removeElements(ListNode head, int val) {
        //如果链表为空或者链表只有一个节点，且节点值为Val，返回空
        if (head == null || ((head.next == null)&&(head.val == val))){
            return null;
        }
        //如果只有一个节点，不是val
        if (head.next==null ){
            return head;
        }
        //两个及以上节点
        //创建辅助头结点
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        //创建辅助指针cur
        ListNode cur = listNode;
        ListNode temp = cur.next;
        while (temp !=null){
            //是需要移除的节点
            if (temp.val == val){
                cur.next = temp.next;
                temp = temp.next;
            }else {
                cur = temp;
                temp = temp.next;
            }

        }

        return listNode.next;
    }
}
