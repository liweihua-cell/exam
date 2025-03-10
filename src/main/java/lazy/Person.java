package lazy;

/**
 * @author liweihua
 * @classname Person
 * @description TODO
 * @date 2023/6/21 9:48
 */
public class Person {
    private String name;
    private String phone;
    private Integer age;
    private User user;

    public Person(String name, String phone, Integer age) {
        System.out.println("我Person被初始化了.............");
        this.name = name;
        this.phone = phone;
        this.age = age;
    }
}
