package IO;

/**
 * @author liweihua
 * @classname Jad2Java
 * @description TODO
 * @date 2023/8/22 16:53
 */

import java.io.*;

/**
 * 编写一个程序，将d:\java目录下的所有.java文件复制到d:\jad目录下，并将原来文件的扩展名从.java改为.jad。
 */
public class Jad2Java {
    public static void main(String[] args) throws Exception {
        File srcDir = new File("java");
        if (!srcDir.exists() && srcDir.isDirectory()) {
            throw new Exception("目录不存在");
        }
        File[] files = srcDir.listFiles(
                new FilenameFilter() {

                    public boolean accept(File dir, String name) {
                        return name.endsWith(".java");
                    }

                }
        );
        System.out.println(files.length);
        File desDir = new File("jad");
        if (!desDir.exists()) {
            desDir.mkdir();
        }
        for (File file : files) {
            FileInputStream fis = new FileInputStream(file);
            String destFileName = file.getName().replaceAll(".java$", ".jad");
            FileOutputStream fos = new FileOutputStream(new File(desDir, destFileName));
            copy(fis, fos);
            fis.close();
            fos.close();
        }
    }

    private static void copy(InputStream ips, OutputStream ops) throws Exception {
        int len = 0;
        byte[] buf = new byte[1024];
        while ((len = ips.read(buf)) != -1) {
            ops.write(buf, 0, len);
        }
    }
}
