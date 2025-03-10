package Mongodb;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liweihua
 * @classname StudentDao
 * @description TODO
 * @date 2023/9/13 14:57
 */

public interface StudentDao {
    void save(Student student);

    void update(Student student);

    List<Student> findAll();

    void delete(Integer id);
}
