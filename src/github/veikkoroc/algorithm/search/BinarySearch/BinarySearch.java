package github.veikkoroc.algorithm.search.BinarySearch;

import java.util.LinkedList;

/**
 * 二分查找：
 *  前提：有序的列表
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/18 8:57
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,6};
        //int i = binarySearch(arr, 0,5 , arr.length - 1);
        //System.out.println(i);
        /*LinkedList<Integer> linkedList = binarySearch1(arr, 0, 3, arr.length - 1);
        System.out.println(linkedList);*/

        //非递归二分查找
        System.out.println(binarySearch2(arr, 0, 3, arr.length - 1));

    }

    /**
     *
     * @param arr 要查找的有序数组
     * @param left  左指针
     * @param findValue   目标值
     * @param right 又指针
     * @return
     */
    public static int binarySearch(int[] arr,int left,int findValue,int right){
        //如果查找的值不在有序列表范围内，返回-1
        if (findValue < arr[left] || findValue > arr[right]){
            return -1;
        }
        //计算出列表中间值的下标
        int middle = (left+right)/2;
        int midVal = arr[middle];

        //用查找值和中间值比较
        //查找值在中间值左边，左递归
        if (findValue < midVal){
            return binarySearch(arr,left,findValue,middle-1);
        }
        //查找值在中间值右边，右递归
        else if (findValue > midVal){
            return binarySearch(arr,middle+1,findValue,right);
        }
        else {
            return middle;
        }

    }

    /**
     * 完善二分查找
     *
     * @param arr
     * @param left
     * @param findValue
     * @param right
     * @return
     */
    public static LinkedList<Integer> binarySearch1(int[] arr,int left,int findValue,int right){
        //如果查找的数不在范围内，返回-1
        if (findValue < arr[left] || findValue > arr[right]){
            return null;
        }
        //计算出中间值坐标，获取中间值
        int middle = (left+right)/2;
        int midVal = arr[middle];


        //查找值在中间值左边
        if (findValue < midVal){
            return binarySearch1(arr,left,findValue,middle-1);
        }else if (findValue > midVal){
            return binarySearch1(arr,middle+1,findValue,right);
        }else {
            //创建返回容器
            LinkedList<Integer> res = new LinkedList<>();
            res.add(middle);
           //找到了开始扫描middle左右，查找是否还有目标值
            //左扫描
            int l = middle - 1;
            while (true){
                if (l >=0 && arr[l] == findValue){
                    res.add(l);
                    l--;
                } else {
                    break;
                }
            }
            //右扫描
            int r = middle + 1;
            while (true){
                if (r <= arr.length-1 && arr[r] == findValue){
                    res.add(r);
                    r++;
                }else {
                    break;
                }
            }
            return res;
        }
    }

    /**
     * 非递归二分查找
     *
     * @param arr
     * @param left
     * @param findValue
     * @param right
     * @return
     */
    public static int binarySearch2(int[] arr,int left,int findValue,int right){
        //如果查找的值不在范围内,返回-1
        if (findValue < arr[left] || findValue > arr[right]){
            return -1;
        }
        //如果目标值就在开头或者结尾，直接返回
        if (findValue == arr[left]){
            return left;
        }
        if (findValue == arr[right]){
            return right;
        }
        //开始查找
        int l = left;
        int r = right;
        while (l<=r){
            int mid = (l+r)/2;
            if (arr[mid] == findValue){
                return mid;
            }else if (arr[mid] > findValue){
                r = mid-1;
            } else {
                l = mid+1;
            }

        }
        return -1;
    }
}
