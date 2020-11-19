package github.veikkoroc.Competition.LeetCode.JD215;

import java.util.*;

/**
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 *
 * 操作 1：交换任意两个 现有 字符。
 * 例如，abcde -> aecdb
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 *
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false
 *
 * 输入：word1 = "abc", word2 = "bca"
 * 输出：true
 * 解释：2 次操作从 word1 获得 word2 。
 * 执行操作 1："abc" -> "acb"
 * 执行操作 1："acb" -> "bca"
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/15 11:04
 */
public class T2 {

    /**
     * 思路：
     *      1、Word1 和 word2 的字符个数要相等
     *      2、word1 和 word2 包含的字符种类数要一样
     *      3、字符数排序一样
     * @param word1
     * @param word2
     * @return
     */
    public boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()){
            return false;
        }

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();



        for (char c : chars1) {
            set1.add(c);
            set3.add(c);
        }

        for (char c : chars2) {
            set2.add(c);
            set3.add(c);
        }

        if (set1.size()!=set2.size() || set1.size() != set3.size()){
            return false;
        }

        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for (char c : chars1) {
            if (! map1.containsKey(c)){
                map1.put(c,1);
            }else {
                Integer integer = map1.get(c);
                map1.put(c,++integer);
            }
        }

        for (char c : chars2) {
            if (! map2.containsKey(c)){
                map2.put(c,1);
            }else {
                Integer integer = map2.get(c);
                map2.put(c,++integer);
            }
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        Iterator<Character> iterator = set1.iterator();
        while (iterator.hasNext()){
            Character next = iterator.next();
            Integer integer1 = map1.get(next);
            Integer integer2 = map2.get(next);
            list1.add(integer1);
            list2.add(integer2);
        }

        int[] arr1 = new int[list1.size()];
        int temp = 0;
        for (Integer integer : list1) {
            arr1[temp] = integer;
            temp++;
        }
        Arrays.sort(arr1);


        int[] arr2 = new int[list2.size()];
        int temp2 = 0;
        for (Integer integer : list2) {
            arr2[temp2] = integer;
            temp2++;
        }
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }
}
