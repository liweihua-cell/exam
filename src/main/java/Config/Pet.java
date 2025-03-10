package Config;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liweihua
 * @classname Pet
 * @description TODO
 * @date 2022/11/28 14:04
 */
@Data
@NoArgsConstructor
public class Pet {
    public static String a = "1432";
    public String name;
    public Integer age;

    public static void getString() {
        return;
    }
}
