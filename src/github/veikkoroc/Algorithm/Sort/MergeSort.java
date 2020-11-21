package github.veikkoroc.Algorithm.Sort;

import java.util.Arrays;

/**
 * 归并排序：
 *      时间复杂度: 都是 nlog2n
 *      空间复杂度: n
 *      稳定性: 不稳定
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/21 20:27
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 分+合的方法
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left < right){
            // 中间索引
            int mid = (left + right)/2;

            // 向左递归分解
            mergeSort(arr,left,mid,temp);

            // 向右递归分解
            mergeSort(arr,mid+1,right,temp);

            // 合并
            merge(arr,left,mid,right,temp);
        }
    }
    /**
     * 合并的方法
     *
     *  arr = [8 , 4 , 5 , 7 , 1 , 3 , 6 ,2]            temp = [  ,  ,  ,  ,  ,  ,  ,  ];
     *        left        mid            right                  t
     *        i                j
     *     tempLeft
     *
     * @param arr 需要排序的数组
     * @param left  左边有序序列的初始索引
     * @param mid 数组中间索引
     * @param right 右边有序序列的尾部索引
     * @param temp 作为中转的数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){

        System.out.println("merge left = "+left+" right = "+right);
        System.out.println("arr "+Arrays.toString(arr));
        System.out.println("merge 之前 "+Arrays.toString(temp));
        // 左边有序序列的初始索引
        int i = left;

        // 右边有序序列的初始索引
        int j = mid + 1;

        // 指向temp数组的当前索引
        int t = 0;

        // [1] 把左右两边有序的数据按照规则填充到temp，直到左右两边的有序序列，有一边处理完为止
        while (i <= mid && j <= right ){

            // 把 i 和 j 指向的元素较小的那个拷贝到temp，然后指针后移
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                i++;
                t++;
            }else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }


        // [2] 把剩余的一遍的数据依次全部填充到temp
        while (i <= mid){
            // 左边有剩余,把剩余全部加到temp
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right){
            // 右边元素有剩余，把右边剩余的加入temp
            temp[t] = arr[j];
            j++;
            t++;
        }


        // [3] 把temp中的元素拷贝到arr
        // 注意：并不是每一次都拷贝8次
        t = 0; // 指针拉回temp起始位置
        int tempLeft = left; // 辅助指针
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
        System.out.println("arr "+Arrays.toString(arr));
        System.out.println("merge 之后 "+Arrays.toString(temp));
    }

}
