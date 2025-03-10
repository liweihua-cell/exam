package threadTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liweihua
 * @classname ThreadTest
 * @description TODO
 * @date 2023/8/17 14:57
 */
public class ThreadTest {
    private int j;
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        for (int i = 0; i < 2; i++) {
            new Thread(test.new Adder()).start();
            new Thread(test.new Subtractor()).start();
        }
    }


    private class Subtractor implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    System.out.println("j--=" + j--);
                } finally {
                    lock.unlock();
                }
            }
        }
    }


    private class Adder implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    System.out.println("j++=" + j++);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
