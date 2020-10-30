package github.veikkoroc.A_Books.程序员代码面试指南.第1章栈和队列.第3节如何仅用递归函数和栈操作逆序一个栈;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/29 15:30
 */
public class MyStack {

    /**
     * 获取并且删除栈底元素
     * @param stack
     * @return
     */
    public static int getAndRemoveLowestElement(Stack<Integer> stack){

        // 如果栈只有一个元素,弹出并返回该元素
        int res = stack.pop();
        if (stack.empty()){
            return res;
        }else {
            // 如果栈不止一个元素
            int lowest = getAndRemoveLowestElement(stack);
            stack.push(res);
            return lowest;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        // 获取且删除栈底元素
        int i = getAndRemoveLowestElement(stack);

        reverse(stack);

        stack.push(i);

    }
    @Test
    public void test(){
        Stack stack = new Stack();
        System.out.println(stack.empty());
        System.out.println(stack.isEmpty());
    }
}
