package github.veikkoroc.z_util.linkedlist;

/**
 * 链表节点
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/10 10:35
 */
public class ListNode {
    /**
     * 节点值
     */
    public int val;
    /**
     * 下一个节点
     */
    public ListNode next;
    public ListNode(int x){
        this.val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
