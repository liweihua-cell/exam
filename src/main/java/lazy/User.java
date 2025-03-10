package lazy;

import lombok.Data;

/**
 * @author liweihua
 * @classname User
 * @description TODO
 * @date 2023/6/21 9:47
 */
@Data
public class User {
    private String name;
    private String phone;
    private Integer age;
    private Person person;

    public User(String name, String phone, Integer age) {
        System.out.println("我User被初始化了.............");
        this.name = name;
        this.phone = phone;
        this.age = age;
    }
}
