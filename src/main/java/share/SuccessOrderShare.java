package share;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author liweihua
 * @classname SuccessOrderShare
 * @description TODO
 * @date 2023/11/14 10:50
 */
@Component
public class SuccessOrderShare implements Share {
    @Override
    public String getShareFunctionType() {
        return ShareFactory.EnumShareType.SUCCESS_ORDER.getName();
    }

    @Override
    public String mainProcess(String shareName) {
        return shareName;
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ShareFactory shareFactory = (ShareFactory) applicationContext.getBean("shareFactory");
        Share shareFunction = shareFactory.getShareFunction(ShareFactory.EnumShareType.SUCCESS_ORDER.getName());
        String success_order = shareFunction.mainProcess("Success order");
        System.out.println(success_order);
    }
}
