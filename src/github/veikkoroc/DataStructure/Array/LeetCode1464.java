package github.veikkoroc.DataStructure.Array;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/21 20:11
 */
public class LeetCode1464 {
    /**
     * 排序法
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);

        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
    }

    /**
     * 一次遍历
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums){
        // 记录最大的两个值
        int max1 = nums[0];
        int max2 = nums[1];

        for (int i = 2; i < nums.length; i++) {

            if (nums[i] > max1){
                if (max1 < max2){
                    max1 = nums[i];
                }else {
                  max2 = nums[i];
                }
                continue;
            }
            if (nums[i] > max2){
                max2 = nums[i];
            }

        }

        return (max1-1)*(max2-1);
    }
}
