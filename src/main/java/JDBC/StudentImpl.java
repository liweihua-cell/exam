package JDBC;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liweihua
 * @classname StudentImpl
 * @description TODO
 * @date 2023/9/4 9:52
 */

@Repository
public class StudentImpl implements StudentDao {
    //按类型、自动注入了JdbcTemplate对象（jdbcTemplate即已经是有实体的对象了）
    //JdbcTemplate对象对象里有增删查改的方法，用来操作数据库
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addStudent(Student student) {
        //创建添加的sql语句
        String addsql = "insert into student values(?,?,?,?)";
        Object[] data = {student.getSid(), student.getSname(), student.getSage(), student.getClassid()};
        int update = jdbcTemplate.update(addsql, data);
        System.out.println(update);

    }

    @Override
    public List<Student> queryStudent(String name) {
        String querysql = "select *  from student where name=?";
        List<Student> map = jdbcTemplate.query(querysql, new BeanPropertyRowMapper<Student>(Student.class), name);
        System.out.println(JSONObject.toJSONString(map));
        return map;
    }
}
