package github.veikkoroc.Graph;

import java.util.Arrays;

/**
 * 给定⼀一个 ⽆无向图 包含 N 个节点和 M 条边, 每条边 Mi 的代价为 Ci 。图中⼀一条
 * 路路径的惩罚是指对该路路径上所有边的代价 Ci 执⾏行行位运算或（bitwise OR）操
 * 作得到的。假如⼀一条路路径上包含了了边 M1，M2，M3 … … ，Mk，那么对应的惩
 * 罚就是 C1 OR C2 OR C3 OR ... OR Ck。（OR代表位运算或，即 “|” ）
 * 问题：给定图上两个节点 start 和 end，找到从 start 到 end 的所有路路径中惩罚
 * 值最⼩小的路路径，对应的最⼩小惩罚值作为结果返回。如果路路径不不存在就返回 -1。
 * 注意：任意两个节点之间最多存在⼀一条边，图中可能存在有环路路。
 * 需要实现的⽅方法原型:
 * int minPath(int n, int[][] edges, int start, int end)
 * 参数含义：
 * n：节点总数；节点编号从 1 开始，⼀一直到 n，共有 n 个；
 * edges：⽆无向图的边；edges[i] 表示边Mi，其中 edges[i][0] 和
 * edges[i][1] 是Mi的两个节点的编号，edges[i][2] 是Mi对应的代价 Ci；
 * start 和 end：路路径的开始和结束节点编号
 * 限制条件: 1 <= n <=1000
 * 1 <= edges.length <= 10000
 * 1 <= Ci <=1024
 * 例例：edges = [ [1，2，1]，[2，3，3]，[1，3，100] ]，对应的图如下：
 *
 * 当 start = 1，end = 3 时，其最⼩小惩罚路路径是 1->2->3, C(1,2)=1并且C(2,3)=3,
 * 对应的惩罚值为 1 | 3 = 3。
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/26 15:30
 *
 */
public class DaXi03 {
    public static void main(String[] args) {
        int[][] edges = {{1,2,1},{1,3,100},{2,3,3}};
        int i = minPath(3, edges, 1, 3);
        System.out.println(i);
    }
    public static int minPath(int n, int[][] edges, int start, int end){



        // 把所有顶点放入数字-1,表示start到各个顶点的最小惩罚
        int[] ns = new int[n];
        for (int i = 0; i < n; i++) {
            ns[i] = -1;
        }
        //start -start ,最小惩罚为0
        ns[start-1] = 0;

        //遍历所有路径,得到start到该路径的最小惩罚
        for (int[] edge : edges) {
            for (int i = 0; i < edge.length; i++) {
                if (edge[0] ==start){
                    if (ns[edge[1]-1]==-1 || edge[2]<ns[edge[1]-1]) {
                        ns[edge[1] - 1] = edge[2];

                        System.out.println(Arrays.toString(ns));

                    }
                }else if (edge[1]==start){
                    if (ns[edge[1]-1]==-1 || edge[2]<ns[edge[1]-1]) {
                        ns[edge[0] - 1] = edge[2];
                    }
                }
                //start 到 end没有直接路径时的最小路径
                else {
                    int temp = 0;
                    for (int j = start; j < end; j++) {
                        //无路径
                        if (ns[j-1] == -1) {
                            return -1;
                        }
                        temp |= edge[2] ;
                    }
                    if (ns[end-1]>temp){
                        ns[end-1] = temp;
                    }
                }
            }
        }


        return ns[end-1];
    }
}
