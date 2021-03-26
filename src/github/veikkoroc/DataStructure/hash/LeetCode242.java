package github.veikkoroc.DataStructure.hash;

import org.junit.Test;

import java.util.*;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/22 5:26
 */
public class LeetCode242 {
    /**
     * 哈希表法
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        // 边界判断
        if (s == null && t == null){
            return true;
        }
        if (s == null || t == null){
            return false;
        }
        if (s.length() != t.length()){
            return false;
        }

        // 把s与t转成字符数组
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        // 创建一个哈希表存放s中存在t不存在的每个字符以及出现次数
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            // 把chars中的字符存入map
            if (!map.containsKey(chars[i])){
                map.put(chars[i],1);
            }else {
                Integer value = map.get(chars[i]);
                map.replace(chars[i],++value);
            }
            if (!map.containsKey(chart[i])){
                map.put(chart[i],-1);
            }else {
                Integer value = map.get(chart[i]);
                map.replace(chart[i],--value);
            }

        }
        // 遍历哈希表，存在不为0的值返回false
        Set<Character> set = map.keySet();
        Iterator<Character> iterator = set.iterator();
        while (iterator.hasNext()){
            Character key = iterator.next();
            if (map.get(key)!=0){
                return false;
            }
        }

        return true;
    }
    /**
     * 排序法
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        // 边界判断
        if (s == null && t == null){
            return true;
        }
        if (s == null || t == null){
            return false;
        }
        if (s.length() != t.length()){
            return false;
        }

        // 把s与t转成字符数组
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char[] chart = t.toCharArray();
        Arrays.sort(chart);



        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chart[i]){
                return false;
            }
        }

        return true;
    }

    @Test
    public void test(){
        if (1==1 && 2==3){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
