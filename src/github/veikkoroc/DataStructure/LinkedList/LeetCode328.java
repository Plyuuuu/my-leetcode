package github.veikkoroc.DataStructure.LinkedList;

import github.veikkoroc.z_util.linkedlist.ListNode;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/13 17:19
 */
public class LeetCode328 {
    public static void main(String[] args) {

    }

    /**
     * 奇偶双指针
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {

        // 边界判断
        if (head == null || head.next == null || head.next.next == null){
            return head;
        }

        // 指向头结点（奇数）
        ListNode odd = head;
        // 指向偶数节点
        ListNode even = head.next;

        // 临时变量存储偶数节点的头节点
        ListNode temp = head.next;

        // 迭代法
        while (true){

            // 终止条件
            if ( odd.next == null ){
                odd.next = temp;
                return head;
            }
            if (odd.next.next == null){
                odd.next = temp;
                return head;
            }

            // 改变链表
            odd.next = even.next;
            // 指针下移
            odd = odd.next;

            even.next = even.next.next;
            even = even.next;

        }

    }
}
