package reflection;

import lazy.User;

import java.io.Serializable;

/**
 * @author liweihua
 * @classname Person
 * @description TODO
 * @date 2023/9/6 9:32
 */
public class Person implements Serializable {
    private String name;
    private String phone;
    private Integer age;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }


    public void setAge(Integer age) {
        this.age = age;
    }
}
