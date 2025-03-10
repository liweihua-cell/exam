package threadTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liweihua
 * @classname ThreadDemo
 * @description TODO
 * @date 2023/6/12 9:26
 */
public class ThreadDemo {
    public static List arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Thread[] threadArray = new Thread[1000];
        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new MyThread();
            threadArray[i].start();
        }
        for (int i = 0; i < threadArray.length; i++) {
            try {
                threadArray[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.stream().distinct().collect(Collectors.toList());
            System.out.println(arrayList.get(i));
        }
    }
}
