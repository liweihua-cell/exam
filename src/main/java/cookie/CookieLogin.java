package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liweihua
 * @classname CookieLogin
 * @description TODO
 * @date 2023/9/12 10:25
 */
@WebServlet("/cookieLogin")
public class CookieLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置默认值
        request.setAttribute("username", "");
        request.setAttribute("password", "");
        //得到所有cookie
        Cookie[] cookies = request.getCookies();
        //对所有cookie进行遍历
        for (Cookie cookie : cookies) {
            //得到存储用户名和密码的cookie并且存入request域中
            if ("username".equals(cookie.getName())) {
                String value = cookie.getValue();
                request.setAttribute("username", value);
            }
            if ("password".equals(cookie.getName())) {
                String value = cookie.getValue();
                request.setAttribute("password", value);
            }
        }
        //转发到login.jsp页面
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

