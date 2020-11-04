package github.veikkoroc.Stack;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/4 14:04
 */
public class LeetCode232 {

    private Stack<Integer> pushStack;
    private Stack<Integer> reverseStack;

    /** Initialize your data structure here. */
    public LeetCode232() {
        this.pushStack = new Stack<>();
        this.reverseStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        // 如果reverseStack是空的就加入reverseStack，非空则加入pushStack
        if (reverseStack.isEmpty()){
            reverseStack.push(x);
        }else {
            pushStack.push(x);
        }


    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // reverseStack中有数据,pop reverseStack中的数据
        if (!reverseStack.isEmpty()){
            int res = reverseStack.pop();
            if (reverseStack.isEmpty()){
                // 如果reverseStack中没有数据,把pushStack在数据导入reverseStack中
                while (!pushStack.isEmpty()){
                    reverseStack.push(pushStack.pop());
                }
            }
            return res;
        }
        return reverseStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!reverseStack.isEmpty()){
            reverseStack.peek();
        }else {
            while (!pushStack.isEmpty()){
                reverseStack.push(pushStack.pop());
            }

        }
        return reverseStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return reverseStack.isEmpty() && pushStack.isEmpty();
    }
    @Test
    public void test(){
        LeetCode232 leetCode232 = new LeetCode232();
        System.out.println(leetCode232.empty());
        leetCode232.push(1);
        System.out.println(leetCode232.empty());
        leetCode232.pop();
        System.out.println(leetCode232.empty());
    }
}
