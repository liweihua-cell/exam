package fileReader;

import cn.hutool.core.util.IdUtil;

import java.io.*;
import java.util.Scanner;

/**
 * @author liweihua
 * @classname FileReader
 * @description TODO
 * @date 2023/10/23 10:57
 */
public class FileReaderUtils {

    public static void main(String[] args) throws IOException {
        testCode();
        method1();
        method2();
        method3();
    }

    public static void method1() throws IOException {
        FileReader fileReader = new FileReader("D:\\工具套餐\\elasticsearch\\操作教程.txt");
        BufferedReader bufferReader = new BufferedReader(fileReader);
        while (bufferReader.ready()) {
            System.out.println(bufferReader.readLine());
        }
    }

    public static void method2() throws IOException {
        String encoding = "GBK";
        File file = new File("D:\\工具套餐\\elasticsearch\\操作教程.txt");
        if (file.isFile() && file.exists()) {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file), encoding);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String lineText = null;
            while ((lineText = bufferedReader.readLine()) != null) {
                System.out.println(lineText);
            }
            reader.close();
        } else {
            System.out.println("该文件不存在");
        }
    }

    public static void method3() throws FileNotFoundException {
        Scanner in = new Scanner(new File("D:\\工具套餐\\elasticsearch\\操作教程.txt"));
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
    }

    public static void testCode() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\工具套餐\\elasticsearch\\操作教程.txt"));
        int p = (bufferedInputStream.read() << 8) + bufferedInputStream.read();
        String code = null;
        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }
        System.out.println(String.format("测试文件的格式是:") + code);
    }
}
