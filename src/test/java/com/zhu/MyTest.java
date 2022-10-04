package com.zhu;

import com.zhu.domain.entity.User;
import com.zhu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author xiaozhu
 * @date 2022年10月04日 0:17                          $
 */
@SpringBootTest(classes = Application.class)
public class MyTest {


    @Autowired
    private UserMapper userMapper;


    @Test
    public void test() {

        List<User> userList = userMapper.selectList(null);

        for (User user : userList) {
            System.out.println(user);
        }
    }



}

