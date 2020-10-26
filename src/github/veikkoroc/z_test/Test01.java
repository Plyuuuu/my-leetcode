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

    /**
     * str1 在方法区的常量池中
     * str2 在堆空间中
     */
    @Test
    public void test03(){
        long test = 012;
        String str1 = "hello";
        String str2 = "hel"+new String("lo");
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str1==str2);
        System.out.println(str2.equals(str1));
    }
    @Test
    public void test05(){
        int[] arr = {1};
        int num = 1;
        change(arr,num);
        System.out.println(arr[0]+"------"+num);
    }
    public void change(int[] arr,int num){
        arr[0] = 2;
        num = 2;
    }


    public void test06(){

    }


}
