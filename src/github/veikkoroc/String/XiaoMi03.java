package github.veikkoroc.String;

import java.util.Scanner;

/**
 * 输入
 * 输入数据有多组，每组占一行，包含一个句子(句子长度小于1000个字符)
 *
 * 样例输入
 * hello xiao mi
 *
 * 输出
 * 对于每个测试示例，要求输出句子中单词反转后形成的句子
 *
 * 样例输出
 * mi xiao hello
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/16 8:42
 */
public class XiaoMi03 {
    public static void main(String[] args) {
        //System.out.println(ReverseWords("Hello xiao mi"));

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println(ReverseWords(s));


    }
    public static String ReverseWords(String s){
        String[] words = s.split(" ");
        String res = "";
        for (int i = 0; i < words.length; i++) {
            if (i == 0){

                res += words[words.length-1-i];
            }else {
                res += " "+words[words.length-1-i];
            }
        }


        return res;
    }
}
