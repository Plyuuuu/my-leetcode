package github.veikkoroc.Algorithm.Sort;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/14 23:13
 */
public class Counting {

    public static void main(String[] args) {
        int[] arr1 = {2,1,2,3,1,5};
        int[] arr2 = {5,2,1};
        relativeSortArray(arr1,arr2);
    }

    /**
     * 计数排序
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        // 创建一个包含所有arr1可能值的计数数组，数组下标就是0-1000，值是下标对应值的个数
        int[] count = new int[10];

        for (int i : arr1) {
            count[i]++;
        }

        // System.out.println(Arrays.toString(count));
        // 存放结果的数组
        int[] res = new int[arr1.length];

        // 辅助指针
        int temp = 0;

        // 把arr1中存在arr2的元素按照arr2的顺序排列
        for (int i : arr2) {
            // arr2中每个元素的个数
            int num = count[i];
            count[i] = 0;
            for (int j = 0; j < num; j++) {
                res[temp] = i;
                temp++;
            }

        }
         // System.out.println(Arrays.toString(res));
         // System.out.println(Arrays.toString(count));

        // 把arr1有，arr2没有的元素升序加入res
        for (int i = 0; i < count.length; i++) {

            if (count[i] != 0){
                for (int j = 0; j < count[i]; j++) {
                    res[temp] = i;
                    temp ++;
                }
            }

        }

        // System.out.println(Arrays.toString(res));

        return res;
    }
}
