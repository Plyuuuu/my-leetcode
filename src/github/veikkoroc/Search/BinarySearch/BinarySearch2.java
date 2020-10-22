package github.veikkoroc.Search.BinarySearch;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 二分查找：
 *  前提：查找的数组有序
 *  方法：
 *      递归
 *      非递归
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/22 13:09
 */
public class BinarySearch2 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int search = search(arr, 7,0,arr.length-1);
        System.out.println(search);

    }

    /**
     * 递归的二分查找
     *  递归三要素：
     *      递归终止条件
     *      当前递归在干嘛
     *      返回什么结果
     *
     * @param arr
     * @param value
     * @return
     */
    public static int search(int[] arr,int value,int left,int right){

        // 数组中间的那个值
        int mid = (left+right)/2;

        // 递归终止条件
        if (left>right){
            return -1;
        }

        // 当前递归在干嘛
        if (arr[mid] == value){
            return mid;

            // value>中间值,left = mid +1
        }else if (arr[mid] < value){
            left = mid+1;
            return search(arr,value,left,right);

            // value<中间值,right = mid-1
        }else {
            right = mid -1;
            return search(arr,value,left,right);
        }


    }

    /**
     * 完善递归的二分查找
     *
     * @param arr
     * @param value
     * @param left
     * @param right
     * @return
     */
    public  ArrayList<Integer> search2(int[] arr,int value,int left,int right){

        // 中间指针
        int mid = (left+right)/2;



        // 递归终止条件
        if (right<left ){
            return null;
        }

        // 每层递归在干嘛
        // 如果 value > 数组中间值，递归中间值右边
        if (arr[mid] < value){
            return search2(arr,value,mid+1,right);

            // 如果 value < 数组中间值，递归中间值左边
        }else if (arr[mid] > value){
            return search2(arr,value,left,mid-1);

            // 找到了value，看看周围还有没有
        }else {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(mid);
            // 查看mid左边
            int temp = mid-1;
            while (true){
                if (arr[temp] == value){
                    res.add(temp);
                    temp = temp-1;
                }else {
                    break;
                }
            }
            // 查看mid右边
            int tempr = mid+1;
            while (true){
                if (arr[tempr] == value){
                    res.add(tempr);
                    tempr = tempr+1;
                }else {
                    break;
                }
            }
            return res;
        }


    }

    @Test
    public void testSearch2(){
        int[] arr = {1,2,3,4,4,4,5};
        ArrayList<Integer> arrayList = search2(arr, 4, 0, arr.length - 1);
        System.out.println(arrayList.toString());
    }



}
