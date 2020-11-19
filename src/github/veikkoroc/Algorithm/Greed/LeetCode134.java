package github.veikkoroc.Algorithm.Greed;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/18 20:00
 */
public class LeetCode134 {

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    /**
     * 暴力法
     *
     * @param gas
     * @param cost
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        // gas总和 >= cost总和才能走完
        int gasSum = 0;
        int costSum = 0;

        int length = gas.length;
        for (int i = 0; i < length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (gasSum < costSum){
            return -1;
        }

        System.out.println("gasSum"+gasSum);
        System.out.println("costSum"+costSum);

       // 如果从 i 出发能回到 i，返回i
        int i = 0;
        while (i< length){
            int temp = i;

            // 判断当前i是不是解
            // 当前剩余汽油
            int surplus = 0;
            // 计数器
            int count = 0;
            for (int j = 0; j < length; j++) {

                temp = temp%gas.length;

                surplus += gas[temp] - cost[temp];

                if (surplus < 0){
                    break;
                }

                temp++;
                count++;
            }
            if (count == length){
                return i;
            }

            i++;
        }

        return -1;
    }

}
