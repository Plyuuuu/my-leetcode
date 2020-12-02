package github.veikkoroc.algorithm.greed;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/15 12:45
 */
public class LeetCode402 {

    /**
     * 思路二：使用链表实现
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {


        // 新建一个链表list，把num => char[]

        LinkedList<Character> list = new LinkedList<>();

        char[] chars = num.toCharArray();

        // 把char[]中字符挨个加入到list,如果后面要加的比链表尾部数据大,直接加入,小则删除链表尾部数据,直到加入的数据不比链表尾部小
        for (int i = 0; i < chars.length; i++) {
            while (!list.isEmpty() && k>0 && list.peekLast() > chars[i]){
                k--;
                list.pollLast();
            }
            list.addLast(chars[i]);
        }

        // 得到一个升序的链表,删除多余的尾部数据
        for (int i = 0; i < k; i++) {
            list.pollLast();
        }

        // 取出链表开头为0的数据
        StringBuilder res = new StringBuilder();

        while ( !list.isEmpty() && list.peekFirst() == '0'){
            list.pollFirst();
        }
        while (!list.isEmpty()){
            res.append(list.pollFirst());
        }

        return res.length()==0?"0":res.toString();
    }

    /**
     * 思路一：越靠前越小，结果越小，数组实现困难~~~
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits1(String num, int k) {// 112 1

        // 边界判断
        if (num.length() == k){
            return "0";
        }

        char[] chars = num.toCharArray();// '1' '1' '2'

        char[] res = new char[num.length()-k]; // '' ''

        int temp = 0;

        res[0] = chars[0];


        for (int i = 1; i < chars.length; i++) {
            // 如果后面的比前面的小
             if (k>0 && res[temp] > chars[i]){
                res[temp] = chars[i];
                k--;
             }else {
                 if (temp == res.length-1){
                     continue;
                 }
                 temp++;
                 res[temp] = chars[i];
                 if (temp == res.length-1){
                     break;
                 }
             }
        }
        if (res.length< 8 &&Integer.parseInt(new String(res)) == 0){
            return "0";
        }
        // 去掉前面的0
        String s = new String(res);

        int temp1 = 0;

        char[] chars1 = s.toCharArray();
        while (chars1[temp1] == '0'){
            temp1++;
        }



        return new String(chars1,temp1,res.length-temp1);
    }

    @Test
    public void test(){
        char a = '5';
        char b = '6';
        System.out.println(a);
        System.out.println(b);
        System.out.println((int)a);
        System.out.println((int)b);

        char[] chars = new char[5];
        chars[0] = '1';
        chars[4] = '4';
        String s = new String(chars);
        System.out.println(s); // 0   4
        int i = Integer.parseInt(s);
        System.out.println(i);// java.lang.NumberFormatException: For input string: "1   4"

    }
    @Test
    public void test2(){
        String s = "0023";
        int i = Integer.parseInt(s);
        System.out.println(i);
    }

    @Test
    public void test3(){
        char[] arr = {'0','1','0'};
        System.out.println(new String(arr,1,2));
    }
}
