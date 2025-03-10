package treeSet;

/**
 * @author liweihua
 * @classname Parent
 * @description TODO
 * @date 2023/8/21 16:27
 */
public class Parent implements Comparable {
    private int age = 0;

    public Parent(int age) {
        this.age = age;
    }

    public int compareTo(Object o) {
        System.out.println("method of parent");
        Parent o1 = (Parent) o;
        return Integer.compare(age, o1.age);
    }


}
