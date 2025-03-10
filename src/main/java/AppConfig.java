import Config.Pet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liweihua
 * @classname AppConfig
 * @description TODO
 * @date 2022/11/28 9:09
 */
@Configuration
public class AppConfig {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}

class MyBean {
    public MyBean() {
        System.out.println("Mybean Initializing");
    }
}
