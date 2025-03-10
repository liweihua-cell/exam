package order.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author liweihua
 * @classname SynchroniseUtil
 * @description TODO
 * @date 2023/6/8 16:48
 */
public class SynchroniseUtil<T> {
    private CountDownLatch countDownLatch;
    private final List<T> resultList = Collections.synchronizedList(new ArrayList<>());

    private T result;

    public SynchroniseUtil(int count) {
        this.countDownLatch = new CountDownLatch(count);
    }

    public T getResult() throws InterruptedException {
        countDownLatch.await();
        return this.result;
    }

    public List<T> get() throws InterruptedException {
        countDownLatch.await();
        return this.resultList;
    }

    public List<T> get(long timeout, TimeUnit timeUnit) throws Exception {
        if (countDownLatch.await(timeout, timeUnit)) {
            return this.resultList;
        } else {
            throw new RuntimeException("超时");
        }
    }

    public void addResult(T resultMember) {
        resultList.add(resultMember);
        countDownLatch.countDown();
    }

    public void addResult(List<T> resultMembers) {
        resultList.addAll(resultMembers);
        countDownLatch.countDown();
    }

    public void setResult(T result) {
        this.result = result;
        countDownLatch.countDown();
    }
}
