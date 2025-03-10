package session;

/**
 * @author liweihua
 * @classname CheckServlet
 * @description TODO
 * @date 2023/9/12 11:01
 */

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/*https://blog.csdn.net/m0_51545690/article/details/123384986*/
@WebServlet("/checkLogin")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //判断用户名和密码是否为我们设置的密码
        if (username.equals("tom") && password.equals("tom123")) {
            //得到session
            HttpSession session = request.getSession();
            //设置最长访问间隔时间
            session.setMaxInactiveInterval(60 * 60 * 24);
            //将用户名存入session
            session.setAttribute("username", username);
            //重定向到主页面
            response.sendRedirect(request.getContextPath() + "/mainPage");
        } else {
            //设置MIME类型和编码
            response.setContentType("text/html;charset=utf-8");
            //写回提示信息
            PrintWriter writer = response.getWriter();
            writer.write("<h1>账号或密码错误</h1>");
            writer.write("<h3><a href='" + request.getContextPath() + "/login.html'>点击重新登录</a></h3>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}