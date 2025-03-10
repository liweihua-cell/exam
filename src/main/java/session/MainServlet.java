package session;

/**
 * @author liweihua
 * @classname MainServlet
 * @description TODO
 * @date 2023/9/12 11:01
 */

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/mainPage")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应的MIME类型和编码
        response.setContentType("text/html;charset=utf-8");
        //得到session
        HttpSession session = request.getSession();
        //取出用户名
        Object username = session.getAttribute("username");
        PrintWriter writer = response.getWriter();
        //判断用户名是否存在
        if (username != null) {
            //在一天内登录过，无需再次登录
            writer.write("<h1>用户：" + username + " 登录成功</h1>");
        } else {
            //没有登录，或者登录间隔大于1天。重定向到登陆界面
            response.sendRedirect(request.getContextPath() + "/login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
