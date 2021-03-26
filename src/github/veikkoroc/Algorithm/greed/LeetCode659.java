package github.veikkoroc.algorithm.greed;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/12/4 9:04
 */
public class LeetCode659 {

    @Test
    public void test(){
        isPossible(new int[]{1,2,3,3,4,5});
    }

    public boolean isPossible(int[] nums) {

        // 用于存储 nums 中每个元素的个数
        HashMap<Integer,Integer> countMap = new HashMap<>();

        // 先把 nums 的值个每个值的个数加入 countMap中， 如果发现 nums 存在不连续的数字，比如 2 3 5 就直接返回false
        int temp = nums[0];
        for (int num : nums) {
            if (num == temp || num == temp+1){

                if (!countMap.containsKey(num)){
                    countMap.put(num,1);
                }else {
                    Integer value = countMap.get(num);
                    countMap.put(num,++value);
                }
                temp = num;

            }else {return false;}
        }

        System.out.println(countMap);

        // 用于存储 含有三个或者以上的连续数字的结尾的数字,比如 123 ，tail=3
        HashMap<Integer,Integer> tail = new HashMap<>();

        // 遍历存储元素个数的map
        Set<Integer> set = countMap.keySet();
        Iterator<Integer> iterator = set.iterator();
        Iterator<Integer> tempIterator = iterator;
        while (iterator.hasNext()){

            Integer key = iterator.next();

            if (countMap.get(key) == 0){
                continue;
            }
            Integer next = 0;
            for (int i = 0; i < 3; i++) {
                 tempIterator.hasNext();
                 next = tempIterator.next();
                if (next != key){
                    if (countMap.get(next) > 0){
                        Integer integer = countMap.get(next);
                        countMap.replace(next,--integer);
                    }else {return false;}
                }
            }
            tail.put(next,1);

        }

        System.out.println(tail);

        return false;
    }

}
