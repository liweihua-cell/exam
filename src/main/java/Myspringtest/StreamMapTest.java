package Myspringtest;

import lombok.Data;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;


//stream()优点
//无存储。stream不是一种数据结构，它只是某种数据源的一个视图，数据源可以是一个数组，Java容器或I/O channel等。
//为函数式编程而生。对stream的任何修改都不会修改背后的数据源，比如对stream执行过滤操作并不会删除被过滤的元素，而是会产生一个不包含被过滤元素的新stream。
//惰式执行。stream上的操作并不会立即执行，只有等到用户真正需要结果的时候才会执行。
//可消费性。stream只能被“消费”一次，一旦遍历过就会失效，就像容器的迭代器那样，想要再次遍历必须重新生成。

/**
 * @author liweihua
 * @classname StreamMapTest
 * @description TODO
 * @date 2022/1/10 16:10
 */
@Data
public class StreamMapTest {
    private String userName;
    private String passWord;
    private Integer age;

    public StreamMapTest() {

    }

    public StreamMapTest(String userName, String passWord, Integer age) {
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
    }

    public static void main(String[] args) {
        String a = "4";
        System.out.println("=============" + a.hashCode());
        ArrayList<StreamMapTest> list = new ArrayList<>();
        list.add(new StreamMapTest("zhangsan", "111", 40));
        list.add(new StreamMapTest("lisi", "222", 50));
        list.add(new StreamMapTest("wangwu", "333", 60));
        list.add(new StreamMapTest("wangwu", "333", 60));
        list.add(new StreamMapTest("wangwu", "333", 60));
        System.out.println("list:" + list.toString());
        System.out.println("\ntest1:");
        list.stream()
                .forEach(n -> System.out.println(n));
        System.out.println("\ntest2--age:");
        list.stream().map(n -> n.getAge())
                .forEach(n -> System.out.println(n));
        System.out.println("\ntest3--age:");
        list.stream().map(n -> n.getAge())
                .forEach(n -> System.out.println(n));

        System.out.println("\ntest2--userName:");
        list.stream().map(n -> n.getUserName())
                .forEach(n -> System.out.println(n));

        System.out.println("\ntest3--userName:");
        list.stream().map(n -> n.getUserName())
                .forEach(n -> System.out.println(n));
        int ran2 = (int) (Math.random() * (10000000 - 1) + 1);
        System.out.println("=================" + ran2);

        list.stream().limit(3);
        System.out.println(list);
    }
}
