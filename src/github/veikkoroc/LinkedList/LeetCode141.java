package github.veikkoroc.LinkedList;

import github.veikkoroc.z_util.linkedlist.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/5 20:20
 */
public class LeetCode141 {
    public static void main(String[] args) {

    }

    /**
     * 哈希表法
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {


        HashSet<ListNode> set = new HashSet<>();

        int count = 0;

        while (head!=null){
                set.add(head);
                head = head.next;
                count++;
        }

        return count == set.size();
    }

    public static boolean hasCycle2(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();

        while (head!=null){
            if (!set.add(head)){
                return true;
            }
            head = head.next;
        }

        return false;
    }





    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static boolean hasCycle1(ListNode head) {
        // 边界判断
        if (head == null || head.next == null){
            return false;
        }
        // 创建快慢指针
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null){
            if (fast == slow){
                return true;
            }

            if (fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }
}
