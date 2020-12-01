package github.veikkoroc.algorithm.DivideAndConquer;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/11/10 16:37
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(3,'A','B','C');
    }
    public static void hanoiTower(int num,char a,char b,char c){

        // 如果是一个盘,直接移动到C处，A=>C
        if (num == 1){
            System.out.println("第1个盘: "+a+" => "+c);
        }else {
            // >=2个盘，先把第一个盘以上的盘(num-1个盘)移到B盘
            hanoiTower(num-1,a,c,b);

            // 再把最后一个盘移到C
            System.out.println("第"+num+"个盘: "+a+" => "+c);

            // 再把 B上的所有盘移到C
            hanoiTower(num-1,b,a,c);
        }
    }
}
