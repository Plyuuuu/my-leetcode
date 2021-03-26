package github.veikkoroc.DataStructure.Stack;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * 【注意】1、字符转数字运算：
 *          ‘1’-‘0’ = 1
 *        2、字符串转 int
 *          Integer.parseInt(String)
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/11 14:36
 */
public class LeetCode227 {

    public static void main(String[] args) {



        String s = "1+2*3";
        String s2 = "3/2";
        String s3 = "0";
        System.out.println(calculate(s3));

    }

    /**
     * 思路：
     *      1、先把所有的乘除运算算完
     *      2、把剩下的部分添加到新的字符数组中
     *      3、再把加减运算算完得到结果
     *
     *    【理解有误:】不是个位数的加减乘除
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {




        // s 中还有空格，要先去掉空格
        char[] chars1 = s.toCharArray(); //  1 , + , 2 , * , 3

        String s1 = "";
        for (char c : chars1) {
            if (c==' '){
                continue;
            }else {
                s1 += c;
            }
        }

        char[] chars = s1.toCharArray();

        if (chars.length == 1){
            return chars[0]-'0';
        }


        // 创建一个链表,存放只有加减运行的结果
        LinkedList<String> list = new LinkedList<>();

        // 奇数位为符号位
        for (int i = 1; i < chars.length; i = i+2) {

            if (chars[i] == '*'){
                // 先计算出 * 左右数字的运算结果
                list.addLast((chars[i-1] - '0') * (chars[i+1] - '0' )+"");


            }else if (chars[i] == '/'){

                // 先计算出 / 左右数字的运算结果
                list.addLast((chars[i-1] - '0') / ((chars[i+1]) - '0' )+"");

            }else {
                list.addLast(chars[i-1]+"");
                list.addLast(chars[i]+"");
            }

        }
        System.out.println(list); // [1, +, 6]

        int res = 0;

        // 第一个元素肯定是数字,所以就先取出来
        String first = list.pollFirst();

        res += Integer.parseInt(first);

        System.out.println(res);


        // 链表不为空
        while (!list.isEmpty()){
            String str = list.pollFirst();
            if ("+".equals(str)){
                res += Integer.parseInt(list.pollFirst());
            }else {
                res -= Integer.parseInt(list.pollFirst());
            }
        }

        return res;
    }





}
