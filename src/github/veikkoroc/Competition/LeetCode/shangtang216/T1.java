package github.veikkoroc.Competition.LeetCode.shangtang216;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/22 10:47
 */
public class T1 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        String s1 = "";
        for (String s : word1) {
            s1+=s;
        }
        String s2 = "";
        for (String s : word2) {
            s2 +=s;
        }

        return s1.equals(s2);
    }
}
