package github.veikkoroc.Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/4 20:46
 */
public class LeetCode78 {

    public static void main(String[] args) {
        System.err.println(1&2);


        int[] arr = {1,2,3};
        subsets(arr);
    }

    /**
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        //存放结果的集合
        ArrayList<List<Integer>> res = new ArrayList<>();
        //空集
        res.add(new ArrayList<>());

       /* ArrayList<Integer> re = new ArrayList<>();
        //数组本身
        for (int num : nums) {
            re.add(num);
        }
        res.add(re);*/

        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        res.add(collect);


        for (List<Integer> arrayList : res) {
            System.out.println(arrayList.toString());
        }



        return null;
    }

    /**
     *位运算
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        //存放结果的集合
        ArrayList<List<Integer>> res = new ArrayList<>();
        //数组长度
        int length = nums.length;
        //子集个数
        int num = 1<<length;

        for (int i = 0; i < num; i++) {
            //子集
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < length; j++) {

                if (((i>>j)&1)==1){
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }

        return res;
    }
}
