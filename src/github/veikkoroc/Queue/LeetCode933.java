package github.veikkoroc.Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/10/14 11:01
 */
public class LeetCode933 {
    public static void main(String[] args) {

    }
    Queue<Integer> q;
    public LeetCode933() {
        q = new LinkedList();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000){
            q.poll();
        }
        return q.size();
    }


}
