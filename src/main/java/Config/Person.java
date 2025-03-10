package Config;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liweihua
 * @classname Person
 * @description TODO
 * @date 2022/11/28 14:02
 */
@Data
@NoArgsConstructor
public class Person {
    public String name;
    public Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
