package github.veikkoroc.Competition.LeetCode.JD215;

import org.junit.Test;

/**
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 *
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 *
 *  输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 *
 *
 * https://www.cnblogs.com/wdt1/p/13976195.html
 *
 * leetCode 1658题
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/15 11:31
 */
public class T3 {

    @Test
    public void test(){
        int[] arr = {1,2,3};

        int temp = 0;
        System.out.println(arr[temp++]); // 1
        System.out.println(temp); // 1

    }

    /**
     * 超时了~~~
     * @param nums
     * @param x
     * @return
     */
    public int minOperations(int[] nums, int x) {

        // nums所有元素和
        int temp = 0;
        for (int num : nums) {
            temp+=num;
        }

        // 中间元素值等于winMax值最大时的元素个数
        int partMax = -1;
        // 窗口左边
        int left = 0;
        // 窗口右边
        int right = 0;
        // 窗口的合适值
        int win = temp-x;
        // 窗口当前值
        int curSum = 0;

        // 窗口左边界还没达到最右边
        while (right<nums.length&& left<nums.length){

            // 计算出当前窗口的值，curSum
            if (left==right){
                curSum = nums[left];
            }else {
                int temp1 = 0;
                for (int i = left;i<= right;i++){
                    temp1 += nums[i];

                }
                curSum =temp1;
            }

            // 如果当前值 < win
            if (curSum < win){
                right++;
            }

            // 如果当前值 > win
            if (curSum > win){
                left++;
            }

            // 如果当前值 = win
            if (curSum == win){
                partMax = Math.max(partMax,right-left+1);
                left++;
            }

        }


        return partMax == -1?-1:nums.length-partMax;
    }

    public int minOperations1(int[] nums, int x) {

        int leftRes = 0;
        int rightRes = 0;
        int mixRes = 0;

        // 左边全遍历
        int left = 0;
        int right = nums.length-1;
        int leftTempX = x;

        while (leftTempX > 0){
            leftTempX  = leftTempX-nums[left];
            left++;
        }
        if (leftTempX == 0){
            leftRes = left-1;
        }else {
            leftRes = Integer.MAX_VALUE;
        }
        //  右边全遍历
        int rightTempX = x;
        while (rightTempX > 0){
            rightTempX = rightTempX - nums[right];
            right--;
        }
        if (rightTempX == 0){
            rightRes = nums.length - right-1;
        }else {
            rightRes = Integer.MAX_VALUE;
        }

        // 双指针



        return -1;
    }
}
