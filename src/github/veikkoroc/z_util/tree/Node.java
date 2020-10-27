package github.veikkoroc.z_util.tree;

import java.util.List;

/**
 * N叉树节点
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/27 14:52
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
