package github.veikkoroc.z_test;

import org.junit.Test;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/11 22:19
 */
public class Test02 {
    static int count = 0;
    public static void main(String[] args) {
        setCount();
        System.out.println(count);
    }
    public static void setCount(){
        count++;
    }

    int count2 = 0;
    @Test
    public void test(){
        setCount2();
        System.out.println(count2);
    }
    private void setCount2(){
        count2++;
    }


}
