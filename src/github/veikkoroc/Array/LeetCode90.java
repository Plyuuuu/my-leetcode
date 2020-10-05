package github.veikkoroc.Array;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/5 10:28
 */
public class LeetCode90 {
    public static void main(String[] args) {

        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,2};

        List<List<Integer>> lists = subsetsWithDup(arr2);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }

        //比较数组是否一样
        //System.out.println(Arrays.equals(arr1,arr2));

        //测试set是否能检测相同的数组对象======不能
        /*HashSet<int[]> set = new HashSet<>();
        set.add(arr1);
        set.add(arr2);
        Iterator<int[]> iterator = set.iterator();
        while (iterator.hasNext()){
            int[] next = iterator.next();
            System.out.println(Arrays.toString(next));
        }*/
    }

    /**
     * 位运算
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        //排序nums
        Arrays.sort(nums);
        //数组长度
        int length = nums.length;
        //先忽略含有重复子集的总子集数
        int num = 1<<length;
        //存放结果
        List<List<Integer>> res = new ArrayList<>();
        //把不重复子集添加到结果
        for (int i = 0; i < num; i++) {
            //存放子集
            List<Integer> re = new ArrayList<>();
            for (int j = 0; j < length; j++) {
                if (((i>>j)&1)==1){
                    re.add(nums[j]);
                }
            }
            //判断res中是否包含re，包含则不添加

            if (!res.contains(re)) {
                res.add(re);
            }

        }


        return res;
    }
    @Test
    public void test(){
        int[] arr1 = {1,2};
        int[] arr2 = {2,1};
        int[] arr3 = {1,2};
        int[] arr4 = {1,2};

        System.out.println(Arrays.equals(arr1,arr2));

    }

}
