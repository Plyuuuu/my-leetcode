package github.veikkoroc.String;

import java.util.Arrays;

/**
 * 例如输入“I am a student”，则通过控制台输出“student a am I”
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/15 16:14
 */
public class ReversalSentence {
    public static void main(String[] args) {
        String s = reversal("I am a student");
        System.out.println(s);

    }
    public static String reversal(String s){
        //先切割字符串,得到每个单词
        String[] strings = s.split(" ");
        //System.out.println(Arrays.toString(strings));
        //创建返回值
        String res = "";
        for (int i = 0; i < strings.length; i++) {
            if (i==0){
                res += strings[strings.length-i-1];
            }else {
                res = res + " "+ strings[strings.length-i-1];
            }

        }

        return res;
    }
}
