package order.controller;

import order.entity.OrderVO;
import order.entity.User;
import order.task.OrderTask;
import order.utils.SynchroniseUtil;
import order.utils.ThreadPoolExecutors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author liweihua
 * @classname OrderController
 * @description TODO
 * @date 2023/6/7 15:07
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private List<OrderVO> orderVOS = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private final ConcurrentMap<Object, Future<String>> taskCache = new ConcurrentHashMap<>();


    @PostConstruct
    public void createData() {
        long dataCount = 500;

        for (long i = 0; i < dataCount; i++) {
            OrderVO orderVO = new OrderVO();
            orderVO.setId(i + 1);
            orderVO.setUserId(i + 1);
            orderVO.setCreateTime(LocalDateTime.now().plusSeconds(1));
            orderVOS.add(orderVO);
        }

        for (long i = 0; i < dataCount; i++) {
            User user = new User();
            user.setId(i + 1);
            user.setUserName("用户名" + (i + 1));
            users.add(user);
        }
        orderVOS = orderVOS.stream().sorted(Comparator.comparing(OrderVO::getCreateTime).reversed())
                .collect(Collectors.toList());
    }

    @PostMapping("/getOrderDetails")
    public List<OrderVO> getOrderDetails(@RequestBody User user) throws Exception {

        long startTime = System.currentTimeMillis();
        List<OrderVO> orderVOList;
        orderVOList = multiThread(orderVOS);
        long endTime = System.currentTimeMillis();
        System.out.println("执行时间:" + (endTime - startTime) + "ms");
        try {
            executionTask("请求");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return orderVOList;

    }


    private List<OrderVO> singleThread(List<OrderVO> orders) {
        List<OrderVO> result = new ArrayList<>(orders);
        for (OrderVO orderVO : result) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (User user : users) {
                if (orderVO.getUserId().equals(user.getId())) {
                    orderVO.setUserName(user.getUserName());
                    break;
                }
            }
        }
        return result;

    }


    private List<OrderVO> multiThread(List<OrderVO> orders) throws Exception {
        ThreadPoolExecutor executor = ThreadPoolExecutors.getSingletonExecutor();
        int unitLength = orders.size() / ThreadPoolExecutors.getQueueSize() + 1;
        int synchroniseCount = orders.size() / unitLength;
        synchroniseCount = orders.size() % unitLength == 0 ? synchroniseCount : synchroniseCount + 1;
        SynchroniseUtil<OrderVO> synchroniseUtil = new SynchroniseUtil<>(synchroniseCount);
        System.out.println("任务数:" + synchroniseCount);

        for (int i = 0; i < orders.size(); i += unitLength) {
            int toIndex = Math.min(i + unitLength, orders.size() - 1);
            List<OrderVO> orderVOSubList = orders.subList(i, toIndex);
            OrderTask orderTask = new OrderTask(orderVOSubList, users, synchroniseUtil);
            executor.execute(orderTask);
        }

        List<OrderVO> list = null;
        try {
            list = synchroniseUtil.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        if (list != null) {
            list = list.stream()
                    .sorted(Comparator.comparing(OrderVO::getCreateTime).reversed())
                    .collect(Collectors.toList());
        }
        return list;
    }


    private String executionTask(final String taskName) throws ExecutionException, InterruptedException {
        while (true) {
            Future<String> future = taskCache.get(taskName); // 1.1,2.1
            if (future == null) {
                Callable<String> task = () -> taskName;
                FutureTask<String> futureTask = new FutureTask<>(task);
                future = taskCache.putIfAbsent(taskName, futureTask); // 1.3
                if (future == null) {
                    future = futureTask;
                    futureTask.run(); // 1.4执行任务
                }
            }
            try {
                return future.get(); // 1.5,
            } catch (CancellationException e) {
                taskCache.remove(taskName, future);
            }
        }
    }

}
