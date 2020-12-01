package github.veikkoroc.string;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/15 19:36
 */
public class XiaoMi01 {
    public static void main(String[] args) {

        System.out.println(isClose("{[]}]["));
    }
    public static boolean isClose(String s){
        if (s.equals("")||s==null){
            return false;
        }

        //把s转成字符数组
        char[] chars = s.toCharArray();
        System.out.println(Arrays.toString(chars));
        if (chars[0] == ')' ||chars[0] == ']' ||chars[0] == '}')
        {
            return false;
        }
        //建立辅助Stack
        Stack<Character> stack = new Stack();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' ||chars[i] == '[' ||chars[i] == '{'){
                stack.push(chars[i]);
            }else {
                if (stack.empty()){
                    return false;
                }
                Character pop = stack.pop();
                if (chars[i] != help(pop)){
                    return false;
                }

            }

        }

        return true;
    }
    public static Character help(char c){
        switch (c){
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';

        }
        return null;
    }
}
