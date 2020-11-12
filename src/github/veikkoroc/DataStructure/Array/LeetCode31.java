package github.veikkoroc.DataStructure.Array;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/10 17:09
 */
public class LeetCode31 {


    /**
     * 改进算法
     * @param nums
     */
    public void nextPermutation1(int[] nums) {

        // 边界判断
        if (nums.length == 1){
            return;
        }
        if (nums.length == 2){
            if (nums[0] != nums [1]){
                int temp = nums[0];
                nums[0] = nums[1];
                nums[1] = temp;
            }
            return;
        }
        // 数组长度
        int length = nums.length;
        // 临时变量
        int temp;
        // 辅助双指针
        int r = length-1;
        int l = length-2;


        // 最后两位升序,直接交换位置
        if (nums[r] > nums[l]){
            temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            return;
        }

        // 不是最后两位不是升序，就向前找升序的地方
        while ( nums[l-1] >= nums[l] ){
            // 如果没找到就说明此事已是最大排列,返回最小排列
            if ((l-1) == 0){
                Arrays.sort(nums);
                return;
            }
            l--;
            // 如果找到了,目标数字是  nums[l-1]

        }
        // 继续方向找比它大的那个数
        while (nums[r] <= nums[l-1]){
            r--;
        }
        // 找到了是 nums[r]
        // 把nums[l-1] 与 nums[r]交换
        temp = nums[r];
        nums[r] = nums[l-1];
        nums[l-1] = temp;

        // 把nums[l-1]后面的元素该升序
        /*int[] arr = new int[length-l];
        for (int i = l,j=0; i < nums.length; i++,j++) {
            arr[j] = nums[i];
        }
        Arrays.sort(arr);
        for (int i = l,j=0; i < nums.length; i++,j++) {
            nums[i] = arr[j];
        }*/
        for (int i = l,j=nums.length-1; i < nums.length; i++,j--) {
            if (i < j){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }



    }

    /**
     * 双指针
     * @param nums
     */
    /**
     * 双指针
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        // 边界判断
        if (nums.length == 1){
            return;
        }
        if (nums.length == 2){
            if (nums[0] != nums [1]){
                int temp = nums[0];
                nums[0] = nums[1];
                nums[1] = temp;
            }
            return;
        }
        // 数组长度
        int length = nums.length;
        // 临时变量
        int temp;
        // 辅助双指针
        int r = length-1;
        int l = length-2;


        // 最后两位升序,直接交换位置
        if (nums[r] > nums[l]){
            temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            return;
        }

        // 不是最后两位不是升序，就向前找升序的地方
        while ( nums[l-1] >= nums[l] ){
            // 如果没找到就说明此事已是最大排列,返回最小排列
            if ((l-1) == 0){
                Arrays.sort(nums);
                return;
            }
            l--;
            // 如果找到了,目标数字是  nums[l-1]

        }
        // 继续方向找比它大的那个数
        while (nums[r] <= nums[l-1]){
            r--;
        }
        // 找到了是 nums[r]
        // 把nums[l-1] 与 nums[r]交换
        temp = nums[r];
        nums[r] = nums[l-1];
        nums[l-1] = temp;

        // 把nums[l-1]后面的元素该升序
        int[] arr = new int[length-l];
        for (int i = l,j=0; i < nums.length; i++,j++) {
            arr[j] = nums[i];
        }
        Arrays.sort(arr);
        for (int i = l,j=0; i < nums.length; i++,j++) {
            nums[i] = arr[j];
        }

    }

}
