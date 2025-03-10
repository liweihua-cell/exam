package helloController;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RequestMappingAspect {
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around1(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[RequestMappingAspect.around1]: around before");
        Object object = joinPoint.proceed();
        System.out.println("[RequestMappingAspect.around1]: around after");

        return object;
    }
}