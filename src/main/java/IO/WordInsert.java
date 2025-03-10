package IO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author liweihua
 * @classname WordInsert
 * @description TODO
 * @date 2023/8/22 14:58
 */

/**
 * 编写一个程序，将a.txt文件中的单词与b.txt文件中的单词交替合并到c.txt文件中，a.txt文件中的单词用回车符分隔，b.txt文件中用回车或空格进行分隔
 */
public class WordInsert {
    public static void main(String[] args) throws Exception {
        FileManager a = new FileManager("D:\\test.txt", new char[]{'\n'});
        FileManager b = new FileManager("D:\\data.txt", new char[]{'\n', ' '});
        FileWriter c = new FileWriter("D:\\c.txt");
        String aWord = null;
        String bWord = null;
        while ((aWord = a.nextWord()) != null) {
            c.write(aWord + "\n");
            bWord = b.nextWord();
            if (bWord != null)
                c.write(bWord + "\n");
        }

        while ((bWord = b.nextWord()) != null) {
            c.write(bWord + "\n");
        }
        c.close();
    }

}


class FileManager {

    String[] words = null;
    int pos = 0;

    public FileManager(String filename, char[] seperators) throws Exception {
        File f = new File(filename);
        FileReader reader = new FileReader(f);
        char[] buf = new char[(int) f.length()];
        int len = reader.read(buf);
        String results = new String(buf, 0, len);
        String regex = null;
        if (seperators.length > 1) {
            regex = "" + seperators[0] + "|" + seperators[1];
        } else {
            regex = "" + seperators[0];
        }
        words = results.split(regex);
    }

    public String nextWord() {
        if (pos == words.length)
            return null;
        return words[pos++];
    }
}
