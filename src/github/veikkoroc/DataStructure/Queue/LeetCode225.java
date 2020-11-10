package github.veikkoroc.DataStructure.Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/implement-stack-using-queues/
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/14 11:04
 */
public class LeetCode225 {

    Queue<Integer> q1;
    Queue<Integer> q2;

    /** Initialize your data structure here. */
    public LeetCode225() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
        while(!q2.isEmpty()){
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

        return q2.poll();
    }

    /** Get the top element. */
    public int top() {

        return q2.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

        return q2.isEmpty();
    }
}
