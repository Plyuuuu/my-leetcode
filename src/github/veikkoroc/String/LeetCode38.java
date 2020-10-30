package github.veikkoroc.String;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/28 17:34
 */
public class LeetCode38 {
    public static void main(String[] args) {
        System.out.println(countAndSay2(3));
    }

    public static String countAndSay2(int n){

        // 递归终止条件
        if (n == 1){
            return "1";
        }
        // 获取上一层的字符串
        String s = countAndSay2(n - 1);


        // 获取上一层字符串的字符串
        String helper = helper(s);

        return helper;
    }


    public static String countAndSay(int n) {
        if (n == 1){
            return "1";
        }else {
            String s = countAndSay(n - 1);

        }


        return "";
    }
    public static String helper(String s){
        if (s.equals("1")){
            return "1";
        }
        char[] chars = s.toCharArray();
        // 计数器
        int count = 1;

        // 双指针
        int i = 0;
        int j = 1;

        // 结果
        String res = "";

        // 遍历字符数组
        while (j < chars.length){

            if (chars[i] == chars[j]){
                count ++;
                j++;
            }else {
                // 到达末尾
                if (j == chars.length-1){
                    if (chars[i] == chars[j]){
                        count ++;

                    }else {
                        res +=count+""+chars[i]+ "1"+chars[j];
                        return res;
                    }
                }
                res +=count+""+chars[i];
                count =1;
                i++;
                j++;

            }

        }

        return res;
    }


    /**
     * 理解偏差
     *  112254 = "21221514"
     * @param n
     * @return
     */
    public static String countAndSay1(int n) {



        // 先把整数n换成字符数组
        String string  = n+"";
        char[] chars = string.toCharArray();

        // 计数器
        int count = 1;

        // 双指针
        int i = 0;
        int j = 1;

        // 结果
        String res = "";

        // 遍历字符数组
        while (j < chars.length){

            if (chars[i] == chars[j]){
                count ++;
                j++;
            }else {
                // 到达末尾
                if (j == chars.length-1){
                    if (chars[i] == chars[j]){
                        count ++;

                    }else {
                        res +=count+""+chars[i]+ "1"+chars[j];
                        return res;
                    }
                }
                res +=count+""+chars[i];
                count =1;
                i++;
                j++;

            }

        }

        return res;
    }

    @Test
    public void test(){
        String res = "";
        int count = 1;
        int n = 5;
        System.out.println(res+count+n);
    }
}
