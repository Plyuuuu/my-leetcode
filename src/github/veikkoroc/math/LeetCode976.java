package github.veikkoroc.math;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/29 16:31
 */
public class LeetCode976 {
    public int largestPerimeter(int[] A) {

        // Arrays.sort(A);

        quickSortHelp(A,0,A.length-1);

        for (int i = A.length-1; i > 1; i--) {
            if ((A[i-1] + A[i-2]) > A[i]){
                return A[i] + A[i-1] + A[i-2];
            }
        }

        return 0;
    }
    /**
     *  快排主体
     *  递归写法
     * @param arr
     * @param head
     * @param tail
     */
    public static void quickSortHelp(int[] arr,int head,int tail){
        //区间不止一个数
        if (head < tail){
            //把数组第一个数作为基准数
            int temp = arr[head];
            //创建辅助指针
            int h = head;
            int t = tail;
            //头指针在尾指针前面
            while (h < t){

                //先判断尾指针指向的数据，如果大于基准数，尾指针左移，
                while (h < t && arr[t] > temp){
                    t --;
                }
                //小于基准数则把该数据赋值给头指针指向的数据
                arr[h] = arr[t];

                //头指针右移，如果指向的数据小于基准数，继续右移
                while (h < t && arr[h] < temp){
                    h ++;
                }
                //大于基准数则把数据赋值给尾指针指向的数据
                arr[t] = arr[h];

            }
            //第一次排序完把temp中数据放入arr[head] = arr[tail]这两个随便哪个位置
            arr[t] = temp;

            //对基准数左边继续排序
            quickSortHelp(arr,head,h-1);
            //对基准数右边继续排序
            quickSortHelp(arr,h+1,tail);
        }else {
            return;
        }
    }
}
