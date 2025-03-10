package exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.lang.annotation.Annotation;

/**
 * @author liweihua
 * @classname SpringException
 * @description TODO
 * @date 2023/8/29 11:17
 */
public class SpringException implements ControllerAdvice {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String[] value() {
        return new String[0];
    }

    @Override
    public String[] basePackages() {
        return new String[0];
    }

    @Override
    public Class<?>[] basePackageClasses() {
        return new Class[0];
    }

    @Override
    public Class<?>[] assignableTypes() {
        return new Class[0];
    }

    @Override
    public Class<? extends Annotation>[] annotations() {
        return new Class[0];
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
