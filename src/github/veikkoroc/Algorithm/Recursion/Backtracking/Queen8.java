package github.veikkoroc.Algorithm.Recursion.Backtracking;

import org.junit.Test;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/11 19:38
 */
public class Queen8 {

    /**
        定义一个Max表示共有多少皇后
     */
    int max = 8;


    /**
     * 定义一个数组array，保存皇后放置位置的结果
      */
    int[] arr = new int[max];

    /**
     * 为什么是静态才可以？？？
     */
    int count = 0;


    @Test
    public void test() {
        check(0);
        System.out.println(count);
    }


    /**
     * 放置第n个皇后
     * @param n
     */
    private  void check(int n){
        // n从0开始，n == 8 相当于在放第九个皇后
        if (n == max){
            print();
            return;
        }
        // 依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前皇后n，放入该行第一列
            arr[n] = i;
            // 判断当前放置第n个皇后到i列时，是否冲突
            if (judge(n)){
                //System.out.println(n);
                // 不冲突，放n+1个皇后，即开始递归
                check(n+1);
            }
            // 如果冲突，i++继续执行
        }

    }


    /**
     * 当我们放置第 n 个皇后，就检测该皇后是否与之前摆好的皇后冲突
     *  1、第n个皇后不能和之前在同一列
     *  2、也不能和已有的皇后的斜率为 +-1
     * @param n
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //if (arr[n] == arr[i] || n - i == arr[n] -arr[i] || i - n == arr[n] -arr[i] ){
            if (arr[n] == arr[i] ||Math.abs(n-i) == Math.abs(arr[n] - arr[i]) ){
                return false;
            }
        }
        return true;
    }


    /**
     * 打印正确解的结果
     */
    private void print(){
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}
