package threadTest;

/**
 * @author liweihua
 * @classname ThreadTest1
 * @description TODO
 * @date 2023/8/17 15:08
 */

/*
设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。写出程序
 */
public class ThreadTest1 {
    private int j;

    public static void main(String[] args) {
        ThreadTest1 test = new ThreadTest1();
        Inc inc = test.new Inc();
        Dec dec = test.new Dec();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(inc);
            thread.start();

            thread = new Thread(dec);
            thread.start();
        }
    }


    private synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }

    private synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + "-dec" + j);
    }

    class Inc implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }
}
