import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class MultiThreadFutureExample {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 创建一个用于存储 Future 对象的列表
        List<Future<Integer>> futures = new ArrayList<>();

        // 提交多个 Callable 任务给线程池执行
        for (int i = 0; i < 10; i++) {
            Callable<Integer> task = new MyCallable(i);
            Future<Integer> future = executor.submit(task);
            futures.add(future);
        }

        // 在这里可以做一些其他的事情，不会阻塞主线程

        // 遍历 Future 列表，获取任务的执行结果
        for (Future<Integer> future : futures) {
            try {
                Integer result = future.get(); // 阻塞主线程，等待任务执行完成并获取结果
                System.out.println("任务执行结果: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // 关闭线程池
        executor.shutdown();
    }

    static class MyCallable implements Callable<Integer> {
        private final int id;

        public MyCallable(int id) {
            this.id = id;
        }

        @Override
        public Integer call() throws Exception {
            // 模拟一个耗时的任务
            Thread.sleep(2000);
            return id * 10;
        }
    }
}