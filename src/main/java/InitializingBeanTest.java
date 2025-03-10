import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author liweihua
 * @classname InitializingBean
 * @description TODO
 * @date 2023/6/21 9:04
 */

/**
 * 实现DisposableBean, InitializingBean接口之后服务启动时即会实现afterPropertiesSet方法，
 * 多用在服务初始化（类似于开机自启动）
 */
@Data
public class InitializingBeanTest implements DisposableBean, InitializingBean {
    private int id;

    private String name;

    private String beanName;

    public InitializingBeanTest() {
        System.out.println("InitializingBeanTest 被实例化");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
