package github.veikkoroc.algorithm.sort.Insertion;

import github.veikkoroc.z_util.linkedlist.ListNode;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/20 14:10
 */
public class LeetCode147 {
    /**
     * 在原链表上改好麻烦，其实没必要,新建一个链表就行了
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {

        // 边界判断
        if (head == null){
            return null;
        }else if (head.next == null){
            return head;

        // 只有两个元素
        }else if (head.next.next == null){
            if (head.val > head.next.val){
                ListNode temp = head;
                head = head.next;
                head.next = temp;
                temp.next = null;
            }
            return head;
        }

        // 创建4个指针
        ListNode resHead = head;

        ListNode temp = resHead;

        ListNode cur = resHead.next;

        ListNode next = cur.next;

        // 防止循环引用
        resHead.next = null;

        // 当插入所有节点后退出循环
        while (cur != null){

            // 要插入的节点比头结点小，就直接把该节点设置为头结点
            if (cur.val <= resHead.val){
                cur.next = resHead;
                resHead = cur;

                cur = next;
                if (cur == null){
                    return resHead;
                }
                next = cur.next;

                temp = resHead;

            // 要插入的元素比当前头结点大 ，则把当前节点插入要返回的链表中
            }else {

                if (temp.next == null){
                    temp.next = cur;
                    temp.next.next = null;
                    cur = next;
                    if (cur == null){
                        return resHead;
                    }
                    next = cur.next;
                    continue;
                }
                // 建立辅助指针
                ListNode tempNext = temp.next;

                // 当找到比cur大的节点，或者没有比cur大的节点时跳出循环
                while (tempNext != null && tempNext.val < cur.val){
                    temp = tempNext;
                    tempNext = temp.next;
                }

                // 如果tempNext是最后元素
                if (tempNext == null){
                    temp.next = cur;
                    cur.next = null;
                    temp = resHead;
                    tempNext = temp.next;
                    cur = next;
                    if (cur == null){
                        return resHead;
                    }
                    next = cur.next;

                 // cur插入temp之后
                }else {
                    temp.next = cur;
                    cur.next = tempNext;
                    cur = next;
                    if (cur == null){
                        return resHead;
                    }
                    next = cur.next;
                    temp = resHead;
                    tempNext = temp.next;
                }

            }
        }

        return resHead;
    }

    /**
     * 优化：使用新链表
     * @param head
     * @return
     */
    public ListNode insertionSortList2(ListNode head){

        /**
         * 边界判断
         */
        if (head == null || head.next == null){
            return head;
        }else if (head.next.next == null){
            if (head.val > head.next.val){
                ListNode temp = head;
                head = head.next;
                head.next = temp;
                temp.next = null;
            }
            return head;
        }

        // 遍历指针cur
        ListNode cur = head.next;
        ListNode next = cur.next;


        // 创建新链表
        ListNode resHead = head;
        resHead.next = null;

        while (cur != null){
            if (resHead.next == null){
                if (resHead.val > cur.val){
                    cur.next = resHead;
                    resHead = cur;
                    cur = next;
                    next = cur.next;
                }else {

                }
            }
        }

        return null;
    }
}
