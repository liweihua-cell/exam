package helloController;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(javax.servlet.FilterConfig filterConfig) {
        System.out.println("MyFilter.init");
        System.out.println("  过滤器名：" + filterConfig.getFilterName());
    }

    @Before(value = "org.springframework.web.bind.annotation.RequestMapping")
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("1111111111111111111111111111111111" + joinPoint.getSignature());
        System.out.println("2222222222222222222222222222222222" + joinPoint.getSourceLocation());
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        // do something 处理request 或response
        System.out.println("MyFilter.doFilter");

        if (servletRequest instanceof HttpServletRequest) {
            System.out.println("  URL:" + ((HttpServletRequest) servletRequest).getRequestURL());
        }

        // 调用filter链中的下一个filter
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter.destroy");
    }
}