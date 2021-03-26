package github.veikkoroc.DataStructure.hash;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/27 9:51
 */
public class LeetCode454 {

    @Test
    public void test(){
        int[] a = {-1,-1};
        int[] b = {-1,1};
        int[] c = {-1,1};
        int[] d = {1,-1};
        fourSumCount(a,b,c,d);
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        int res = 0;

        // 把 A 与 B 的所有结果存入Map中

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int temp = A[i] + B[j];
                if (!map.containsKey(temp)){
                    map.put(temp,1);
                }else {
                    Integer value = map.get(temp);
                    map.put(temp,++value);
                }
            }
        }

        System.out.println(map.toString());

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int temp = -(C[i]+D[j]);
                if (map.containsKey(temp)){
                    res += map.get(temp);
                }
            }
        }


        return res;
    }
}
