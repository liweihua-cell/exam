package treeSet;

import java.util.TreeSet;

/**
 * @author liweihua
 * @classname TreeSetTest
 * @description TODO
 * @date 2023/8/21 16:27
 */
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        set.add(new Parent(3));
        set.add(new Child());
        set.add(new Parent(4));
        System.out.println(set.size());
    }
}
