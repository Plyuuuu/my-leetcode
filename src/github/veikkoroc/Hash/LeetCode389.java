package github.veikkoroc.Hash;

import org.junit.Test;

import java.util.*;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 17:20
 */
public class LeetCode389 {

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";

        System.out.println(findTheDifference2(s,t));
    }

    /**
     * 使用List集合
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        // 创建辅助集合
        List<Character> list = new LinkedList<>();
        //把字符串转成字符数组
        char[] chars = t.toCharArray();
        char[] chars1 = s.toCharArray();

        for (char aChar : chars) {
            //把所有字符存入集合
            list.add(aChar);
        }
        for (char c : chars1) {
            list.remove((Character) c);
        }

        return list.get(0);
    }
    @Test
    public void test(){
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(1);
        System.out.println(objects.toString());
        objects.remove(1);
        System.out.println(objects.toString());

    }

    /**
     * 使用哈希表
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference2(String s, String t) {
        // 创建哈希表

        HashMap<Character,Integer> map = new HashMap<>();
        //字符串转字符数组
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();

        for (int i = 0; i < chars1.length; i++) {
            map.put(chars1[i],i);
        }




        for (int i = 0; i < chars.length; i++) {
            map.remove(chars[i]);
        }
        
        
        return ' ';
    }

    /**
     * 测试Set的remove移除几个值
     */
    @Test
    public void test2(){
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        System.out.println(set.size());
        set.remove(1);
        System.out.println(set.size());

    }
    @Test
    public void test3(){
       HashMap<Integer,Character> map = new HashMap<>();
       map.put(1,'1');
       map.put(1,'2');
       map.remove(1);
        Iterator<Integer> iterator = map.keySet().iterator();
        System.out.println(map.get(1));
    }
}
