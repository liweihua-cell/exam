package threadTest;

/**
 * @author liweihua
 * @classname MyTask
 * @description TODO
 * @date 2023/6/13 14:00
 */
public class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task" + taskNum);
        while (true) ;
    }
}
