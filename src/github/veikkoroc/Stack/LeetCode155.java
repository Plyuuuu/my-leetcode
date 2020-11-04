package github.veikkoroc.Stack;

import java.util.Stack;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/4 13:48
 */
public class LeetCode155 {

    /**
     * 使用两个栈完成
     */
    private Stack<Integer> DataStack;
    private Stack<Integer> MinStack;

    /** initialize your data structure here. */
    public LeetCode155() {
        this.DataStack = new Stack<>();
        this.MinStack = new Stack<>();
    }

    /**
     * 压栈操作
     * @param x
     */
    public void push(int x) {
        // 先把数据压入数据栈
        DataStack.push(x);

        // 如果最小值栈为空，把数据压入栈
        if (MinStack.isEmpty()){
            MinStack.push(x);
        } else {
            // 不为空则与栈顶元素比较，小则加入，大则压入栈顶元素
            Integer peek = MinStack.peek();
            MinStack.push(x<peek?x:peek);
        }

    }

    public void pop() {
        if (!DataStack.isEmpty()){
            DataStack.pop();
            MinStack.pop();
        }else {
            throw new RuntimeException("栈为空!");
        }
    }

    public int top() {

        return DataStack.peek();
    }

    public int getMin() {

        return MinStack.peek();
    }
}
