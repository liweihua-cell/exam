package cookie;

/**
 * @author liweihua
 * @classname MainServlet
 * @description TODO
 * @date 2023/9/12 10:26
 */

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应类型
        response.setContentType("text/html;charset=utf-8");
        //得到用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //判断是否登录成功
        if ("root".equals(username) && "root".equals(password)) {
            //编写cookie
            Cookie usernameCookie = new Cookie("username", username);
            Cookie passwordCookie = new Cookie("password", password);
            //设置有效时间，我这里设置3天有效
            usernameCookie.setMaxAge(60 * 60 * 24 * 3);
            passwordCookie.setMaxAge(60 * 60 * 24 * 3);
            //存入客户端
            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
            //返回提示
            response.getWriter().write("<h1>登录成功~~~~</h1>");
        } else {
            response.getWriter().write("<h1>登录失败....</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
