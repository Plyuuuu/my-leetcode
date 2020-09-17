package github.veikkoroc.z_test;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/15 16:41
 */
public class Test01 {
    public static void main(String[] args) {
        //Map
        //LinkedList
        int x = 0;
        int i = 1;
        for (;;x+=i){
            System.out.println("sss");
        }
    }
    @Test
    public void test01(){
        int  a = 0;
        while ( a < 5 ) {

            switch(a){
                case 0:

                case 3:
                    a = a + 2;
                case 1:

                case 2:
                    a = a + 3;
                default:
                    a = a + 5;
            }
    
        }

        System.out.print(a);
    }
    @Test
    public void test02(){
        int[][] arr = {{1,2},{1,3},{1,4}};
        System.out.println(Arrays.toString(arr[0]));
    }
}
