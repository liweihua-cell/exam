import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author liweihua
 * @classname SpringBeanApplicationTests
 * @description TODO
 * @date 2022/11/28 11:23
 */
@SpringBootTest
@ContextConfiguration(locations = {"classpath:application.yml"})
public class SpringBeanApplicationTests {

    public static void main(String[] args) {
        RedisTemplate redisTemplate = new RedisTemplate();
        RedisTest redisTest = new RedisTest(redisTemplate);
        System.out.println(redisTest.hasKey("asd"));
    }

}
