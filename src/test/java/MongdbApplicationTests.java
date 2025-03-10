import Mongodb.Student;
import Mongodb.StudentDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liweihua
 * @classname MongdbApplicationTests
 * @description TODO
 * @date 2023/9/13 15:23
 */
@SpringBootTest
@ContextConfiguration(locations = {"classpath:application.yml"})
public class MongdbApplicationTests {
    @Resource
    private StudentDao studentDao;

    /**
     * 查询所有信息
     */
    @Test
    public void findAll() {
        List<Student> all = studentDao.findAll();
        System.out.println(all.size());
    }

    /**
     * 新增信息
     */
    @Test
    public void save() {
        Student student = new Student();
        student.setId(6l);
        student.setName("宋人头");
        studentDao.save(student);
    }

    /**
     * 修改信息
     */
    @Test
    public void update() {
        Student student = new Student();
        student.setId(2l);
        student.setName("吴很帅");
        studentDao.update(student);
    }

    /**
     * 删除信息
     */
    @Test
    public void delete() {
        studentDao.delete(3);
    }
}
