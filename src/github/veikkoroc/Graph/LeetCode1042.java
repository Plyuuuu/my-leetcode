package github.veikkoroc.Graph;

import java.util.*;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/16 19:17
 */
public class LeetCode1042 {
    public static void main(String[] args) {
        int[][] paths = {{1,2},{3,4}};

        System.out.println(Arrays.toString(gardenNoAdj2(4, paths)));
    }
    public static int[] gardenNoAdj2(int N, int[][] paths) {
        /* 这是一道简单题，限制每个节点的度为3，同时提供四种颜色，因此不需要回溯 */
        /* 初始化节点，使用map保存节点与其临界点的关系 */
        /* 第一版本采用了内部类构建，参考评论区的HashMap更简洁 */
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new HashSet<>());
        }
        /* 初始化路径信息 */
        for (int[] path: paths) {
            int a = path[0] - 1;
            int b = path[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[5];
            /* 查看当前节点的所有邻接点的色彩 */
            for (int adj: graph.get(i)) {
                used[res[adj]] = true;
            }
            /* 为当前节点染色 */
            for (int j = 1; j <= 4; j++) {
                if (!used[j]) {
                    res[i] = j;
                }
            }
        }
        return res;
    }

    public static int[] gardenNoAdj(int N, int[][] paths) {

        //创建邻接矩阵，对应图
        int[][] graph = new int[N][N];
        //初始化图
        for (int i = 0; i < paths.length; i++) {
            graph[paths[i][0]-1][paths[i][1]-1] = 1;
            graph[paths[i][1]-1][paths[i][0]-1] = 1;
        }
        //查看邻接矩阵
        for (int[] ints : graph) {
            System.err.println(Arrays.toString(ints));
        }
        //把N个花园存入List集合，编号为0,1，---，n
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        //花
        int[] flower = {1,2,3,4};
        int cur = 0;
        //创建返回值
        int[] res = new int[N];
        //遍历花园，从第一个开始
        for (int i = 0; i < list.size(); i++) {
            //为花园设置是否种了花设置辅助数组
            boolean[] booleans = new boolean[N];
            //没种花就种
            if (booleans[i]==false){
                res[i] = flower[cur];
                cur++;
                booleans[i] = true;
            }
            //种花完再就找相邻的
            for (int j = i+1; j < graph[i].length; j++) {
                //说明有相邻
                if (graph[i][j]==1 && !booleans[j]){
                    res[j] = flower[cur];
                    cur++;
                    booleans[j] = true;
                }else {
                    cur = 0;
                    break;
                }
            }

        }

        return res;
    }

}
