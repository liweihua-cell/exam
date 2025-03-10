package JDBC;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import java.util.List;

/**
 * @author liweihua
 * @classname JdbcTest
 * @description TODO
 * @date 2023/9/4 9:32
 */
public class JdbcTest {
    @Test
    public void addStudent() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentImpl studentimpl = context.getBean(StudentImpl.class);
        Student student = new Student();
        student.setSid(12);
        student.setSname("李华");
        student.setSage(32);
        student.setClassid(11);
        studentimpl.addStudent(student);
    }

    @Test
    public void queryStudent() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentImpl studentImpl = context.getBean(StudentImpl.class);
        List<Student> students = studentImpl.queryStudent("李华");
        System.out.println(JSONObject.toJSONString(students));
    }
}
