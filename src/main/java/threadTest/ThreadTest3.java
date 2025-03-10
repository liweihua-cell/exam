package threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liweihua
 * @classname ThreadTest3
 * @description TODO
 * @date 2023/8/17 15:54
 */

/**
 * 子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，接着再回到主线程又循环100，如此循环50次，请写出程序
 */
public class ThreadTest3 {
    private static Lock lock = new ReentrantLock();
    private static Condition subThreadCondition = lock.newCondition();
    private static boolean bBhouldASubThread = false;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    lock.lock();
                    try {
                        if (!bBhouldASubThread)
                            subThreadCondition.await();
                        for (int j = 0; j < 10; j++) {
                            System.out.println(Thread.currentThread().getName() + ",j=" + j);
                        }
                        bBhouldASubThread = false;
                        subThreadCondition.signal();
                    } catch (Exception e) {

                    } finally {
                        lock.unlock();
                    }
                }
            }
        });
        threadPool.shutdown();
        for (int i = 0; i < 50; i++) {
            lock.lock();
            try {
                if (bBhouldASubThread)
                    subThreadCondition.await();
                for (int j = 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getName() + ",j=" + j);
                }
                bBhouldASubThread = true;
                subThreadCondition.signal();
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }
}
