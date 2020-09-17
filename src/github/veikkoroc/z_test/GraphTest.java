package github.veikkoroc.z_test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/16 14:53
 */
public class GraphTest {


    /**
     * 存放图顶点的集合
     */
    private ArrayList<String> vertexList;

    /**
     * 存放图 的邻接矩阵
     */
    private int[][] matrix;

    /**
     * 表示边的数目
     *
     */
    private int numOfEdges;

    /**
     *定义辅助数组boolean[],记录某个节点是否被访问
     *
     */
    private boolean[] isVisited ;




    public static void main(String[] args) {

        //节点个数
        int n = 5;
        //节点值
        String[] vertexValue = {"A","B","C","D","E"};
        //创建图
        GraphTest graph = new GraphTest(n);
        //循环添加节点
        for (String s : vertexValue) {
            graph.addVertex(s);
        }
        //添加边 A-B;A-C;B-C;B-D;B-E
        graph.addEdge(0,1,1);
        graph.addEdge(0,2,1);
        graph.addEdge(1,2,1);
        graph.addEdge(1,3,1);
        graph.addEdge(1,4,1);
        //显示图的邻接矩阵
        graph.showGraph();

        System.out.println("====DFS====");
        graph.dfs();
    }

    /**
     *  图的构造器
     * @param n 图的顶点个数
     */
    public GraphTest(int n){
        //初始化邻接矩阵
        matrix = new int[n][n];
        //初始化顶点集合
        vertexList = new ArrayList<>(n);
        //默认边数为0
        numOfEdges = 0;
        //是否被访问的辅助数组
        isVisited = new boolean[n];
    }

    /**
     * 给图插入节点
     * @param s 插入的节点
     */
    public void addVertex(String s){
        vertexList.add(s);
    }

    /**
     * 添加边
     * @param v1   “A”-“B” ： “A” = v1 = 0；“B” = v2 = 1； weight=1
     * @param v2    v2表示第二个顶点的下标        v1+v2表示在邻接表的位置
     * @param weight  权重
     */
    public void addEdge(int v1,int v2,int weight){
        matrix[v1][v2] = weight;
        matrix[v2][v1] = weight;
        //边数+1
        numOfEdges++;
    }




    /**
     * 获取第一个邻接节点的下标W
     * @param index 指定节点在ArrayList的位置，也就是二维数组的 x 轴的位置
     * @return 第一个邻接节点在ArrayList的位置,如果没有返回-1
     */
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (matrix[index][i] >0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一节点的下标，获取下一个邻接节点
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2+1; i < vertexList.size(); i++) {
            if (matrix[v1][i]>0){
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     * @param isVisited 辅助数组
     * @param fist  第一次访问的节点的下标，第一次是0
     */
    public void dfs(boolean[] isVisited,int fist){
        //首先访问第一个节点，输出
        System.out.print(vertexList.get(fist)+"->");
        //把该节点对应的isVisited设置问True
        isVisited[fist] = true;

        //查找第一个节点的邻接节点
        int w = getFirstNeighbor(fist);

        //如果有
        while(w!=-1){
            //没有被访问过，递归
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            //如果被访问过，则获得下一邻接节点
            w = getNextNeighbor(fist,w);
        }
    }

    /**
     * 对dfs进行重载，遍历所有节点进行dfs
     */
    public void dfs(){
        //遍历所有的节点，进行dfs[递归]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }


    /**
     * 图中常用方法
     */
    public int getNumOfVertex(){
        return vertexList.size();
    }

    /**
     * 获得边数
     * @return
     */
    public int getNumOfEdges(){
        return numOfEdges;
    }

    /**
     * 返回节点i对应的数据：0-“A”；1-“B”
     * @param i
     * @return
     */
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    /**
     * 返回v1和v2的权值
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1,int v2){
        return matrix[v1][v2];
    }

    /**
     * 显示图对应的矩阵
     */
    public void showGraph(){
        for (int[] link: matrix){
            System.err.println(Arrays.toString(link));
        }
    }

}
