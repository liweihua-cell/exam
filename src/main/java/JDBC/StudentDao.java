package JDBC;

import java.util.List;
import java.util.Map;

/**
 * @author liweihua
 * @classname StudentDao
 * @description TODO
 * @date 2023/9/4 9:52
 */
public interface StudentDao {
    public void addStudent(Student student);

    public List<Student> queryStudent(String name);
}
