package github.veikkoroc.LinkedList;

import github.veikkoroc.z_util.linkedlist.ListNode;

import java.util.HashSet;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/5 20:53
 */
public class LeetCode160 {
    /**
     * 哈希表法
     *      先把链表A全存入set集合，再遍历链表B查看是否有对应的节点存在
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 创建哈希表
        HashSet<ListNode> set = new HashSet<>();

        // 把链表A所有节点放入哈希表
        while (headA!=null){
            set.add(headA);
            headA = headA.next;
        }

        // 遍历链表B查找是否有对应节点
        while (headB!=null){
            if (set.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 双指针法
     *      对的人迟早会相逢
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        // 边界判断
        if (headA == null || headB == null){
            return null;
        }
        // 创建双指针
        ListNode a = headA;
        ListNode b = headB;

        while (a!=b ){
            a = a == null? headB:a.next;
            b = b == null? headA:b.next;
        }

        return a;
    }

}
