import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.sql.Time;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author liweihua
 * @classname RedisTest
 * @description TODO
 * @date 2023/8/29 14:58
 */
public class RedisTest extends RedisTemplate {
    public static final long VALID_HOUR = 2L;

    private final RedisTemplate<String, Object> redisTemplate;
    RedissonClient redissonClient;

    public RedisTest(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void expire(String key, long time) {
        redisTemplate.expire(key, time, TimeUnit.MINUTES);
    }

    public long getExpire(String key) {
        Long expire = redisTemplate.getExpire(key);
        return expire;
    }

    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    //redis实现分布式锁1
    public void testLock() throws InterruptedException {
        String uuid = UUID.randomUUID().toString();
        Boolean b_lock = redisTemplate.opsForValue().setIfAbsent("lock", uuid, 10, TimeUnit.SECONDS);
        if (b_lock) {
            Object value = redisTemplate.opsForValue().get("num");
            if (StringUtils.isEmpty(value.toString())) {
                return;
            }
            int num = Integer.parseInt(value + "");
            redisTemplate.opsForValue().set("num", ++num);
            Object lockUUID = redisTemplate.opsForValue().get("lock");
            if (uuid.equals(lockUUID.toString())) {
                redisTemplate.delete("lock");
            }
        } else {
            Thread.sleep(100);
            testLock();
        }
    }

    //redis实现分布式锁2
    public void redissonLock(){
        String REDIS_HOST = "127.0.0.1";
        int REDIS_PORT = 6379;
        String LOCK_NAME = "request_lock";
        // 创建 Redisson 客户端连接
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://" + REDIS_HOST + ":" + REDIS_PORT);

        RedissonClient redisson = Redisson.create(config);

        // 获取分布式锁
        boolean isLocked = redisson.getLock(LOCK_NAME).tryLock();
        if (isLocked) {
            try {
                // 成功获取锁，执行业务逻辑
                System.out.println("执行业务逻辑...");
            } finally {
                // 释放锁
                redisson.getLock(LOCK_NAME).unlock();
            }
        } else {
            // 获取锁失败，拒绝处理当前请求
            System.out.println("当前有其他请求正在处理，请稍后重试...");
        }

        // 关闭 Redisson 客户端连接
        redisson.shutdown();
    }

    public static void main(String[] args) {
        // 1、 new Jedis 对象即可
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // jedis 所有的命令就是我们之前的所有指令
        System.out.println(jedis.ping());
        //清空当前库的所有数据
        jedis.flushDB();
        jedis.set("name", "lihua");
        jedis.set("age", "23");
        jedis.set("hight", "173cm");
        jedis.lpush("list", "dsas", "dsagdg", "gfdg");
        System.out.println("list: " + jedis.lrange("list", 0, -1));

        System.out.println("name:" + jedis.get("name") + "\nage:" + jedis.get("age") + "\nhight" + jedis.get("hight"));



    }
}
