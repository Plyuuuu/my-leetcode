package github.veikkoroc.DataStructure.Array;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/12 17:57
 */
public class LeetCode922 {

    /**
     * 双指针
     * @param A
     * @return
     */
    public int[] sortArrayByParityII3(int[] A) {

        // 创建奇偶指针
        int even = 0;
        int odd = 1;

        // 交换的临时变量
        int temp ;

        for (even = 0; even < A.length; even = even+2) {
            // 如果偶数下标的数不是偶数，就与奇数下标不是奇数的数交换
            if (A[even] % 2!=0){
                while (A[odd] %2 ==1){
                    odd = odd+2;
                }
                temp = A[even];
                A[even] = A[odd];
                A[odd] = temp;
            }
        }


        return A;
    }

    /**
     * 奇偶集合改进为一个集合
     * @param A
     * @return
     */
    public int[] sortArrayByParityII2(int[] A) {

        // 奇偶集合
        LinkedList<Integer> oddAndEven = new LinkedList<>();


        // 把奇数偶数归类
        for (int i : A) {
            if (i % 2 == 0){
                // 偶数放开头
                oddAndEven.addFirst(i);
            }else {
                // 奇数放结尾
                oddAndEven.addLast(i);
            }
        }

        // 再把奇数偶数交叉放回数组
        for (int i = 0; i < A.length; i++) {
            if (i%2 == 0){
                A[i] = oddAndEven.pollFirst();
            }else {
                A[i] = oddAndEven.pollLast();
            }
        }

        return A;
    }

    /**
     * 奇偶集合
     * @param A
     * @return
     */
    public int[] sortArrayByParityII(int[] A) {

        // 奇偶集合
        LinkedList<Integer> odd = new LinkedList<>();
        LinkedList<Integer> even = new LinkedList<>();

        // 把奇数偶数归类
        for (int i : A) {
            if (i % 2 == 0){
                even.add(i);
            }else {
                odd.add(i);
            }
        }

        // 再把奇数偶数交叉放回数组
        for (int i = 0; i < A.length; i++) {
            if (i%2 == 0){
                A[i] = even.poll();
            }else {
                A[i] = odd.poll();
            }
        }

        return A;
    }

    /**
     * 辅助指针找合适值交换
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParityII1(int[] A) {

        // 交换时临时变量
        int temp;
        // 辅助指针
        int helpPoint;

        // 遍历数组
        for (int i = 0; i < A.length; i++) {
            // 如果i是偶数，则A[i]也是偶数
            if (i % 2 == 0){
                // A[i]也是偶数就继续遍历
                if (A[i]%2 == 0){
                 continue;

                 // A[i]是奇数，就找后面的偶数与其交换
                }else {
                    helpPoint = i+1;
                    while (A[helpPoint]%2 !=0){
                        helpPoint++;
                    }
                    // 跳出循环说明找到偶数了，开始交换
                    temp = A[i];
                    A[i] = A[helpPoint];
                    A[helpPoint] = temp;
                }
                // 如果i是奇数，则A[i]也是奇数
            }else {
                // A[i]是奇数,继续遍历
                if (A[i] % 2 != 0){
                    continue;

                // A[i]是偶数,就找后面的奇数与其交换
                }else {
                    helpPoint = i+1;
                    while (A[helpPoint]%2 ==0){
                        helpPoint++;
                    }
                    // 跳出循环说明找到偶数了，开始交换
                    temp = A[i];
                    A[i] = A[helpPoint];
                    A[helpPoint] = temp;

                }


            }
        }


        return A;
    }
}
