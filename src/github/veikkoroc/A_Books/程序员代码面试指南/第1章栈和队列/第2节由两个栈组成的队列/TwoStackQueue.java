package github.veikkoroc.A_Books.程序员代码面试指南.第1章栈和队列.第2节由两个栈组成的队列;

import java.util.Stack;

/**
 * add、poll（轮询）、peek
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/29 14:02
 */
public class TwoStackQueue {
    /**
     * 存放数据的普通栈
     */
    private Stack<Integer> stackPush ;
    /**
     * 栈顶元素存放最小元素的辅助栈
     */
    private Stack<Integer> stackPop;

    public TwoStackQueue(){
        this.stackPush = new Stack();
        this.stackPop = new Stack<>();
    }

    /**
     * 向Pop栈中倒入stackPush中的数据
     *
     */
    private void pushToPop(){
        if (stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }

    }

    /**
     * 第一次Add的时候把第一个元素加入stackPop，其他元素一次性堆积在stackPush中
     * @param pushInt
     */
    public void add(int pushInt){
        stackPush.push(pushInt);
        pushToPop();
    }

    /**
     * 获取并移除此队列的头，如果此队列为空，则返回 null。
     *
     *  第一次poll是弹出第一个加入的元素，第二次poll才会把剩下的元素从stackPush倒入stackPop
     *
     * @return
     */
    public int poll(){
        if (stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty");
        }

        pushToPop();
        return stackPop.pop();
    }

    /**
     *  获取但不移除此队列的头；如果此队列为空，则返回 null。
     * @return
     */
    public int peek(){
        if (stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.peek();
    }
}
