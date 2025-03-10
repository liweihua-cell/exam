package threadTest;

/**
 * @author liweihua
 * @classname MyThread
 * @description TODO
 * @date 2023/6/12 9:21
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        new MyThread().setDaemon(true);
        Thread a = new MyThread();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadDemo.arrayList.add(Thread.currentThread().getName() + "" + System.currentTimeMillis());
    }
}
