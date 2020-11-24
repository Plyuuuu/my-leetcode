package github.veikkoroc.DataStructure.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 思路：
 *  把数组排序
 *  创建一个min，保存最小差值，创建一个List，保存最小差值的两个值组成的数组
 *
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/22 5:57
 */
public class LeetCode1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // 将数组排序
        Arrays.sort(arr);

        // 记录最小差值（均为正数）
        int mix = Math.abs(arr[1] - arr[0]);

        // 创建List，保存最小差值的两个数
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        temp.add(arr[1]);
        res.add(temp);

        for (int i = 1; i < arr.length-1; i++) {
            // 后序有差值最小组合
            if (mix == Math.abs(arr[i+1] - arr[i])){
                List<Integer> temp1 = new ArrayList<>();
                temp1.add(arr[i]);
                temp1.add(arr[i+1]);
                res.add(temp1);
            }
            // 后序还有更小的
            if (mix > Math.abs(arr[i+1] - arr[i])){
                List<Integer> temp2 = new ArrayList<>();
                mix = Math.abs(arr[i+1] - arr[i]);
                temp2.add(arr[i]);
                temp2.add(arr[i+1]);
                res.clear();
                res.add(temp2);
            }
            // 后序有更大的就不用管
        }

        return res;
    }
}
