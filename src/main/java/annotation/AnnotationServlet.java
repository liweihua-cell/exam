package annotation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liweihua
 * @classname AnnotationServlet
 * @description TODO
 * @date 2023/9/12 9:52
 */
/*@WebServlet注解等效于servlet配置文件
* name 和 <servlet-name>hi</servlet-name> 是等效的
value 和 urlPatterns属性 是等效的（就是一样的效果），但是不可以同时使用
urlPattern和 <url-pattern >/hi</url-pattern>是等效的*/
@WebServlet(name = "AnnotationServlet", value = "/abc")
public class AnnotationServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("刚好遇见你");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("刚好遇见你鸭");
    }
}
