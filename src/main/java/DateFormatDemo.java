import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author liweihua
 * @classname DateFormatDemo
 * @description TODO
 * @date 2023/6/13 11:27
 */
public class DateFormatDemo {
    public static void main(String[] args) {
        Callable<Date> task = new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return dateFormat.parse("2023-06-13 11:28:59");
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<Date>> results = new ArrayList<Future<Date>>();
        for (int i = 0; i < 10; i++) {
            results.add(executorService.submit(task));
        }
        executorService.shutdown();

        for (Future<Date> result : results) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
