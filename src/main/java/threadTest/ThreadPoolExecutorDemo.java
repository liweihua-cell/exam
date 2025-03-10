package threadTest;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.*;

/**
 * @author liweihua
 * @classname ThreadPoolExecutorDemo
 * @description TODO
 * @date 2023/6/13 14:02
 */
public class ThreadPoolExecutorDemo implements InitializingBean, DisposableBean {

    private static final Integer DEFAULT_THREAD_POOL_SIZE = 5;
    private ScheduledExecutorService executorService;

    public ThreadPoolExecutorDemo() {
        this.executorService = Executors.newScheduledThreadPool(DEFAULT_THREAD_POOL_SIZE, (new ThreadFactoryBuilder()).setNameFormat("sync-schedule-pool-%d").build());
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
                200, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(4));
        for (int i = 0; i < 14; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目:" + executor.getPoolSize() + ",队列中等待执行的任务数目："
                    + executor.getQueue().size() + ",已执行完别的任务数目:" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy thread = " + Thread.currentThread().getName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("running Thread = " + Thread.currentThread().getName());
    }


}
