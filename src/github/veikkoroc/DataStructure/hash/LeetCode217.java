package github.veikkoroc.DataStructure.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 *给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/9 16:51
 */
public class LeetCode217 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] arr2 = {1,2,3,1};
        System.out.println(containsDuplicate(arr));
        System.out.println(containsDuplicate(arr2));
    }

    /**
     * 哈希表
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        //创建一个哈希表
        Map<Integer,Integer> map = new HashMap<>();

        // 遍历nums
        for (int num : nums) {
            if (!map.containsKey(num)){
                map.put(num,1);
            }else {
                return true;
            }
        }


        return false;
    }


    /**
     * Set自带去重
     * @param nums
     * @return
     */
    public static boolean containsDuplicate2(int[] nums) {
        //创建一个哈希表
        Set<Integer> set = new HashSet<>();

        // 遍历nums
        for (int num : nums) {
           set.add(num);
        }


        return !(set.size()==nums.length);
    }

}
