import Config.Person;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @author liweihua
 * @classname Test
 * @description TODO
 * @date 2022/11/24 9:46
 */
public class TestClass implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map valueMap = Collections.synchronizedMap(new HashMap<>());


    public static Object handler() {
        try {
            System.out.println("try：内（前）");
//            System.out.println("try：内（异常）" + 5 / 0);
//            System.out.println("try：内（后）");

            return "try：返回";
        } catch (Exception e) {
            System.out.println("catch：内（前）");
            System.out.println("catch：内（异常）" + 5 / 0);
            System.out.println("catch：内（后）");

            return "catch：返回";
        } finally {
            System.out.println("finally：内");
            return "finally：返回";
        }
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> stringStringMap = new HashMap<>(2);
        stringStringMap.put("sda", "e32");
        stringStringMap.put("234", "e32");
        stringStringMap.put("54534", "e32");
        stringStringMap.put("432424", "e32");
        System.out.println(stringStringMap);
        System.out.println(Runtime.getRuntime().availableProcessors());


        ThreadLocal threadLocal = new ThreadLocal();
        System.out.println(threadLocal.hashCode());
        String[] arr = {"zs", "ls", "ww"};
        List<String> list = Arrays.asList(arr);
        System.out.println(list);

        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("张三");
        list1.add("李四");
        list1.add("王五");
        String[] arr1 = list1.toArray(new String[list1.size()]);
        System.out.println(arr1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }

        FileReader fileReader = new FileReader("D:\\工具套餐\\elasticsearch\\操作教程.txt");
        BufferedReader br = new BufferedReader(fileReader);
        while (br.ready()) {
            System.out.println(br.readLine());
        }

        LocalDateTime ldt1 = LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String strDate2 = ldt1.format(dtf2);
        System.out.println(strDate2);

        String str1 = "asdgaf";
        StringBuilder stringBuilder = new StringBuilder(str1);
        System.out.println(stringBuilder.reverse());

        char[] abc = new char[10];
        abc[1] = '1';
        System.out.println(abc[1]);

        Set<Person> set = new HashSet<>();
        set.add(new Person("张三", 13));
        set.add(new Person("张三", 13));
        set.add(new Person("李四", 14));
        set.add(new Person("王五", 15));
        System.out.println(set);
        set = set.stream().filter(vo -> vo.getAge().equals(15))
                .collect(Collectors.toSet());
        System.out.println(set);

        String a = "12";
        System.out.println(a.hashCode());
        a = a + "3";
        System.out.println(a.hashCode());
        System.out.println(2 << 3);

        LocalDate localDate = LocalDate.now();
        String str = "1995-07-01";
        System.out.println((localDate.getYear() - Integer.parseInt(str.substring(0, 4))));

        Object handler = handler();
        System.out.println(handler.toString());

    }


    @Test
    public void test1() {
        //1. 分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println("-----------------allocate()----------------");
        System.out.println(buf.position());// 0: 表示当前的位置为0
        System.out.println(buf.limit());// 1024: 表示界限为1024，前1024个位置是允许我们读写的
        System.out.println(buf.capacity());//1024：表示容量大小为1024

        //2. 利用 put() 存入数据到缓冲区中
        System.out.println("-----------------put()----------------");
        String str = "itheima";
        buf.put(str.getBytes());
        System.out.println(buf.position());// 7表示下一个可以写入的位置是7,因为我们写入的字节是7个,从0开始已经写了7个，位置为8的position为7
        System.out.println(buf.limit());// 1024：表示界限为1024，前1024个位置是允许我们读写的
        System.out.println(buf.capacity());//1024：表示容量大小为1024

        //3. 切换读取数据模式
        System.out.println("-----------------flip()----------------");
        buf.flip();
        System.out.println(buf.position());// 0: 读取的起始位置为0
        System.out.println(buf.limit());// 7: 表示界限为7，前7个位置有数据可以读取
        System.out.println(buf.capacity());// 1024:表示容量大小为1024

        //4. 利用 get() 读取缓冲区中的数据
        System.out.println("-----------------get()----------------");
        byte[] dst = new byte[buf.limit()];//创建一个界限为limit大小的字节数组
        buf.get(dst);//批量将limit大小的字节写入到dst字节数组中
        System.out.println(new String(dst, 0, dst.length));//结果为itheima

        System.out.println(buf.position());//7: 读取的位置变为7,因为前面的7个字节数据已经全部读取出去,下一个可读取的位置为7，从0开始的
        System.out.println(buf.limit());//7: 可读取的界限大小为7
        System.out.println(buf.capacity());// 1024: 表示容量大小为1024

        //5. rewind() : 可重复读
        System.out.println("-----------------rewind()----------------");
        buf.rewind();// 将位置设为为 0,从头开始读取
        System.out.println(buf.position());// 0
        System.out.println(buf.limit());// 7
        System.out.println(buf.capacity());// 1024

        //6. clear() : 清空缓冲区. 但是缓冲区中的数据依然存在，但是处于“被遗忘”状态
        System.out.println("-----------------clear()----------------");
        buf.clear();
        System.out.println(buf.position());// 0
        System.out.println(buf.limit());// 1024
        System.out.println(buf.capacity());// 1024
        System.out.println((char) buf.get());//i

    }

    @Test
    public void test2() {
        String str = "itheima";

        ByteBuffer buf = ByteBuffer.allocate(1024);

        buf.put(str.getBytes());// 将str写入到buf缓冲区中

        buf.flip();//转换为读模式

        byte[] dst = new byte[buf.limit()];//定义一个字节数组
        buf.get(dst, 0, 2);//将前2个字节批量写入到dst字节数组中
        System.out.println(new String(dst, 0, 2));//打印结果为it
        System.out.println(buf.position());//当前下一个读取的位置为2

        //mark() : 标记
        buf.mark();

        buf.get(dst, 2, 2);//从第3个位置开始将2个字节批量写入到dst字节数组中
        System.out.println(new String(dst, 2, 2));//打印结果为he
        System.out.println(buf.position());// 当前下一个读取的位置为4

        //reset() : 恢复到 mark 的位置
        buf.reset();
        System.out.println(buf.position());// 2

        //判断缓冲区中是否还有剩余数据
        if (buf.hasRemaining()) {
            //获取缓冲区中可以操作的数量
            System.out.println(buf.remaining());// 5: 返回 position 和 limit 之间的元素个数
        }
    }

    @Test
    public void test3() {
        //分配直接缓冲区
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);
        System.out.println(buf.isDirect());
    }


    @Test
    public void test4() {
        Thread thread = Thread.currentThread();
        Object o = valueMap.get(thread);
        if (o == null && !valueMap.containsKey(thread)) {
            o = null;
            valueMap.put(thread, o);
        }
        System.out.println(valueMap.get(thread));
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        System.out.println(lock.getHoldCount());
    }


}
