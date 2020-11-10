package github.veikkoroc.Algorithm.Search.LinearSearch;

import java.util.ArrayList;

/**
 *
 * 线性查找（傻瓜式查找）
 *  最简单的方法
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/22 12:58
 */
public class LinearSearch {


    public static void main(String[] args) {
        //int[] arr = {1,2,3,4,5};

        int[] arr2 = {1,2,2,1,2};

        //int search = search(arr, 6);

        ArrayList<Integer> search2 = search2(arr2,3);

        System.out.println(search2.toString());
    }

    /**
     * 目标value在数组中没有重复元素
     *
     * @param arr
     * @param value
     * @return
     */
    public static int search(int[] arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                return i;
            }

        }

        return -1;
    }

    /**
     * 目标value在数组中有重复元素
     * @param arr
     * @param value
     * @return
     */
    public static ArrayList<Integer> search2(int[] arr, int value){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==value){
                list.add(i);
            }
        }

        return list;
    }
}
