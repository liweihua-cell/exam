package order.utils;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.*;

/**
 * @author liweihua
 * @classname ThreadPoolExecutors
 * @description TODO
 * @date 2023/6/8 9:21
 */
public class ThreadPoolExecutors {
    RedisTemplate<String, Object> redisTemplate;

    public ThreadPoolExecutors(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setObject(String key, Object value) {
        this.redisTemplate.opsForValue().set(key, value, 2L, TimeUnit.HOURS);
    }

    private static final int processorNumber =
            Runtime.getRuntime().availableProcessors();
    private static final int corePoolSize = processorNumber;
    private static final int maximumPoolSize = processorNumber * 2 + 1;
    private static final int queueSize = 100;

    private static class ThreadPoolExecutorsHolder {
        private static final ThreadPoolExecutor INSTANCE =
                new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                        200, TimeUnit.MILLISECONDS,
                        new LinkedBlockingDeque<>(queueSize));
    }

    private ThreadPoolExecutors() {
    }

    public static ThreadPoolExecutor getSingletonExecutor() {
        System.out.println("处理器数量:" + processorNumber);
        return ThreadPoolExecutorsHolder.INSTANCE;
    }

    public static int getQueueSize() {
        return queueSize;
    }
}
