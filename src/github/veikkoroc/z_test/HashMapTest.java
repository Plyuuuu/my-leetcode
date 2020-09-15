package github.veikkoroc.z_test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/15 21:49
 */
public class HashMapTest {
    public static void main(String[] args) {
        //Set
        HashMap<Character,String> hashMap = new HashMap();

            hashMap.put('D',"value: 1");
            hashMap.put('B',"value: 2");
            hashMap.put('A',"value: 3");
            hashMap.put('C',"value: 4");

        //遍历集合
        Set<Character> keySet = hashMap.keySet();
        Iterator<Character> it = keySet.iterator();
        while (it.hasNext()){
            Character key = it.next();
            String value = hashMap.get(key);
            if (key==5){

            }
            System.out.println("Key: "+key+" value: "+value);
        }
    }
}
