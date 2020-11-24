package github.veikkoroc.DataStructure.Array;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/22 6:19
 */
public class LeetCode1217 {
    /**
     * 奇数多返回偶数个数，偶数多返回奇数的个数
     * @param position
     * @return
     */
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;

        for (int i : position) {
            if (i%2 == 0){
                even++;
            }else {
                odd++;
            }
        }


        return odd > even?even:odd;
    }
    public int minCostToMoveChips1(int[] position) {
        int odd = 0;


        for (int i : position) {
            if (i%2 != 0){
                odd++;
                if (odd > position.length/2){
                    return position.length-odd;
                }
            }
        }

        return odd > position.length/2?position.length-odd:odd;
    }
}
