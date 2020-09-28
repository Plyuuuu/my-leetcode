package github.veikkoroc.Array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 *
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/27 10:43
 */

public class LeetCode1512 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        int i = numIdenticalPairs3(nums);
        System.out.println(i);

    }

    /**
     * 简单的暴力法
     * @param nums
     * @return
     */
    public static int numIdenticalPairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1;j< nums.length;j++){
                if (nums[i] == nums[j]){
                    res++;
                }
            }
        }

        return res;
    }

    /**
     * 哈希表
     * @param nums
     * @return
     */
    public static int numIdenticalPairs1(int[] nums) {
        int res = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //map中没有这个key
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                //如果包含，value++
                Integer value = map.get(nums[i]);
                map.replace(nums[i],value+1);
            }
        }

        //遍历哈希表
        Set<Integer> integers = map.keySet();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            int key = iterator.next();
            int value = map.get(key);
            //System.out.println("key:"+key+" value:"+value);
            //n*(n-1)/2
            res+=value*(value-1)/2;
        }

        return res;
    }

    /**
     * 利用已知条件和基本数据类型的高性能
     * @param nums
     * @return
     */
    public static int numIdenticalPairs2(int[] nums) {
        //存放结果
        int res = 0;
        //由已知1 <= nums[i] <= 100,存放每个值的出现个数
        int[] temp = new int[101];
        for (int num : nums) {
            temp[num]+=1;
        }
        for (int i : temp) {
            if (i>1){
                res += i*(i-1)/2;
            }
        }
        return res;
    }
    public static int numIdenticalPairs3(int[] nums) {
        //存放结果
        int res = 0;
        //由已知1 <= nums[i] <= 100,存放每个值的出现个数
        int[] temp = new int[101];
        for (int num : nums) {
            res += temp[num];
            temp[num]+=1;
        }
        return res;
    }

}
