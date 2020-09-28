package github.veikkoroc.Set;

import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/27 17:46
 */
public class LeetCode_LCP11 {
    public static void main(String[] args) {
        int[] scores = {1,2,3};
        int[] scores2 = {1,1};

    }

    /**
     * 求scores中不重复元素的个数
     * 执行用时：21 ms, 在所有 Java 提交中击败了91.00%的用户
     * 内存消耗：57 MB, 在所有 Java 提交中击败了5.13%的用户
     * @param scores
     * @return
     */
    public int expectNumber(int[] scores) {
        HashSet<Integer> set = new HashSet<>();
        for (int score : scores) {
            set.add(score);
        }
        return set.size();
    }

    /**
     * 执行用时：22 ms, 在所有 Java 提交中击败了70.32%的用户
     * 内存消耗：48.9 MB, 在所有 Java 提交中击败了15.02%
     * 的用户
     * @param scores
     * @return
     */
    public int expectNumber2(int[] scores) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int score : scores) {
            set.add(score);
        }
        return set.size();
    }

    /**
     * 执行用时：92 ms, 在所有 Java 提交中击败了5.35%的用户
     * 内存消耗：53.7 MB, 在所有 Java 提交中击败了9.89%的用户
     * @param scores
     * @return
     */
    public int expectNumber3(int[] scores) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int score : scores) {
            set.add(score);
        }
        return set.size();
    }
}
