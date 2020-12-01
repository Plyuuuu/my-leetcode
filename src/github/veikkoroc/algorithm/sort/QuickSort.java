package github.veikkoroc.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序：
 *      例如有一需要排序的数组为：23,45,17,11,13,89,72,26,3,17,11,13（从小到大排序）：
 *
 *      选取数组第一个数23为基准数，存入temp变量中，从数组的左右两边界向中间进行遍历，定义两个指针 head 和 tail，
 *      head 最开始指向数组的第一个元素，tail 最开始指向数组的最后一个元素。指针 head 从左向右移动，指针 tail 从右向左移动。
 *      先移动 tail 指针（从右往左移），当 tail 指向的数大于基准数时，略过，tail 继续往左移动，直到遇到小于等于基准数的数arr[tail]，
 *      将arr[tail]填入arr[head]中；再移动 head 指针，当 head 指向的数小于等于基准数时，略过，head 继续往右移动，直到遇到不比基准数小的数arr[head]，
 *      将arr[head]填入arr[tail]中；再移动 tail 指针，再移动 tail指针...(轮换移动)，直到 head 和 tail 指针相遇，此时将temp（基准数）填入arr[head]中即完成算法的第2个步骤。
 *      接下来分别将基准数左边和右边的数组按照以上方法进行聚合，直到每个子集只有一个元素，即排序完成。
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/17 23:18
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {45,80,55,40,42,85};
        int head = 0;
        int tail = arr.length-1;
        quickSort(arr,head,tail);
    }

    /**
     *
     * @param arr   要排序的数组
     * @param head  头指针
     * @param tail  尾指针
     */
    public static void quickSort(int[] arr,int head,int tail){
        System.out.println("==========排序前==========");
        System.out.println(Arrays.toString(arr));
        //前提判断
        if ( arr == null){
            System.out.println("数组为null ~ ");
        }
        if ( arr.length <= 1 ){
            System.out.println("无需排序 ~ ");
        }
        //都符合进行快排
        quickSortHelp(arr,head,tail);
        System.out.println("==========排序后==========");
        System.out.println(Arrays.toString(arr));
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
