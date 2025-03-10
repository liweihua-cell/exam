import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import lazy.Person;
import mybatisPlus.User;
import mybatisPlus.UserMapper;
import mybatisPlus.UserVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.*;

/**
 * @author liweihua
 * @classname MpApplicationTests
 * @description TODO
 * @date 2023/6/19 9:15
 */
@MapperScan("mybatisPlus,lazy")
@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MpApplicationTests {
    UserMapper userMapper;

    @Test
    public void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void insert() {
        User user = new User();
        user.setName("李华");
        user.setAge(23);
        user.setEmail("12314352@qq.com");
        int insert = userMapper.insert(user);
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(2);
        user.setAge(32);
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    public void testDeleteById() {
        userMapper.deleteById(1);
    }

    @Test
    public void testDeleteBatchId() {
        userMapper.deleteBatchIds(Arrays.asList(1, 2, 3));
    }

    @Test
    public void testDeleteMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        userMapper.deleteByMap(map);
    }


    @Test
    public void testDelete() {
        int i = userMapper.deleteById(2);
    }

    @Test
    public void testPage() {
        Page<User> page = new Page<>(1, 2);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }

    @Test
    public void testGetUsers() {
        List<UserVO> allUsers = userMapper.getAllUsers();
        allUsers.forEach(System.out::println);
    }

    @Test
    public void testGetUsersByPage() {
        Page<UserVO> page = new Page<>(2, 2);
        QueryWrapper<UserVO> wrapper = new QueryWrapper<>();
        wrapper.likeRight("a.name", "java");
        userMapper.getUserByPage(page, wrapper);
        page.getRecords().forEach(System.out::println);
    }

    @Test
    public void testWrapper01() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name").isNotNull("create_time").gt("age", 12);
    }

    @Test
    public void testWrapper02() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 12, 23);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testWrapper03() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.likeRight("name", "java");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void InitializingTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        InitializingBeanTest bean = applicationContext.getBean(InitializingBeanTest.class);
        System.out.println(bean);
        applicationContext.registerShutdownHook();
    }

    @Test
    public void getFile() throws IOException, ClassNotFoundException {

        User user = new User();
        user.setAge(10);
        user.setName("李华");
        user.setCreateTime(new Date());
        //将一个对象实例化后，进行序列化，再反序列化，也可以获得一个对象（远程通信的场景下使用）
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:/data.txt"));
//序列化对象
        out.writeObject(user);
        out.close();
//反序列化对象
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:/data.txt"));
        User user2 = (User) in.readObject();
        System.out.println("反序列化user：" + user2);
        in.close();
    }

    @Test
    public void compare() {
        List<User> arrayList = new ArrayList<>();
        long id = 10L;
        Integer age = 12;
        for (int i = 0; i < 3; i++) {
            id += 1;
            age += 1;
            User user = new User();
            user.setId(id);
            user.setAge(age);
            arrayList.add(user);
        }
        Set set = new HashSet();
        set.add("fsdf");
        set.add("sffsd");
        set.add("fsdf");

        System.out.println(JSONObject.toJSONString(arrayList));
        System.out.println(JSONObject.toJSONString(set));
        System.out.println(Collections.unmodifiableList(arrayList));
    }
}
