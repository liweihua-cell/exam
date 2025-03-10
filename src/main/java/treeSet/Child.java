package treeSet;

/**
 * @author liweihua
 * @classname Child
 * @description TODO
 * @date 2023/8/21 16:31
 */
public class Child extends Parent {
    public Child() {
        super(3);
    }

    public int compareTo(Object o) {

        // TODO Auto-generated method stub
        System.out.println("method of child");
//			Child o1 = (Child)o;
        return 1;

    }
}
