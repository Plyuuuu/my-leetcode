package github.veikkoroc.algorithm.search.BinarySearch;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/12/1 9:47
 */
public class LeetCode34 {

    @Test
    public void test(){
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        // 边界判断
        if (nums.length == 0){
            return new int[]{-1,-1};
        }
        if (nums.length == 1){
            if (nums[0] == target){
                return new int[]{0,0};
            }else {
                return new int[]{-1,-1};
            }
        }

        return binarySearch(nums,0,nums.length-1,target);
    }

    /**
     * 递归的二分查找
     *
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return
     */
    public int[] binarySearch(int[] arr,int left,int right,int value){
        int mid = (left+right)/2;
        // 递归终止条件
        if (left > right){
            return new int[] {-1,-1};
        }
        // 如果中间值 > value 左递归，反之右递归
        if (arr[mid] > value){

           return binarySearch(arr,left,mid-1,value);

        }else if (arr[mid] < value){
            return binarySearch(arr,mid+1,right,value);

            // 找到了，看看周围还有没有
        }else {

            ArrayList<Integer> list = new ArrayList<>();
            list.add(mid);
            // 查看mid左边
            int l = mid-1;
            while ( l > -1 && arr[l] == value){
                list.add(l);
                l--;
            }
            // 查看mid右边
            int r = mid+1;
            while (r < arr.length && arr[r] == value){
                list.add(r);
                r++;
            }

            // 返回结果
            Object[] objects =  list.toArray();
            Arrays.sort(objects);

            int[] res = new int[objects.length];
            for (int i = 0; i < objects.length; i++) {
                res[i] = (Integer) objects[i];
            }
            // 保证答案有两个值

            return new int[] {res[0],res[res.length-1]};
        }


    }
}
