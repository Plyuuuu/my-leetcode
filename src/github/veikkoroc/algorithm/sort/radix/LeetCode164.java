package github.veikkoroc.algorithm.sort.radix;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/26 11:03
 */
public class LeetCode164 {
    public int maximumGap1(int[] nums) {

        // 边界判断
        if (nums.length < 2){
            return 0;
        }
        // 排序
        Arrays.sort(nums);

        int maxDiff = 0;

        for (int i = 1; i < nums.length; i++) {
            if (maxDiff< (nums[i]-nums[i-1])){
                maxDiff = nums[i] - nums[i-1];
            }
        }


        return maxDiff;
    }

    public int maximumGap(int[] nums) {
        // 边界判断
        if (nums.length < 2){
            return 0;
        }
        // 排序
        radixSort(nums);

        int maxDiff = 0;

        for (int i = 1; i < nums.length; i++) {
            if (maxDiff< (nums[i]-nums[i-1])){
                maxDiff = nums[i] - nums[i-1];
            }
        }


        return maxDiff;
    }

    /**
     * 线性时空复杂度：
     *  基数排序：时间复杂度 n*k，空间复杂度 n+k
     * @param arr
     */
    public void radixSort(int[] arr){
        // 创建一个二维数组，第一维表示桶号0-9（对应个位、十位、百位..的值）第二维表示桶内的元素(最坏情况是所有元素都在一个桶中)
        int[][] bucket = new int[10][arr.length];

        // 辅助数组,存放每个桶内元素个数
        int[] bucketCounts = new int[10];

        // 排序轮数(最大元素的位数)
        int max = arr[0];
        for (int i : arr) {
            if (i>max){
                max = i;
            }
        }

        int sortCounts = (max+"").length();

        for (int i = 0 , n = 1; i < sortCounts; i++,n *= 10) {

            // 进行排序

            for (int j = 0; j < arr.length; j++) {
                // 算出元素对应放哪个桶
                int temp = arr[j] /n % 10;
                // 放入到对应的桶
                bucket[temp][bucketCounts[temp]] = arr[j];
                // 桶中元素个数+1
                bucketCounts[temp] += 1;
            }

//        System.out.println(Arrays.toString(bucketCounts));
//        System.out.println("bucket :");
//        for (int[] ints : bucket) {
//            System.out.println(Arrays.toString(ints));
//        }

            // 把桶中 元素再次赋值给arr
            int index = 0;
            // 遍历桶
            for (int k = 0; k < bucketCounts.length; k++) {
                // 桶中有元素才放入arr
                if (bucketCounts[k] != 0){
                    for (int l = 0; l < bucket[k].length; l++) {
                        if (bucket[k][l] != 0) {
                            arr[index] = bucket[k][l];
                            // 把桶中数组重置为0，防止影响后序排序
                            bucket[k][l] = 0;
                            index++;
                        }
                    }
                }
                // 桶中元素个数也要重置
                bucketCounts[k] = 0;
            }

           // System.out.println("第"+(i+1)+"轮排序后"+ Arrays.toString(arr));
        }
    }
}
