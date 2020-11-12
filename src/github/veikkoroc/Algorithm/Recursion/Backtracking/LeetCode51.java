package github.veikkoroc.Algorithm.Recursion.Backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/12 18:54
 */
public class LeetCode51 {


    /**
        单个解
     */
     ArrayList<String> solution = new ArrayList<>();
    /**
     *  总的结果
     */
     ArrayList<List<String>> solutionAll = new ArrayList<>();


    int max;

    int[] arr;

    char[] res ;


    @Test
    public void test(){

        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);
    }

    public List<List<String>> solveNQueens(int n) {
        max = n;
        arr = new int[max];
        res = new char[max];
        check(0);

        return solutionAll;
    }
    /**
     * 放置第n个皇后
     * @param n
     */
    private  void check(int n){
        // n从0开始，n == 8 相当于在放第九个皇后
        if (n == max){

            save();
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
     * 判断第n个函数是否可以加入
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
     * 保存结果
     */
    private void save(){


        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < max; j++) {
                res[j] = '.';
            }


            res[arr[i]] = 'Q';
            solution.add(new String(res));
          //  System.out.println(solution);
        }

        solutionAll.add(solution);

        //System.out.println(solutionAll);

        solution = new ArrayList<>();

    }
}
