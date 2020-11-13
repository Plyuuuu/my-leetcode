package github.veikkoroc.BitOperation;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/13 18:01
 */
public class LeetCode191 {
    public int hammingWeight(int n) {

        int count = 0;
        while (n != 0){
            count++;
            n=(n&(n-1));
        }
        return count;
    }
}
