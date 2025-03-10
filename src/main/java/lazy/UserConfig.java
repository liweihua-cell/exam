package lazy;

import org.springframework.stereotype.Component;

/**
 * @author liweihua
 * @classname UserConfig
 * @description TODO
 * @date 2023/6/21 10:06
 */
@Component
public class UserConfig {
    private PersonConfig personConfig;

    public UserConfig(PersonConfig personConfig) {
        this.personConfig = personConfig;
        System.out.println("我是用户配置 UserConfig");
    }
}
