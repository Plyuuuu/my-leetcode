package github.veikkoroc.algorithm.search.BinarySearch;

import org.junit.Test;

/**
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/22 21:41
 */
public class LeetCode704 {

    public static void main(String[] args) {

    }

    /**
     * 递归版二分查找
     *执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.1 MB
     * , 在所有 Java 提交中击败了
     * 97.96%
     * 的用户
     * @param nums
     * @param target
     * @return
     */
    public  int search3(int[] nums, int target) {
        return helper2(nums,target,0,nums.length-1);
    }
    public int helper2(int[] arr,int value,int left,int right){

        int mid = (left + right) / 2;

        // 递归终止条件
        if (value<arr[left] || value>arr[right] || right<left){
            return -1;
        }
        // 每层递归在干嘛
        if (arr[mid] < value){
            return helper2(arr,value,mid+1,right);
        }else if (arr[mid] > value){
            return helper2(arr,value,left,mid-1);

        }else {
            return mid;
        }

    }



    /**
     * 线性查找
     *执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 5.64%
     * 的用户
     * 内存消耗：
     * 39.5 MB
     * , 在所有 Java 提交中击败了
     * 90.17%
     * 的用户
     * @param nums
     * @param target
     * @return
     */
    public  int search2(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }


    /**
     * 非递归的插值查找
     *
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 5.64%
     * 的用户
     * 内存消耗：
     * 39.3 MB
     * , 在所有 Java 提交中击败了
     * 95.31%
     * 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        // 边界判断
        if (nums == null || nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return nums[0] == target?0:-1;
        }
        // 设置最左最右指针，和中间指针
        int left = 0;
        int right = nums.length-1;
        int mid = left + (right-left)*((target-nums[left])/(nums[right]-nums[left]));

        while(true){
            // 终止条件
            if (target < nums[0]||target>nums[nums.length-1]|| left > right ){
                return -1;
            }
            // 目标值在中值右边
            if (target > nums[mid]){
                left = mid +1;
                if (right == left){
                    mid = left;
                }else {
                    mid = left + (right-left)*((target-nums[left])/(nums[right]-nums[left]));
                }
                continue;
            }
            // 目标值在中值左边
            else if (target < nums[mid]){
                right = mid -1;
                if (right == left){
                    mid = left;
                }else {
                    mid = left + (right-left)*((target-nums[left])/(nums[right]-nums[left]));
                }
                continue;
            }

            // 找到了目标值
            else {
                return mid;
            }

        }

    }



    /**
     * 递归的插值查找
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.4 MB
     * , 在所有 Java 提交中击败了
     * 91.32%
     * 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public  int search1(int[] nums,int target){
        // 边界判断
        if (nums == null || nums.length == 0){
            return -1;
        }
        if (nums.length == 1){
            return nums[0] == target?0:-1;
        }
        return helper(nums,target,0,nums.length-1);
    }
    public static int helper(int[] arr,int value,int left,int right){

        int mid = left == right ? left : left + ((right-left)*(value-arr[left]))/(arr[right]-arr[left]);



        // 终止条件
        if (arr[left] > value || arr[right] < value || left > right){
            return -1;
        }
        // 每层在干嘛
        if (arr[mid] < value){
            return helper(arr,value,mid + 1,right);
        }else if (arr[mid] > value){
            return helper(arr,value,left,mid-1);
        }else {
            return mid;
        }


    }
    @Test
    public void test(){
        int[] arr = {-1,0,3,5,9,12};
        int i = search1(arr, 9);
        System.out.println(i);
    }
    @Test
    public void test1(){

        try {
            System.out.println((5-5)*((1+2)/(1-1)));
        } catch (Exception e) {
            System.out.println("1不行");
        }
        try {
            System.out.println((5-5)*(1+2)/(1-1));
        } catch (Exception e) {
            System.out.println("2不行");
        }
        try {
            System.out.println(((5-5)*((1+2))/(1-1)));
        } catch (Exception e) {
            System.out.println("3不行");
        }


    }
}
