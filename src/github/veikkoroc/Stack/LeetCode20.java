package github.veikkoroc.Stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/27 15:29
 */
public class LeetCode20 {
    public static void main(String[] args) {
        System.out.println(isValid("["));
    }
    public static boolean isValid(String s) {
        // 先把字符串改成字符数组
        char[] chars = s.toCharArray();

        // 边界判断
        if (chars.length%2!=0 ){
            return false;
        }
        if (chars[0] == '}' ||chars[0] == ']'||chars[0]==')'){
            return false;
        }

        // 创建一个栈
        Stack<Character> stack = new Stack();

        for (char aChar : chars) {
            // 为左括号就把对应的右括号压入栈
            if (aChar == '{' || aChar == '[' || aChar=='('){
                stack.push(helper(aChar));
            } else {
                if (stack.empty() || stack.pop() != aChar){
                    return false;
                }
            }

        }


        return stack.empty()?true:false;
    }
    public static char helper(char c){
        switch (c){
            case '{':return '}';
            case '[':return ']';
            case '(':return ')';
            default:return ' ';
        }
    }
}
