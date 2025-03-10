public class WaitNotifyExample {
    private static final Object lock = new Object();
    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while (!flag) {
                    try {
                        System.out.println("Thread 1 is waiting");
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Thread 1 is awakened");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                flag = true;
                System.out.println("Thread 2 is notifying");
                lock.notify();
                // 如果使用notifyAll()方法，则会唤醒所有等待线程
                // lock.notifyAll();
            }
        });

        t1.start();
        Thread.sleep(1000); // 确保t1先执行
        t2.start();
    }
}