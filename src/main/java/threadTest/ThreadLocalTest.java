package threadTest;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author liweihua
 * @classname ThreadLocalTest
 * @description TODO
 * @date 2023/11/20 11:39
 */
class ThreadLocaTest {

    private static ThreadLocal<String> localVar = new ThreadLocal<String>();

    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        //清除本地内存中的本地变量
        localVar.remove();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalRandom.current().nextInt(1,99);

        new Thread(new Runnable() {
            public void run() {
                ThreadLocaTest.localVar.set("local_A");
                print("A");
                //打印本地变量
                System.out.println("after remove : " + localVar.get());

            }
        }, "A").start();

        Thread.sleep(1000);

        new Thread(new Runnable() {
            public void run() {
                ThreadLocaTest.localVar.set("local_B");
                print("B");
                System.out.println("after remove : " + localVar.get());

            }
        }, "B").start();
    }
}
