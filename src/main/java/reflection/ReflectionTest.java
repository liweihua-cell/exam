package reflection;

import com.alibaba.fastjson.JSONObject;
import lazy.User;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liweihua
 * @classname ReflectionTest
 * @description TODO
 * @date 2023/9/6 9:33
 */
public class ReflectionTest implements Serializable {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, ClassNotFoundException, IOException {
        //获取 Person 类的 Class 对象
        Class<?> clazz = Class.forName("reflection.Person");
        //使用.newInstane 方法创建对象

        Person person = (Person) clazz.newInstance();
        person.setAge(22);
        person.setName("lihua");
        person.setPhone("15957813595");
        System.out.println(JSONObject.toJSONString(person));
        System.out.println(person);


        //将一个对象实例化后，进行序列化，再反序列化，也可以获得一个对象（远程通信的场景下使用）
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:/person.txt"));
        //序列化对象
        outputStream.writeObject(person);
        outputStream.close();
        //反序列化对象
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:/person.txt"));
        Person person1 = (Person) inputStream.readObject();
        System.out.println(JSONObject.toJSONString(person1));
        System.out.println("反序列化person:" + person1);
        inputStream.close();


    }


}
