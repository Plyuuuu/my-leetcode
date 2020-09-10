package github.veikkoroc.String;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/10 11:19
 */

public class LeetCode290 {
    public static void main(String[] args) {
        String str1 = "abba";
        String str2 = "dog cat cat fff";
        System.out.println(wordPattern(str1,str2));
    }
    public static boolean wordPattern(String pattern, String str) {
        char[] chars = pattern.toCharArray();//patter转成字符数组
        //System.out.println(chars);
        String[] s = str.split(" ");//str转成各个单词
        //s[0] = " "+s[0];
        //System.out.println(Arrays.toString(s));
        //如果两个数组长度都不一样返回False
        if (chars.length!=s.length){
            return false;
        }
        //使用Map管理
        HashMap<Character,String> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])&&!map.containsValue(s[i])){//没存过key和value,就把对应映射存起来
                map.put(chars[i],s[i]);
            }else if(map.containsKey(chars[i])){//存过key就比较与之前存的value是否一样，不一样返回false
                String s1 = map.get(chars[i]);
                if (!s1.equals(s[i])){
                    return false;
                }
            }else if (map.containsValue(s[i])){//存过value就比较与之前存的key是否一样，不一样返回false
               if (!map.containsKey(chars[i])){//是否包含，不包含返回false
                   return false;
               }
            }
        }

        return true;
    }
}
