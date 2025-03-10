package lazy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @author liweihua
 * @classname Application
 * @description TODO
 * @date 2023/6/21 10:01
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public lazy.User createUser() {
        return new lazy.User("韩宣生", "11111", 24);
    }

    @Bean
//    @Lazy
    public Person createPerson() {
        return new Person("韩立", "11111", 24);
    }
}
