package github.veikkoroc.string;

import java.util.*;

/**
 * 在一个字符串中找到出现指定次数的字符并通过控制台输出。
 *
 * 如输入abaccdeff及1，则通过控制台输出：
 *
 * b
 *
 * d
 *
 * e
 *
 * 如输入abaccdeff及2，则通过控制台输出：
 *
 * a
 *
 * c
 *
 * f
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/15 15:49
 */
public class GetTheNumChar {
    public static void main(String[] args) {
        char[] abaccdeffs = getTheNumChar("abaccdeff", 2);
        System.out.println(Arrays.toString(abaccdeffs));
    }
    public static char[] getTheNumChar(String s,int i){
        //把s转成字符数组
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        //遍历chars,char为key，value为次数
        for (int j = 0; j < chars.length; j++) {
            //Map中没有该key，直接加入
            if (!map.containsKey(chars[j])){
                map.put(chars[j],1);
            }
            //如果包含，那就value+1
            else {
                int value = map.get(chars[j]);
                map.replace(chars[j],++value);
            }
        }
        //遍历map集合，把结果存进String
        String res = "";
        Set<Character> keySet = map.keySet();
        Iterator<Character> iterator = keySet.iterator();
        while (iterator.hasNext()){
            Character key = iterator.next();
            Integer value = map.get(key);
            if (value == i){
                res += key;
            }

        }
        char[] chars1 = res.toCharArray();

        return chars1;
    }
}
