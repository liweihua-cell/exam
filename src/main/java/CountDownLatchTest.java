import order.utils.SynchroniseUtil;

/**
 * @author liweihua
 * @classname CountDownLatch
 * @description TODO
 * @date 2023/6/9 16:08
 */
/*计数器*/
public class CountDownLatchTest {
    private static volatile java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        SynchroniseUtil<String> synchroniseUtil = new SynchroniseUtil<>(2);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("子线程1结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    synchroniseUtil.setResult("线程1执行成功");
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("子线程2结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }
        });
        thread1.start();
        thread2.start();
        System.out.println("等待所有子线程结束---");
        String result = synchroniseUtil.getResult();
        System.out.println("所有子线程结束");
        System.out.println("返回结果:" + result);
    }
}
