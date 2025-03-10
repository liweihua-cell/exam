package helloController;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author liweihua
 * @classname GlobalControllerAdvice
 * @description TODO
 * @date 2023/6/14 14:57
 */
@ControllerAdvice
public class GlobalControllerAdvice {
    @ModelAttribute
    public void authenticationUser() {
        System.out.println("GlobalControllerAdvice.authenticationUser");
    }
}
