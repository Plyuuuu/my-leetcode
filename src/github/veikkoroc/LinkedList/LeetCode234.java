package github.veikkoroc.LinkedList;

import github.veikkoroc.z_util.linkedlist.LinkedListFactory;
import github.veikkoroc.z_util.linkedlist.ListNode;

import java.util.Random;
import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 * 输入: 1->2->2->1
 * 输出: true
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/15 9:42
 */
public class LeetCode234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(0);
        System.out.println(isPalindrome(head));

    }

    /**
     * 使用栈
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }

        //栈
        Stack<Integer> stack = new Stack<>();
        //辅助指针
        ListNode cur = head;
        //全部入栈
        while(cur!=null){
            stack.push(cur.val);
            cur = cur.next;
        }
        //进行比较
        while (!stack.empty()){
            if (head.val != stack.pop()){
                return false;
            }
            head = head.next;

        }

        return true;
    }
}
