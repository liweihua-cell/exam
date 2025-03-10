package threadTest;

/**
 * @author liweihua
 * @classname InterruptThreadDemo
 * @description TODO
 * @date 2023/9/6 14:03
 */
//interrupt:线程阻塞方法
public class InterruptThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Mythread mythread = new Mythread();
        System.out.println("starting thread...");
        mythread.start();
        Thread.sleep(1000);
        System.out.println("Interrupt thread..." + mythread.getName());
        mythread.stop = true;//设置共享变量为true
        mythread.interrupt();//阻塞时退出阻塞状态
        Thread.sleep(3000);//主线程休眠3秒以便观察线程m1的中断情况
        System.out.println("stopping application");

    }

    public static class Mythread extends Thread {
        volatile boolean stop = false;

        @Override
        public void run() {
            while (!stop) {
                System.out.println(getName() + "is running");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("week up from block...");
                    stop = true;// 在异常处理代码中修改共享变量的状态
                }
            }
            System.out.println(getName() + "is exiting");

        }

    }
}
