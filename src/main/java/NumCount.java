/**
 * @author liweihua
 * @classname NumCount
 * @description TODO
 * @date 2023/8/23 10:42
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * 有一个字符串，其中包含中文字符、英文字符和数字字符，请统计和打印出各个字符的个数
 */
public class NumCount {


    public static void main(String[] args) throws Exception {
        String content = "中国aadf的111萨bbb菲的zz萨菲";
        HashMap map = new HashMap();
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            Integer num = (Integer) map.get(c);
            if (num == null)
                num = 1;
            else
                num = num + 1;
            map.put(c, num);
            System.out.println(c+"=="+map.get(c));
        }
        for (Object o : map.entrySet()) {
            Object o1 = map.get(o);
            System.out.println(o+"====="+o1);
        }

    }


}
