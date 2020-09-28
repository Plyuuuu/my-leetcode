package github.veikkoroc.Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/28 9:14
 */
public class LeetCode1 {
    public static void main(String[] args) {
        int[] nums = {0,4,3,0};
        int target = 0;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 使用哈希表
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        //建立哈希表，把所有元素存进去
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        //遍历数组，看哈希表内是否有对应的值
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];

            if (map.containsKey(temp) && map.get(temp)!= i) {
                res[0] = i;
                res[1] = map.get(temp);
                break;
            }
        }



        return res;
    }
}
