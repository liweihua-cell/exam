package lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author liweihua
 * @classname PersonConfig
 * @description TODO
 * @date 2023/6/21 10:05
 */
@Component
public class PersonConfig {
    private UserConfig userConfig;

    public PersonConfig(@Lazy UserConfig userConfig) {
        this.userConfig = userConfig;
        System.out.println("我是用户配置 PersonConfig");
    }
}
