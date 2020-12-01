package github.veikkoroc.string;

import java.util.Arrays;

/**
 *
 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。
 如果可以构成，返回 true ；否则返回 false。

 (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 *
 * 你可以假设两个字符串均只含有小写字母。
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *.
 *
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/20 21:37
 */
public class LeetCode383 {
    public static void main(String[] args) {

        int[] abcdab = partMateTable("abcdab");
        System.out.println(Arrays.toString(abcdab));

        System.out.println(canConstruct("aa","a1ab"));

    }


    public static boolean canConstruct1(String ransomNote, String magazine){
        //刷击败
        if (magazine.length()<ransomNote.length()){
            return false;
        }

        //遍历杂志，把所有字母个数存起来
        int[] mags = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            mags[magazine.charAt(i)-'a']++;
        }
        //看是否能拼出ransomNote
        for (int i = 0; i < ransomNote.length(); i++) {

            if (--mags[ransomNote.charAt(i)-'a']<0){
                return false;
            }
        }

        return true;
    }










    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == ""){
            return false;
        }
        if (ransomNote == null){
            return false;
        }
        if (magazine==""){
            return false;
        }
        if (magazine == null){
            return false;
        }
        //获取部分匹配表
        int[] PMT = partMateTable(ransomNote);

        int j = 0;
        for (int i = 0; i < magazine.length(); i++) {

            //kmp 核心公式
            while ( j > 0 && magazine.charAt(i) != ransomNote.charAt(j)){
                j = PMT[j-1];
            }
            if (magazine.charAt(i) == ransomNote.charAt(j)){
                j++;
            }
            if (j==ransomNote.length()){
                return true;
            }

        }

        return false;
    }

    /**
     * 获得 KMP 的部分匹配表
     * @param s 要匹配的字符串   例如ABCABD
     * @return 部分匹配表
     */
    public static int[] partMateTable(String s){
        //创建部分匹配表
        int[] table = new int[s.length()];
        //只有一个字符，部分匹配表时 [0]
        table[0] = 0;
        //给部分匹配表赋值
        int j = 0;
        for (int i = 1; i < s.length(); i++) {

            //失配了
            while (j>0 && s.charAt(i) != s.charAt(j)){
                j = table[j-1];
            }
            //前后缀相同
            if (s.charAt(i) == s.charAt(j)){
                j++;

            }
            table[i] = j;
        }


        return table;
    }
}
