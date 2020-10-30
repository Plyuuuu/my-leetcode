package github.veikkoroc.A_Books.程序员代码面试指南.第1章栈和队列.第1节设计一个有getMin功能的栈;

import java.util.Stack;

/**
 *
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/29 13:30
 */
public class MyStack1 {

    /**
     * 存放数据的普通栈
     */
    private Stack<Integer> stackData ;
    /**
     * 栈顶元素存放最小元素的辅助栈
     */
    private Stack<Integer> stackMin;

    public MyStack1(){
        this.stackData = new Stack();
        this.stackMin = new Stack<>();
    }

    /**
     * 压栈方法
     */
    public void push(Integer integer){
        // 把数据压入普通数据栈
        this.stackData.push(integer);
        // 判断是否是最小值，把最小值压入最小值栈
        if(this.stackMin.empty()){
            stackMin.push(integer);
        }else {
            // 如果插入的数值更小，则加入stackMin
            if (stackMin.peek() >= integer){
                stackMin.push(integer);
            }
        }
    }

    /**
     * 弹栈方法
     * @return
     */
    public Integer pop(){
        if (this.stackData.empty()){
            throw new RuntimeException("You stack is empty");
        }

        // 普通数据栈弹出栈
        Integer pop = stackData.pop();
        // 判断最小值是否弹出,弹出stackMin也要弹出
        if (pop.equals(stackMin.peek())){
            stackMin.pop();
        }
        return pop;
    }

    /**
     * 获取最小值方法
     * @return
     */
    public Integer getMin(){
        if (this.stackMin.empty()){
            throw new RuntimeException("You stack is empty");
        }
        return stackMin.peek();
    }

}
