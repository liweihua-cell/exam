package order.task;

import order.entity.OrderVO;
import order.entity.User;
import order.utils.SynchroniseUtil;

import java.util.List;

/**
 * @author liweihua
 * @classname OrderTask
 * @description TODO
 * @date 2023/6/8 9:19
 */
public class OrderTask implements Runnable {
    private List<OrderVO> orderVOS;
    private List<User> users;
    private SynchroniseUtil<OrderVO> synchroniseUtil;

    public OrderTask(List<OrderVO> orderVOS,
                     List<User> users,
                     SynchroniseUtil<OrderVO> synchroniseUtil) {
        this.orderVOS = orderVOS;
        this.users = users;
        this.synchroniseUtil = synchroniseUtil;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (OrderVO orderVO : orderVOS) {
            for (User user : users) {
                if (orderVO.getUserId().equals(user.getId())) {
                    orderVO.setUserName(user.getUserName());
                    break;
                }
            }
        }
        synchroniseUtil.addResult(orderVOS);
    }
}
