package github.veikkoroc.DataStructure.Array;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/14 20:12
 */
public class LeetCode1122 {


    /**
     * 暴力法优化
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int temp = 0;
        int[] res = new int[arr1.length];

        Arrays.sort(arr1);

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {

                if (arr1[j] == arr2[i]){
                    res[temp] = arr2[i];
                    temp++;
                    arr1[j] = -1;
                }

            }
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != -1){
                res[temp] = arr1[i];
                temp++;
            }
        }


        return res;
    }



    /**
     * 暴力法
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int length1 = arr1.length;


        int[] res = new int[length1];

        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(arr1);

        for (int i = 0; i < arr2.length; i++) {

            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]){
                    list.add(arr2[i]);
                    arr1[j] = -1;
                }
            }
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != -1){
                list.add(arr1[i]);
            }
        }
        Object[] objects = list.toArray();

        for (int i = 0; i < objects.length; i++) {
            res[i] = (int)objects[i];
        }


        return res;
    }
}
