package github.veikkoroc.Algorithm.Greed;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/8 19:30
 */
public class LeetCode1046 {

    public static void main(String[] args) {
        // System.out.println(Math.abs(-2));

        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }

    public static int lastStoneWeight(int[] stones) {
        // 边界判断
        if (stones.length == 1){
            return stones[0];
        }
        if (stones.length == 2){
            return Math.abs(stones[0]-stones[1]);
        }

        // 把stones从小到大排序
        Arrays.sort(stones);

        int length = stones.length-1;

        for (int i = 0; i < stones.length; i++) {

            stones[length] = stones[length]-stones[length-1];
            stones[length-1] = 0;

            Arrays.sort(stones);
        }

        return stones[length];
    }

}
