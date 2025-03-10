package helloController;

import org.aspectj.lang.annotation.Before;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/test1")
    public User test1(User user) {
        System.out.println("HelloController.test1");
        return user;
    }
}