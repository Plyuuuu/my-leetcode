package github.veikkoroc.algorithm.bitoperation;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2021/3/25 15:25
 */
public class Demo02 {
    public static void main(String[] args) {
        int a = 0b11111111111111111111111111111111;// 源码，补码表示就是-1 = 0b 10000000 00000000 0000000 00000001
        int b = 0xffffffff;
        System.out.println(a-1);// 计算机使用补码计算
        System.out.println(b);
        System.out.println(a^2);// 补码计算 = 0，源码计算 = -3
    }
}
