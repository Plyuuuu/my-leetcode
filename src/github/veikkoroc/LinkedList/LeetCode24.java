package github.veikkoroc.LinkedList;

import github.veikkoroc.z_util.linkedlist.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/6 20:00
 */
public class LeetCode24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println(swapPairs(head));

    }

    /**
     * 递归三部曲:
     *  找终止条件：只有一个节点、或者没有节点递归终止
     *  找返回值
     *  本级递归做什么
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {

        // 终止条件：只有一个节点、或者没有节点递归终止
        if (head == null || head.next == null){
            return head;
        }
        // 每层都在做 三个值(head head.next 已交换部分)只交换前两个节点
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        //寻找的返回值
        return next;
    }
}
