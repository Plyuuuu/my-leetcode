package github.veikkoroc.DynamicProgramming;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 *
 *
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/23 10:39
 */
public class LeetCode64 {
    public static void main(String[] args) {
        int[][] arr = { {1,3,1},
                        {1,5,1},
                        {4,2,1}};
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println(minPathSum(arr));


    }
    public static int minPathSum(int[][] grid) {
        if (grid==null){
            return -1;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //1、在起点
                if (i==0&&j==0){
                    continue;
                }
                //2、上面是边界时
                if (i==0){
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                }
                //3、左边是边界时
                if (j==0){
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                }
                //上面和左边都是不是边界
                if (i!=0 && j!=0){
                    grid[i][j] = grid[i][j] + Math.min(grid[i-1][j],grid[i][j-1]);
                }
            }
        }


        return grid[grid.length-1][grid[0].length-1];
    }
}
