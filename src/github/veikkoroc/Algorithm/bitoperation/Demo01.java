package github.veikkoroc.algorithm.bitoperation;

import java.util.Arrays;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/24 11:02
 */
public class Demo01 {

    /**
     * 交换两个数，不用第三个数
     * @param args
     */
    public static void main(String[] args) {
        int[] change = change(1, 2);
        System.out.println(Arrays.toString(change));
    }

    public static int[] change(int a,int b){

        a = a + b;

        b = a - b;

        a = a - b;

        return new int[]{a,b};
    }

}
