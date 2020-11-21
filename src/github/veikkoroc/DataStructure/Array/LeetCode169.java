package github.veikkoroc.DataStructure.Array;

import java.util.*;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/21 19:31
 */
public class LeetCode169 {

    /**
     * 排序优化
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {

        Arrays.sort(nums);

        return nums[nums.length/2];
    }

    /**
     * 排序
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        // 边界判断
        if (nums.length == 1){
            return nums[0];
        }

        // 排序
        Arrays.sort(nums);

        // 创建计数器
        int count = 1;
        int temp = nums[0] ;

        // 遍历nums
        for (int i = 1; i < nums.length; i++) {
            if (temp == nums[i]){
                count++;
                if (count > nums.length/2){
                    return nums[i];
                }
            }else {
                count = 1;
                temp = nums[i];
            }
        }


        return 0;
    }

    /**
     * 哈希表
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        // 创建一个Map，存储数组元素以及出现次数
        Map<Integer,Integer> map = new HashMap<>();

        // 遍历数组，把元素以及出现次数存入map
        for (int num : nums) {
            if (!map.containsKey(num)){
                map.put(num,1);
            }else {
                Integer temp = map.get(num);
                map.replace(num,++temp);
            }
        }
        // 遍历map，找出value>n/2 的key

        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();

            if (map.get(next) > nums.length/2){
                return next;
            }
        }


        return 0;
    }
}
