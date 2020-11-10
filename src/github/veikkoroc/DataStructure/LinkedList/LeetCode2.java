package github.veikkoroc.DataStructure.LinkedList;

import github.veikkoroc.z_util.linkedlist.ListNode;

/**
 *给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 16:13
 */
public class LeetCode2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);


        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);

    }

    /**
     * 递归
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //创建一个结果辅助头结点
        ListNode head = new ListNode(0);
        //辅助指针指向结果头结点
        ListNode pre = head;
        //进位辅助变量
        int i = 0;

        while (l1 !=null || l2!=null || i!=0){
            if (l1!=null){
                i += l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                i += l2.val;
                l2 = l2.next;
            }

            ListNode listNode = new ListNode(i % 10);
            pre.next = listNode;
            pre = pre.next;
            i /=10;
        }


        return head.next;
    }
}
