package github.veikkoroc.DataStructure.Hash;

import org.junit.Test;

import java.util.*;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/19 16:03
 */
public class LeetCode1207 {

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])){
                // 如果包含该元素，value++
                Integer value = map.get(arr[i]);
                map.replace(arr[i],++value);
            }else {
                map.put(arr[i],1);
            }
        }

        Set<Integer> sets = new HashSet<>();

        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            Integer key = iterator.next();
            sets.add(map.get(key));
        }


        return map.size()==sets.size();
    }
    @Test
    public void test(){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.replace(1,2);
        System.out.println(map.get(1));
    }
}
