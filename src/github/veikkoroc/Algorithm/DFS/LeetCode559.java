package github.veikkoroc.Algorithm.DFS;

import github.veikkoroc.z_util.tree.Node;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给定一个 N 叉树，找到其最大深度。
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/27 14:53
 */
public class LeetCode559 {
    public static void main(String[] args) {

    }
    public int maxDepth(Node root) {

        // 递归终止条件
        if (root == null){
            return 0;
        }
        if (root.children.isEmpty()){
            return 1;
        }

        // 每层递归在干嘛
        List<Integer> heights = new LinkedList<>();
        for (Node child : root.children) {
            heights.add(maxDepth(child));
        }

        // 递归返回值
        return Collections.max(heights)+1;
    }
}
